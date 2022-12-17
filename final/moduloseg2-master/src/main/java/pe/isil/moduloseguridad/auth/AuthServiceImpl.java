package pe.isil.moduloseguridad.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.moduloseguridad.shared.BasicResponseDTO;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthUserRepository repository;

    @Override
    public BasicResponseDTO login(String email, String password) {
        try {
            Optional<AuthUser> userToFind = repository.findAuthUserByEmailAndPassword(email, password);

            if (userToFind.isEmpty()) return BasicResponseDTO.buildWhenEmailPasswordIncorrect();
            if (!userToFind.get().getIsActive()) return BasicResponseDTO.buildWhenIsInactive();

            return BasicResponseDTO.buildWhenLoginOk(userToFind.get());
        } catch (Exception e) {
            return BasicResponseDTO.buildWhenError(e.getMessage());
        }
    }

    @Override
    public BasicResponseDTO register(AuthUser authUser) {
        try {
            Optional<AuthUser> userToFind = repository.findAuthUserByEmail(authUser.getEmail());

            if (userToFind.isPresent()) return BasicResponseDTO.buildWhenEmailIsTaken();

            repository.save(authUser);
            return BasicResponseDTO.buildWhenRegisterSucceed();
        } catch (Exception e) {
            return BasicResponseDTO.buildWhenError(e.getMessage());
        }
    }

    @Override
    public BasicResponseDTO recoverPassword(AuthUser user, String email, String password) {
        try {
            Optional<AuthUser> userToUpdate = repository.findAuthUserByEmail(email);

            if (userToUpdate.isEmpty()) return BasicResponseDTO.buildWhenEmailDoesNotExist();
            if (!userToUpdate.get().getIsActive()) return BasicResponseDTO.buildWhenIsInactive();

            userToUpdate.get().setPassword(password);
            repository.save(userToUpdate.get());

            return BasicResponseDTO.buildWhenPasswordRestored();
        } catch (Exception e) {
            return BasicResponseDTO.buildWhenError(e.getMessage());
        }
    }
}
