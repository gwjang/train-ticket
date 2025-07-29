package gwjang.trainticket.seat

import gwjang.trainticket.common.BaseEntity
import gwjang.trainticket.ticket.Ticket
import jakarta.persistence.Entity
import jakarta.persistence.OneToOne

@Entity
class Seat(
    var isReserved: Boolean = true,
    @OneToOne
    var ticket: Ticket? = null,
) : BaseEntity() {
    fun reserve() {
        isReserved = true
    }

    companion object {
        fun create(isReserved: Boolean): Seat = Seat(isReserved = isReserved)
    }
}
