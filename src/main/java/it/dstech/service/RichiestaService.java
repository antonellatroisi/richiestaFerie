package it.dstech.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.dstech.custom.RichiestaRepositoryImpl;
import it.dstech.models.Richiesta;
import it.dstech.models.StatoRichiesta;
import it.dstech.models.TipoRichiesta;
import it.dstech.repository.RichiestaRepository;

@Service
public class RichiestaService {

	@Autowired
	private RichiestaRepositoryImpl richiestaRepositoryImpl;

	@Autowired
	private RichiestaRepository richiestaRepository;

	public Page<Richiesta> search(Integer id, StatoRichiesta stato, TipoRichiesta tipo, Date start, Date end,
			Pageable pageable) {

		return richiestaRepositoryImpl.ricerca(id, stato, tipo, start, end, pageable);
	}
	
	
	public Richiesta findOne(Long id) throws Exception {
		Optional<Richiesta> optAnn = richiestaRepository.findById(id);
		if (!optAnn.isPresent()) {
			throw new Exception("non trovato");
		}
		return optAnn.get();
	}

	public Richiesta modificaRichiesta(Richiesta ric) throws Exception {
		Richiesta ricDb = findOne(ric.getId());
		if (ricDb.getStatoRichiesta() == StatoRichiesta.IN_ATTESA) {
			ricDb.setDataInizio(ric.getDataInizio());
			ricDb.setTipoRichiesta(ric.getTipoRichiesta());
			if (ric.getTipoRichiesta() == TipoRichiesta.FERIE) {
				ricDb.setDataFine(ric.getDataFine());
			}
			if (ric.getTipoRichiesta() == TipoRichiesta.PERMESSO) {
				ricDb.setNumeroOre(ric.getNumeroOre());
			}
			ricDb.setProjectManager(ric.getProjectManager());
			ricDb.setIdProjectManager(ric.getIdProjectManager());
			ricDb.setResponsabileAziendale(ric.getResponsabileAziendale());
			ricDb.setIdRespAziendale(ric.getIdRespAziendale());
			ricDb.setDataUltimaModifica(new Date());
			return richiestaRepository.save(ricDb);
		}
		return null;
	}

	public Richiesta annullaRichiesta(Long id) throws Exception {
		Richiesta ricDb = findOne(id);
		if (ricDb.getStatoRichiesta() != StatoRichiesta.RIFIUTATA) {
			ricDb.setStatoRichiesta(StatoRichiesta.ANNULLATA);
			return richiestaRepository.save(ricDb);
		}
		return null;
	}
	public Richiesta rifiutaRichiesta(Long id) throws Exception {
		Richiesta ricDb = findOne(id);
		if (ricDb.getStatoRichiesta() == StatoRichiesta.IN_ATTESA | ricDb.getStatoRichiesta() == StatoRichiesta.PRIMA_APPROVAZIONE) {
			ricDb.setStatoRichiesta(StatoRichiesta.RIFIUTATA);
			return richiestaRepository.save(ricDb);
		}
		return null;
}
	public Richiesta approvaRichiesta(Long id) throws Exception {
		Richiesta ricDb = findOne(id);
		if (ricDb.getStatoRichiesta() == StatoRichiesta.IN_ATTESA | ricDb.getStatoRichiesta() == StatoRichiesta.PRIMA_APPROVAZIONE) {
			ricDb.setStatoRichiesta(StatoRichiesta.APPROVATA);
			return richiestaRepository.save(ricDb);
		}
		return null;
	}

	
	
	
}
