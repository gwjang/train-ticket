package gwjang.trainticket.seat

import gwjang.trainticket.seat.dto.SeatCreateRequest
import gwjang.trainticket.ticket.TicketQueryService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SeatDomainCommandService(
    private val seatRepository: ISeatRepository,
    private val ticketQueryService: TicketQueryService,
    private val seatQueryService: SeatQueryService,
) {
    fun create(request: SeatCreateRequest) {
        val ticket = ticketQueryService.findByIdElseThrow(request.ticketId)
        val seat =
            Seat.create(
                ticket = ticket,
            )
        seatRepository.save(seat)
    }

    fun cancel(id: UUID) {
        val seat = seatQueryService.findByIdElseThrow(id)
        seatRepository.delete(seat)
    }
}
