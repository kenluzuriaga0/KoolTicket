package nek.koolticket.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import nek.koolticket.dtos.UsuarioDto;
import nek.koolticket.service.UserService;

@RequestMapping("/user")
@RestController
@AllArgsConstructor
public class UserRest {

    private UserService userService;

    @GetMapping("")
    List<UsuarioDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    UsuarioDto getOneById(@PathVariable Integer id){
        return userService.getOneById(id);
    }
}
