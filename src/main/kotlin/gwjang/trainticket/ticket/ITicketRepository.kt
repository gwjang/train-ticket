package gwjang.trainticket.ticket

import gwjang.trainticket.common.IBaseRepository
import org.springframework.stereotype.Repository

@Repository
interface ITicketRepository : IBaseRepository<Ticket>
