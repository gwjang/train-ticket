package gwjang.trainticket.user

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserQueryService(
    private val userRepository: IUserRepository,
) {
    fun findByIdElseThrow(id: UUID): User =
        userRepository
            .findById(id)
            .orElseThrow()

    fun findAll(): List<User> = userRepository.findAll()
}
