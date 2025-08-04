package gwjang.trainticket.seat

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SeatEventConsumer(
    private val seatCommandService: SeatDomainCommandService,
) {
    @KafkaListener(topics = ["seat-reservation"], groupId = "seat-consumer")
    fun consume(message: String) {
        val seatId = UUID.fromString(message)
        seatCommandService.reserve(seatId)
        println("Consumed message: $message")
    }
}
