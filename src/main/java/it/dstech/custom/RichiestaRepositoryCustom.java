package it.dstech.custom;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.dstech.models.Richiesta;
import it.dstech.models.StatoRichiesta;
import it.dstech.models.TipoRichiesta;

public interface RichiestaRepositoryCustom {

	public Page<Richiesta> ricerca(Integer id, StatoRichiesta stato, TipoRichiesta tipo, Date start, Date end, Pageable p);

	}

