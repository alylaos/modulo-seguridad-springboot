package pe.isil.moduloseguridad.shared;

import lombok.Builder;
import lombok.Data;
import pe.isil.moduloseguridad.auth.AuthUser;

@Data
@Builder
public class BasicResponseDTO {
    private String code;
    private String message;
    private Object data;

    public static BasicResponseDTO buildWhenLoginOk(AuthUser user) {
        return BasicResponseDTO.builder()
                .code(Constants.CODE_SUCCESSFULLY_LOGGED.getCode())
                .message(Constants.CODE_SUCCESSFULLY_LOGGED.getMessage())
                .data(user)
                .build();
    }

    public static BasicResponseDTO buildWhenSucceed() {
        return BasicResponseDTO.builder()
                .code(Constants.CODE_SUCCEED.getCode())
                .message(Constants.CODE_SUCCEED.getMessage())
                .build();
    }

    public static BasicResponseDTO buildWhenError(String error) {
        return BasicResponseDTO.builder()
                .code(Constants.CODE_ERROR.getCode())
                .message((Constants.CODE_ERROR.getMessage() + " ").concat(error))
                .build();
    }

    public static BasicResponseDTO buildWhenIsInactive() {
        return BasicResponseDTO.builder()
                .code(Constants.CODE_USER_INACTIVATED.getCode())
                .message(Constants.CODE_USER_INACTIVATED.getMessage())
                .build();
    }

    public static BasicResponseDTO buildWhenEmailPasswordIncorrect() {
        return BasicResponseDTO.builder()
                .code(Constants.CODE_ERROR_CREDENTIALS.getCode())
                .message(Constants.CODE_ERROR_CREDENTIALS.getMessage())
                .build();
    }

    public static BasicResponseDTO buildWhenEmailIsTaken() {
        return BasicResponseDTO.builder()
                .code(Constants.CODE_EMAIL_TAKEN.getCode())
                .message(Constants.CODE_EMAIL_TAKEN.getMessage())
                .build();
    }

    public static BasicResponseDTO buildWhenRegisterSucceed() {
        return BasicResponseDTO.builder()
                .code(Constants.CODE_REGISTER_SUCCESSFULLY.getCode())
                .message(Constants.CODE_REGISTER_SUCCESSFULLY.getMessage())
                .build();
    }

    public static BasicResponseDTO buildWhenPasswordRestored() {
        return BasicResponseDTO.builder()
                .code(Constants.CODE_PASSWORD_RESTORED.getCode())
                .message(Constants.CODE_PASSWORD_RESTORED.getMessage())
                .build();
    }

    public static BasicResponseDTO buildWhenEmailDoesNotExist() {
        return BasicResponseDTO.builder()
                .code(Constants.CODE_EMAIL_ERROR.getCode())
                .message(Constants.CODE_EMAIL_ERROR.getMessage())
                .build();
    }

    public static BasicResponseDTO buildWhenVisitaCreatedSuccess() {
        return BasicResponseDTO.builder()
                .code(Constants.CODE_APP_CREATED.getCode())
                .message(Constants.CODE_APP_CREATED.getMessage())
                .build();
    }

    public static BasicResponseDTO buildWhenVisitaDNIIsTaken() {
        return BasicResponseDTO.builder()
                .code(Constants.CODE_APP_NOMBRE_TAKEN.getCode())
                .message(Constants.CODE_APP_NOMBRE_TAKEN.getMessage())
                .build();
    }
}
