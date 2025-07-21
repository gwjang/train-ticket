package gwjang.trainticket.tiket

import org.springframework.stereotype.Service

@Service
class TiketDomainQueryService(
    private val repository: ITiketRepository,
)
