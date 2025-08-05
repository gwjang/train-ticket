package gwjang.trainticket.seat

import gwjang.trainticket.common.RedissonLock
import org.redisson.api.RedissonClient
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SeatCommandLockService(
    private val seatDomainCommandService: SeatDomainCommandService,
    private val redissonClient: RedissonClient,
) {
    @RedissonLock(
        lockName = "Seat:seatId:{seatId}",
        waitTime = 10L,
        leaseTime = 1L,
    )
    fun reserveWithLock(seatId: UUID): Boolean = seatDomainCommandService.reserve(seatId)
}
