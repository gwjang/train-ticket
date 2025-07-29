package gwjang.trainticket.person

import gwjang.trainticket.person.dto.PersonCreateRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("person/command")
@RestController
class PersonCommandController(
    private val commandService: PersonDomainCommandService,
) {
    @PostMapping()
    fun create(request: PersonCreateRequest) {
        commandService.create(
            request = request,
        )
    }
} 