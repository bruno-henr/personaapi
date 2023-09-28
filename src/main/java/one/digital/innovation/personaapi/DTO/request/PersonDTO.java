package one.digital.innovation.personaapi.DTO.request;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digital.innovation.personaapi.entity.Phone;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;
    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    private String birthDate;

    @Valid
    @NotEmpty
    private List<Phone> phones;
}
