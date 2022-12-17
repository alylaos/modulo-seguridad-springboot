package pe.isil.moduloseguridad.auth;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "tbl_auth_user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email", name = "unique_email")
})
@Entity
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean isActive;
    private Date createdAt;

    @PostPersist
    public void postPersist() {
        createdAt = new Date();
        isActive = true;
    }
}
