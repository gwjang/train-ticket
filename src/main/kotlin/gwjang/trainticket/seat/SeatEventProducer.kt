package gwjang.trainticket.seat

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SeatEventProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {
    fun publishReservationEvent(seatId: UUID) {
        kafkaTemplate.send("seat-reservation", seatId.toString())
    }
}
