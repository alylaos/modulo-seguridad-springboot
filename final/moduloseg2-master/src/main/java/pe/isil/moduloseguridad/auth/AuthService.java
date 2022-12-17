package pe.isil.moduloseguridad.auth;

import pe.isil.moduloseguridad.shared.BasicResponseDTO;

public interface AuthService {
    BasicResponseDTO login(String email, String password);

    BasicResponseDTO register(AuthUser authUser);

    BasicResponseDTO recoverPassword(AuthUser user, String email, String password);
}
