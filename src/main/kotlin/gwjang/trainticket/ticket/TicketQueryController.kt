package gwjang.trainticket.ticket

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("tiket/query")
@RestController
class TicketQueryController(
    private val queryService: TicketDomainQueryService,
)
