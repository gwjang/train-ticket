package gwjang.trainticket.ticket

import gwjang.trainticket.common.BaseEntity
import gwjang.trainticket.seat.Seat
import gwjang.trainticket.user.User
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import java.util.UUID

@Entity
class Ticket(
    @ManyToOne
    val user: User,
    val trainId: UUID,
    @OneToOne(mappedBy = "ticket")
    var seat: Seat? = null,
) : BaseEntity() {
    companion object {
        fun create(
            user: User,
            trainId: UUID,
        ) = Ticket(
            user = user,
            trainId = trainId,
        )
    }
}
