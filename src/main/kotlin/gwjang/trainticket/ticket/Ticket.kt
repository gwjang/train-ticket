package gwjang.trainticket.ticket

import gwjang.trainticket.common.BaseEntity
import gwjang.trainticket.user.User
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne

@Entity
class Ticket(
    @ManyToOne
    val user: User,
) : BaseEntity() {
    companion object {
        fun create(user: User) = Ticket(user)
    }
}
