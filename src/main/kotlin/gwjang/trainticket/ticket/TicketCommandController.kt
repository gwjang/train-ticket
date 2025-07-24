package gwjang.trainticket.ticket

import gwjang.trainticket.ticket.dto.TicketCreateRequest
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("ticket/command")
@RestController
class TicketCommandController(
    private val queryService: TicketQueryService,
    private val commandService: TicketDomainCommandService,
) {
    @PostMapping
    fun create(request: TicketCreateRequest) {
        commandService.create(
            request = request,
        )
    }

    @PostMapping("/{id}/cancel")
    fun cancel(
        @PathVariable id: UUID,
    ) {
        // Implementation for canceling a ticket
    }

    // 대기열 고민
}
