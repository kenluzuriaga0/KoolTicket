package nek.koolticket.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import nek.koolticket.config.JwtService;
import nek.koolticket.dtos.UserRegisterDto;
import nek.koolticket.models.Roles;
import nek.koolticket.models.Usuario;
import nek.koolticket.repos.UsuariosRepo;
import nek.koolticket.rest.AuthRest.AuthRequest;
import nek.koolticket.rest.AuthRest.AuthResponse;

@Service
@AllArgsConstructor
public class AuthService {

    private final UsuariosRepo userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        Usuario user=userRepository.findTopByUsernameAndEstado(request.username(), true).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();

    }

    public AuthResponse register(UserRegisterDto request) {
        Usuario user = Usuario.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode( request.getPassword()))
            .nombres(request.getFirstname())
            .apellidos(request.getLastname())
            // .role(Roles.USER)
            .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
    }

}