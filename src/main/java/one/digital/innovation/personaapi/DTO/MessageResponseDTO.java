package one.digital.innovation.personaapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MessageResponseDTO {

    private String message;
}
