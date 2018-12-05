package it.dstech.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.models.Richiesta;
import it.dstech.models.StatoRichiesta;
import it.dstech.models.TipoRichiesta;
import it.dstech.service.RichiestaService;




@RestController
@RequestMapping("/api")
public class RichiestaCtrl {


	@Autowired
	private RichiestaService assegnazioneService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/cerca", "" }, method = RequestMethod.GET)
	@ResponseBody
	public Page<Richiesta> search(
			@RequestParam(name = "id") Integer id,
			@RequestParam(name = "stato", required = false) StatoRichiesta stato,
			@RequestParam(name = "tipo", required = false) TipoRichiesta tipo,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "limit", required = false, defaultValue = "10") Integer limit,
			@RequestParam(name = "sort", required = false, defaultValue = "0") Integer sort,
			@RequestParam(name = "start", required = false) Date start,
			@RequestParam(name = "end", required = false) Date end) {
		Pageable p = new PageRequest(page, limit);
		if (sort == 0) {
			p = new PageRequest(page, limit);

		} else {
			p = new PageRequest(page, limit);

		}

		return assegnazioneService.search(id, stato, tipo, start, end, p);
	}
	@PutMapping (value = "/update")
	public Richiesta update (@RequestBody Richiesta ric) throws Exception {
		return assegnazioneService.modificaRichiesta(ric);
	}
	@PutMapping ("/annulla")
	public Richiesta annulla (@RequestParam (name = "id") Long id) throws Exception {
		return assegnazioneService.annullaRichiesta(id);
	}
	@PutMapping ("/rifiuta")
	public Richiesta rifiuta (@RequestParam (name = "id") Long id) throws Exception {
		return assegnazioneService.rifiutaRichiesta(id);
	}
	@PutMapping ("/approva")
	public Richiesta approva (@RequestParam (name = "id") Long id) throws Exception {
		return assegnazioneService.approvaRichiesta(id);
	}
	
}

