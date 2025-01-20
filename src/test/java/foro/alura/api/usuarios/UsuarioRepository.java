package foro.alura.api.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    UserDetails findByemail(String username);
}
