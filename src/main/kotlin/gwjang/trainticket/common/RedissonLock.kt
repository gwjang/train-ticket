package gwjang.trainticket.common

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class RedissonLock(
    val lockName: String = "",
    val waitTime: Long = 10L,
    val leaseTime: Long = 1L,
)
