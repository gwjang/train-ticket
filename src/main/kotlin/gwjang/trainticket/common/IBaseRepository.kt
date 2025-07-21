package gwjang.trainticket.common

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.util.UUID

@NoRepositoryBean
interface IBaseRepository<T : BaseEntity> : JpaRepository<T, UUID>
