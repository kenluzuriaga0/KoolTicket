package nek.koolticket.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import nek.koolticket.service.SucursalService;

@RequestMapping("/branch")
@RestController
@AllArgsConstructor
public class BranchRest {

    SucursalService sucursalService;

    @GetMapping("")
    public ResponseEntity<?> getAllBranch(){
        return ResponseEntity.ok(sucursalService.findAllSucursalByEstado());
    }


}
