package gwjang.trainticket.user

import gwjang.trainticket.common.BaseEntity
import gwjang.trainticket.ticket.Ticket
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany

@Entity
class User(
    @OneToMany(
        mappedBy = "user",
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
        fetch = FetchType.LAZY,
    )
    val tickets: MutableList<Ticket> = mutableListOf(),
    @Column(nullable = false)
    var name: String,
) : BaseEntity() {
    companion object {
        fun create(name: String): User = User(name = name)
    }
}
