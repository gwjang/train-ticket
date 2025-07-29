package gwjang.trainticket.seat

import org.redisson.api.RedissonClient
import org.springframework.stereotype.Service
import java.util.UUID
import java.util.concurrent.TimeUnit

@Service
class SeatCommandLockService(
    private val seatDomainCommandService: SeatDomainCommandService,
    private val redissonClient: RedissonClient,
) {
    fun reserveWithLock(seatId: UUID): Boolean {
        val lock = redissonClient.getLock(String.format("Seat:seatId:%s", seatId))

        return try {
            val available = lock.tryLock(10, 1, TimeUnit.SECONDS)
            if (!available) {
                println("redisson lock timeout")
                throw IllegalArgumentException()
            }

            seatDomainCommandService.reserve(seatId)
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        } finally {
            lock.unlock()
        }
    }
}
