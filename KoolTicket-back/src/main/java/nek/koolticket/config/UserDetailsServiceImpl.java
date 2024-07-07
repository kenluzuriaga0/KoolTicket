package nek.koolticket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import nek.koolticket.models.Usuarios;
import nek.koolticket.repos.UsuariosRepo;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    private UsuariosRepo userRepo;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuario = this.userRepo.findTopByUsernameAndEstado(username,true).orElse(null);
        if(usuario==null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return usuario;
    }


}
