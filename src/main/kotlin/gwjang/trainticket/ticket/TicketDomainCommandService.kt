package gwjang.trainticket.ticket

import gwjang.trainticket.person.PersonQueryService
import gwjang.trainticket.ticket.dto.TicketCreateRequest
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TicketDomainCommandService(
    private val ticketRepository: ITicketRepository,
    private val ticketQueryService: TicketQueryService,
    private val personQueryService: PersonQueryService,
) {
    fun create(request: TicketCreateRequest) {
        val person = personQueryService.findByIdElseThrow(request.personId)
        val ticket =
            Ticket.create(
                person = person,
                trainId = request.trainId,
            )
        ticketRepository.save(ticket)
    }

    fun cancel(id: UUID) {
        val ticket = ticketQueryService.findByIdElseThrow(id)
        ticketRepository.delete(ticket)
    }

    // 대기열 고민
}
