package nek.koolticket.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import nek.koolticket.dtos.UsuarioDto;
import nek.koolticket.dtos.mappers.ModelsMapper;
import nek.koolticket.models.Usuario;
import nek.koolticket.repos.UsuariosRepo;
import nek.koolticket.service.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthRest {

    @Builder
    public record AuthResponse(String token) {
    }

    public record AuthRequest(String username, String password) {
    }

    private final AuthService authService;
    private final UsuariosRepo userRepository;
    private final ModelsMapper mapper;
    
    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("current")
    public UsuarioDto getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Login: ".concat(authentication.getName()));
        Usuario user = this.userRepository.findTopByUsernameAndEstado(authentication.getName(), true).orElse(null);
        return mapper.mapEntityToDto(user);
    }

}
