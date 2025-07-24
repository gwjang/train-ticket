package gwjang.trainticket.ticket.dto

import java.util.UUID

data class TicketCreateRequest(
    val userId: UUID,
    val trainId: UUID,
    val seatNumber: String,
)
