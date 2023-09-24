package one.digital.innovation.personaapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teste")
public class Test {

    @GetMapping
    public String teste() {
        return "Olá mundo!";
    }
}
