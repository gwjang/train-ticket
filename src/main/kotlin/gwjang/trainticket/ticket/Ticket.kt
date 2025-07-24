package gwjang.trainticket.ticket

import gwjang.trainticket.common.BaseEntity
import gwjang.trainticket.user.User
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import java.util.UUID

@Entity
class Ticket(
    @ManyToOne
    val user: User,
    val trainId: UUID,
    val seatNumber: String,
) : BaseEntity() {
    companion object {
        fun create(
            user: User,
            trainId: UUID,
            seatNumber: String,
        ) = Ticket(
            user = user,
            trainId = trainId,
            seatNumber = seatNumber,
        )
    }
}
