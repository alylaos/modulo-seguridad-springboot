package pe.isil.moduloseguridad.visita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.isil.moduloseguridad.shared.BasicResponseDTO;

import java.util.List;

@Controller
@RequestMapping("/visita")
public class VisitaController {
    @Autowired
    private VisitaService visitaService;

    @GetMapping("/")
    public String index(Model model) {
        List<Visita> visita = visitaService.getAllVisitas();
        model.addAttribute("visitas", visita);

        return "visita/index";
    }

    @GetMapping("/create")
    public String createView(Model model) {
        return "visita/create";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model) {
        Visita visita = visitaService.getVisitaById(id);
        model.addAttribute("visita", visita);
        return "visita/update";
    }

    @PostMapping("/create")
    public String createVisita(Model model, Visita visita) {
        BasicResponseDTO response = visitaService.createVisita(visita);

        if (response.getCode().equals("200")) {
            return "redirect:/visita/";
        } else {
            model.addAttribute("resp", response);
            return "./responseVisita";
        }
    }

    @PostMapping("/update")
    public String updateVisita(Visita visitaToUpdate, Model model) {
        BasicResponseDTO response = visitaService.updateVisita(visitaToUpdate, visitaToUpdate.getId());

        if (response.getCode().equals("200")) {
            return "redirect:/visita/";
        } else {
            model.addAttribute("resp", response);
            return "./responseVisita";
        }
    }

    @DeleteMapping("/delete")
    public String deleteVisita(@RequestParam("id") Long id, Model model) {
        visitaService.deleteVisita(id);
        return "redirect:/visita/";
    }
}
