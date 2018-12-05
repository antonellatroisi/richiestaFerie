package it.dstech.validator;

import java.util.Date;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import it.dstech.models.Richiesta;

@Component
@RepositoryEventHandler
public class RichiestaValidator {



	@HandleBeforeCreate	
	public void validateRichiesta(Richiesta ric) throws Exception {			
		System.out.println(ric.getAnagraficaId());
	}



	@HandleBeforeSave		
	public void validateStateRichiesta(Richiesta ric) throws Exception {			

		//Solo un esempio , va aggiunto il controllo sul ruolo
		//if (user.role == "DIPENDENTE" & ric.getStatoRichiesta() == StatoRichiesta.IN_ATTESA) {

			ric.setDataUltimaModifica(new Date());			
		//	continue;
		//}			
		//else if (user.role == "DIPENDENTE" & ric.getStatoRichiesta() != StatoRichiesta.IN_ATTESA) {
			throw new Exception("Non puoi più modificare la richiesta");

		}

}

