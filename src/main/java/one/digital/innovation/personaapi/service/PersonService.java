package one.digital.innovation.personaapi.service;

import lombok.AllArgsConstructor;
import one.digital.innovation.personaapi.DTO.request.PersonDTO;
import one.digital.innovation.personaapi.DTO.response.MessageResponseDTO;
import one.digital.innovation.personaapi.entity.Person;
import one.digital.innovation.personaapi.exception.PersonNotFoundException;
import one.digital.innovation.personaapi.mapper.PersonMapper;
import one.digital.innovation.personaapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);

        return createMessageResponse("Created person with ID ", savedPerson.getId());
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);

        return createMessageResponse("Updated person with ID ", updatedPerson.getId());
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return this.personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private static MessageResponseDTO createMessageResponse(String message, Long id) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
