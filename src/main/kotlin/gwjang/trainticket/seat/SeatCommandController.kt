package gwjang.trainticket.seat

import gwjang.trainticket.seat.dto.SeatCreateRequest
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("seat")
@RestController
class SeatCommandController(
    private val commandService: SeatDomainCommandService,
    private val seatEventProducer: SeatEventProducer,
) {
    @PostMapping("")
    fun create(request: SeatCreateRequest): Seat =
        commandService.create(
            request = request,
        )

    @PostMapping("{id}/reserve")
    fun reserve(
        @PathVariable id: UUID,
    ) {
        commandService.reserve(id)
    }

    @PostMapping("{id}/reserve/publish")
    fun reserveAndPublish(
        @PathVariable id: UUID,
    ) {
        seatEventProducer.publishReservationEvent(id)
    }
}
