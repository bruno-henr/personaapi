package one.digital.innovation.personaapi.service;

import one.digital.innovation.personaapi.DTO.request.PersonDTO;
import one.digital.innovation.personaapi.DTO.response.MessageResponseDTO;
import one.digital.innovation.personaapi.entity.Person;
import one.digital.innovation.personaapi.mapper.PersonMapper;
import one.digital.innovation.personaapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
               .builder()
                .message("Created person with ID "+savedPerson.getId())
                .build();
    }
}
