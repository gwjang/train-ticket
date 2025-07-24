package gwjang.trainticket.user

import gwjang.trainticket.user.dto.UserCreateRequest
import org.springframework.stereotype.Service

@Service
class UserDomainCommandService(
    private val userRepository: IUserRepository,
) {
    fun create(request: UserCreateRequest) {
        val user =
            User.create(
                name = request.name,
            )
        userRepository.save(user)
    }
}
