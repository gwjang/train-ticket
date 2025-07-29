package gwjang.trainticket.seat

import gwjang.trainticket.seat.dto.SeatCreateRequest
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

@SpringBootTest
class SeatDomainCommandServiceTest(
    private val service: SeatDomainCommandService,
    private val seatCommandLockService: SeatCommandLockService,
) : BehaviorSpec({

        Given("여러 사용자가 동시에 좌석 예약 시도할 때") {
            val seat =
                service.create(
                    request =
                        SeatCreateRequest(
                            isReserved = false,
                        ),
                )

            When("100명이 동시에 같은 좌석을 예약한다면") {
                val threadCount = 100
                val latch = CountDownLatch(threadCount)
                val executor = Executors.newFixedThreadPool(threadCount)
                val successCount = AtomicInteger(0)

                repeat(threadCount) {
                    executor.submit {
                        try {
                            if (seatCommandLockService.reserveWithLock(seat.id)) {
                                successCount.incrementAndGet()
                            }
                        } finally {
                            latch.countDown()
                        }
                    }
                }

                latch.await(10, TimeUnit.SECONDS)
                executor.shutdown()

                Then("단 한 명만 예약에 성공해야 한다") {
                    successCount.get() shouldBe 1
                }
            }
        }
    })
