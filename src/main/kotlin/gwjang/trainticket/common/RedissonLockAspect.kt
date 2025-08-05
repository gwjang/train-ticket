package gwjang.trainticket.common

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature
import org.redisson.api.RedissonClient
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Aspect
@Component
class RedissonLockAspect(
    private val redissonClient: RedissonClient,
) {
    @Around("@annotation(redissonLock)")
    fun around(
        joinPoint: ProceedingJoinPoint,
        redissonLock: RedissonLock,
    ): Any? {
        val method = (joinPoint.signature as MethodSignature).method
        val args = joinPoint.args
        val paramNames = method.parameters.map { it.name }

        // #1: lockName 표현식 처리
        var lockKey = redissonLock.lockName
        paramNames.forEachIndexed { i, name ->
            lockKey = lockKey.replace("{$name}", args[i].toString())
        }

        val lock = redissonClient.getLock(lockKey)
        val available =
            lock.tryLock(
                redissonLock.waitTime,
                redissonLock.leaseTime,
                TimeUnit.SECONDS,
            )

        if (!available) {
            throw IllegalStateException("Redisson lock 획득 실패: $lockKey")
        }

        try {
            return joinPoint.proceed()
        } finally {
            if (lock.isHeldByCurrentThread) {
                lock.unlock()
            }
        }
    }
}
