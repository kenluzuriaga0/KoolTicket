package nek.koolticket.advice;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;

@RestControllerAdvice
public class CustomExceptionHandler {
    /**
     * Maneja las excepciones de JWT. 
     * No ha iniciado sesion, credenciales invalidad, token expirado y acceso denegado
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleSecurityException(Exception ex){
        ProblemDetail errorDetail = null;
        if(ex instanceof BadCredentialsException){
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401),ex.getMessage());
            errorDetail.setProperty("access_denied_reason", "Authentication Failure");
        }

        if(ex instanceof AccessDeniedException){
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403),ex.getMessage());
            errorDetail.setProperty("access_denied_reason", "Not Authorized");
        }

        if(ex instanceof SignatureException){
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403),ex.getMessage());
            errorDetail.setProperty("access_denied_reason", "JWT Signature not valid");
        }

        if(ex instanceof ExpiredJwtException){
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403),ex.getMessage());
            errorDetail.setProperty("access_denied_reason", "JWT token already expired");
        }
        if (errorDetail == null){
            ex.printStackTrace();
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500),ex.getMessage());
        }
        return errorDetail;
    }

}
