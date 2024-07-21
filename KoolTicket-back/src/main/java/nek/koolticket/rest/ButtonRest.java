package nek.koolticket.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import nek.koolticket.dtos.BotonDto;
import nek.koolticket.service.BotonService;

@RequestMapping("/button")
@RestController
@AllArgsConstructor
public class ButtonRest {

    private BotonService buttonService ;

    @GetMapping("")
    List<BotonDto> getAllButtons(){
        return buttonService.getAllButtons();
    }

    @GetMapping("{id}")
    BotonDto getOneById(@PathVariable Integer id){
        return buttonService.getOneById(id);
    }
}
