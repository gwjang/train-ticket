package gwjang.trainticket.ticket

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TicketQueryService(
    private val ticketRepository: ITicketRepository,
) {
    fun findByIdElseThrow(id: UUID): Ticket =
        ticketRepository
            .findById(id)
            .orElseThrow()

    fun findAll(): List<Ticket> = ticketRepository.findAll()
}
