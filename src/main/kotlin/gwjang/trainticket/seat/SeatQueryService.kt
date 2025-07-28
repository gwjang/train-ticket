package gwjang.trainticket.seat

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SeatQueryService(
    private val seatRepository: ISeatRepository,
) {
    fun findByIdElseThrow(id: UUID): Seat =
        seatRepository
            .findById(id)
            .orElseThrow()

    fun findAll(): List<Seat> = seatRepository.findAll()
}
