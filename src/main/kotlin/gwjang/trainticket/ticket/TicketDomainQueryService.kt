package gwjang.trainticket.ticket

import org.springframework.stereotype.Service

@Service
class TicketDomainQueryService(
    private val repository: ITicketRepository,
)
