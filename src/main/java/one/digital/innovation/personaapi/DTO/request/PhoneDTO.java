package one.digital.innovation.personaapi.DTO.request;



import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digital.innovation.personaapi.enums.PhoneType;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;


@Data // Cria todos os gets e sets
@Builder // Criacao de objetos
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
    private Long id;

    @Enumerated
    private PhoneType type;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;

}
