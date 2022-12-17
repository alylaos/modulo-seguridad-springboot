package pe.isil.moduloseguridad.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findAuthUserByEmailAndPassword(String email, String password);

    Optional<AuthUser> findAuthUserByEmail(String email);
}
