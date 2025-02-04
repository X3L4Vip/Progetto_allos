package allos.prenotazionePJ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import allos.prenotazionePJ.model.Prenotazione;
import allos.prenotazionePJ.repository.IDAOService;

@Controller
public class GestoreRichieste {
	
	@Autowired
	IDAOService dao;
	
	
	@PostMapping("/savePren")
	public String upsertPrenotazione(Prenotazione pren,Model model) {
		System.out.println(pren);
		dao.upsertPrenotazione(pren);
		return getPrenotazioni(model);
	}

	@GetMapping("/showPrens")
	public String getPrenotazioni(Model model) {
		List<Prenotazione> prenotazioni = dao.getPrenotazioni();
		model.addAttribute("prenotazioni", prenotazioni);
		return "tabella";
	}
	
	@GetMapping("/removePren")
	public String deletePrenotazione(@RequestParam int id,Model model) {
		dao.deletePrenotazione(id);
		return getPrenotazioni(model);
	}
	
}
