package gwjang.trainticket.person

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PersonQueryService(
    private val personRepository: IPersonRepository,
) {
    fun findByIdElseThrow(id: UUID): Person =
        personRepository
            .findById(id)
            .orElseThrow()

    fun findAll(): List<Person> = personRepository.findAll()
} 