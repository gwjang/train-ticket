package gwjang.trainticket.ticket

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("ticket/command")
@RestController
class TicketCommandController(
    private val queryService: TicketDomainQueryService,
) {
    @PostMapping
    fun create() {
        // Implementation for creating a ticket
    }

    @PostMapping("/{id}/cancel")
    fun cancel(
        @PathVariable id: UUID,
    ) {
        // Implementation for canceling a ticket
    }

    // 대기열 고민
}
