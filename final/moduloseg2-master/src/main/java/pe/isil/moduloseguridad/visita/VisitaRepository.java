package pe.isil.moduloseguridad.visita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Long> {
    Optional<Visita> findVisitaByDNI(String local);
}
