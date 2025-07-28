package gwjang.trainticket.seat

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("seat/query")
@RestController
class SeatQueryController(
    private val queryService: SeatQueryService,
)
