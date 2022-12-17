package pe.isil.moduloseguridad.visita;

import pe.isil.moduloseguridad.visita.Visita;
import pe.isil.moduloseguridad.shared.BasicResponseDTO;

import java.util.List;

public interface VisitaService {
    BasicResponseDTO createVisita(Visita visita);

    BasicResponseDTO updateVisita(Visita visita, Long id);

    void deleteVisita(Long id);

    Visita getVisitaById(Long id);

    List<Visita> getAllVisitas();
}
