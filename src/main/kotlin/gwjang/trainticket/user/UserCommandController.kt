package gwjang.trainticket.user

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("user/command")
@RestController
class UserCommandController(
    private val commandService: UserDomainCommandService,
) {
    @PostMapping()
    fun create() {
        // Implementation for creating a user
    }
}
