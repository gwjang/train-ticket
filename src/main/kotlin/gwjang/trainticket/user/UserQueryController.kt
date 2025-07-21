package gwjang.trainticket.user

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("user/query")
@RestController
class UserQueryController(
    private val queryService: UserDomainQueryService,
)
