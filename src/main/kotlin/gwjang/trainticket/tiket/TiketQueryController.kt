package gwjang.trainticket.tiket

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("tiket/query")
@RestController
class TiketQueryController(
    private val queryService: TiketDomainQueryService,
)
