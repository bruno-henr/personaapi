package one.digital.innovation.personaapi.controller;

import jakarta.validation.Valid;
import one.digital.innovation.personaapi.DTO.request.PersonDTO;
import one.digital.innovation.personaapi.DTO.response.MessageResponseDTO;
import one.digital.innovation.personaapi.entity.Person;
import one.digital.innovation.personaapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return this.personService.createPerson(personDTO);
    }

}
