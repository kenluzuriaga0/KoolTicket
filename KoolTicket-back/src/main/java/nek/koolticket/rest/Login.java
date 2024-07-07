package nek.koolticket.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class Login {

    @GetMapping("")
    public String initRest(){
        System.out.println("Hello world");
        return "Rest Aqui";
    }


}
