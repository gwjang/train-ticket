package gwjang.trainticket.seat

import gwjang.trainticket.common.BaseEntity
import gwjang.trainticket.ticket.Ticket
import jakarta.persistence.Entity
import jakarta.persistence.OneToOne

@Entity
class Seat(
    val isAvailable: Boolean = true,
    @OneToOne
    var ticket: Ticket,
) : BaseEntity() {
    companion object {
        fun create(ticket: Ticket): Seat = Seat(isAvailable = true, ticket = ticket)
    }
}
