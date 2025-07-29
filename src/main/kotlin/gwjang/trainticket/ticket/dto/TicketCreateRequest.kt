package gwjang.trainticket.ticket.dto

import java.util.UUID

data class TicketCreateRequest(
    val personId: UUID,
    val trainId: UUID,
)
