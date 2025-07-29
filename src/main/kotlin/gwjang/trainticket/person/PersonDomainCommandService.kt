package gwjang.trainticket.person

import gwjang.trainticket.person.dto.PersonCreateRequest
import org.springframework.stereotype.Service

@Service
class PersonDomainCommandService(
    private val personRepository: IPersonRepository,
) {
    fun create(request: PersonCreateRequest) {
        val person =
            Person.create(
                name = request.name,
            )
        personRepository.save(person)
    }
} 