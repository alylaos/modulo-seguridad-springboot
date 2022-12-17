package pe.isil.moduloseguridad.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Constants {
    CODE_SUCCESSFULLY_LOGGED("200", "Login Exitóso"),
    CODE_SUCCEED("200", "Operación correcta"),
    CODE_ERROR("500", "Ocurrió un error"),
    CODE_USER_INACTIVATED("401", "Usuario inactivo"),
    CODE_ERROR_CREDENTIALS("403", "Usuario o contraseñas incorrectos"),
    CODE_EMAIL_TAKEN("510", "El email ya está registrado"),
    CODE_REGISTER_SUCCESSFULLY("200", "Usuario registrado correctamente"),
    CODE_PASSWORD_RESTORED("200", "Tu contraseña ha sido actualizada"),

    CODE_EMAIL_ERROR("403", "El correo no existe"),


    CODE_NAME_TAKEN("510", "El email ya está registrado"),
    CODE_APP_CREATED("200", "Visita creada exitosamente"),
    CODE_APP_NOMBRE_TAKEN("510", "El DNI ya está registrado");

    @Getter
    private String code;
    @Getter
    private String message;
}
