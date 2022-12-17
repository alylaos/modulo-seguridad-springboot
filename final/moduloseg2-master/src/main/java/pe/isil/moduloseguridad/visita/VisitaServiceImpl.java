package pe.isil.moduloseguridad.visita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.moduloseguridad.shared.BasicResponseDTO;

import java.util.List;
import java.util.Optional;

@Service
public class VisitaServiceImpl implements VisitaService{
    @Autowired
    private VisitaRepository visitaRepository;

    @Override
    public BasicResponseDTO createVisita(Visita visita) {
        try {
            Optional<Visita> visitaTemp = visitaRepository.findVisitaByDNI(visita.getDNI());

            if (visitaTemp.isPresent()) {
                return BasicResponseDTO.buildWhenVisitaDNIIsTaken();
            } else {
                visitaRepository.save(visita);
                return BasicResponseDTO.buildWhenVisitaCreatedSuccess();
            }
        } catch (Exception e) {
            return BasicResponseDTO.buildWhenError(e.getMessage());
        }
    }

    @Override
    public BasicResponseDTO updateVisita(Visita visita, Long id) {
        try {
            Visita visitaToUpdate = visitaRepository.findById(id).get();

            visitaToUpdate.setLocal(visita.getLocal());
            visitaToUpdate.setDNI(visita.getDNI());
            visitaRepository.save(visitaToUpdate);

            return BasicResponseDTO.buildWhenSucceed();
        } catch (Exception e) {
            return BasicResponseDTO.buildWhenError("El DNI ya esta en uso.");
        }
    }

    @Override
    public void deleteVisita(Long id) {
        Visita visitaToDelete = visitaRepository.findById(id).get();
        visitaRepository.delete(visitaToDelete);
    }

    @Override
    public Visita getVisitaById(Long id) {
        return visitaRepository.findById(id).get();
    }

    @Override
    public List<Visita> getAllVisitas() {
        return visitaRepository.findAll();
    }
}
