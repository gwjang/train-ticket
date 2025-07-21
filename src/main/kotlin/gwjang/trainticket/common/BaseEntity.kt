package gwjang.trainticket.common

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import java.util.UUID

@MappedSuperclass
open class BaseEntity(
    @Id
    var id: UUID = UUID.randomUUID(),
    @CreatedDate
    @Column(nullable = false)
    var createdAt: Instant = Instant.now(),
    @CreatedBy
    var createdById: UUID = UUID(0, 0),
    @LastModifiedDate
    @Column(nullable = false)
    var modifiedAt: Instant = Instant.now(),
    @LastModifiedBy
    var modifiedById: UUID = UUID(0, 0),
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "serial", updatable = false, insertable = false)
    var serialNumber: Long = 0,
)
