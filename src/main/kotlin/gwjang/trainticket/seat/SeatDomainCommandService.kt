package gwjang.trainticket.seat

import gwjang.trainticket.seat.dto.SeatCreateRequest
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SeatDomainCommandService(
    private val seatRepository: ISeatRepository,
    private val seatQueryService: SeatQueryService,
) {
    @Transactional
    fun create(request: SeatCreateRequest): Seat {
        val seat =
            Seat.create(
                isReserved = request.isReserved,
            )
        seatRepository.save(seat)
        return seat
    }

    @Transactional
    fun cancel(id: UUID) {
        val seat = seatQueryService.findByIdElseThrow(id)
        seatRepository.delete(seat)
    }

    @Transactional
    fun reserve(seatId: UUID): Boolean {
        val seat = seatQueryService.findByIdElseThrow(seatId)
        if (seat.isReserved) {
            return false
        }
        seat.reserve()
        seatRepository.save(seat)
        Thread.sleep(200) // Simulate delay for reservation
        return true
    }
}
