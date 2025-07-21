package gwjang.trainticket.user

import org.springframework.stereotype.Service

@Service
class UserDomainQueryService(
    private val repository: IUserRepository,
)
