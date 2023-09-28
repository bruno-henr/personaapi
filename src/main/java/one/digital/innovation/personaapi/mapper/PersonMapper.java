package one.digital.innovation.personaapi.mapper;


import one.digital.innovation.personaapi.DTO.request.PersonDTO;
import one.digital.innovation.personaapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);



    // ´toModel´ é uma convenção do mapScruct
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
