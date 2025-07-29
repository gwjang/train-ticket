package gwjang.trainticket.person

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("person/query")
@RestController
class PersonQueryController(
    private val queryService: PersonQueryService,
) 