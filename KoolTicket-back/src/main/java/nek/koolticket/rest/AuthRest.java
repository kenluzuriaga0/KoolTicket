package nek.koolticket.rest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
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
    
    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

}
