package gwjang.trainticket.ticket

import gwjang.trainticket.common.BaseEntity
import gwjang.trainticket.person.Person
import gwjang.trainticket.seat.Seat
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import java.util.UUID

@Entity
class Ticket(
    @ManyToOne
    val person: Person,
    val trainId: UUID,
    @OneToOne(mappedBy = "ticket")
    var seat: Seat? = null,
) : BaseEntity() {
    companion object {
        fun create(
            person: Person,
            trainId: UUID,
        ) = Ticket(
            person = person,
            trainId = trainId,
        )
    }
}
