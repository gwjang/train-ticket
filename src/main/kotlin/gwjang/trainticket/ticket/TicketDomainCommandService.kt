package gwjang.trainticket.ticket

import gwjang.trainticket.ticket.dto.TicketCreateRequest
import gwjang.trainticket.user.UserQueryService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TicketDomainCommandService(
    private val ticketRepository: ITicketRepository,
    private val ticketQueryService: TicketQueryService,
    private val userQueryService: UserQueryService,
) {
    fun create(request: TicketCreateRequest) {
        val user = userQueryService.findByIdElseThrow(request.userId)
        val ticket =
            Ticket.create(
                user = user,
                trainId = request.trainId,
                seatNumber = request.seatNumber,
            )
        ticketRepository.save(ticket)
    }

    fun cancel(id: UUID) {
        val ticket = ticketQueryService.findByIdElseThrow(id)
        ticketRepository.delete(ticket)
    }

    // 대기열 고민
}
