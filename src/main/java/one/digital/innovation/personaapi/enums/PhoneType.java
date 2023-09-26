package one.digital.innovation.personaapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
//@AllArgsConstructor
public enum PhoneType {
    HOME("Home"),
    MOBILE("Mobile"),
    COMMERCIAL("Comercial");

    private String description;

    private PhoneType(String description) {
        this.description = description;
    }

    public String getPhoneType() {
        return description;
    }
}
