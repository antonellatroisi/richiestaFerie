package it.dstech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import it.dstech.models.Richiesta;

@CrossOrigin(origins = { "http://localhost", "http://localhost:8080" })
@RepositoryRestResource(collectionResourceRel = "richiesta", path = "richiesta")
public interface RichiestaRepository extends PagingAndSortingRepository<Richiesta, Long> {

	// Chiamate lato Dipendente

	// Ricerca , trova tutte le richieste, con data inizio delle Ferie/permesso, non
	// della creazione della richiesta

	@RestResource(rel = "findInitDipendente", path = "findInitDipendente")
	@Modifying
	@Query("SELECT r FROM richiesta r WHERE id_anagrafica=:id AND stato_richiesta = 'APPROVATA' or stato_richiesta = 'PRIMA_APPROVAZIONE' or stato_richiesta = 'IN_ATTESA'")
	List<Richiesta> findInitDipendente(@Param("id") Integer id);

	// Chiamate Project Manager

	@RestResource(rel = "findInitPM", path = "findInitPM")
	@Modifying
	@Query("SELECT r FROM richiesta r WHERE project_manager=:fullName AND stato_richiesta = 'IN_ATTESA'")
	List<Richiesta> findInitProjectManager(@Param("fullName") Integer fullName);

	// Chiamate Responsabile Aziendale

	@RestResource(rel = "findInitAD", path = "findInitAD")
	@Modifying
	@Query("SELECT r FROM richiesta r WHERE responsabile_aziendale=:fullName AND stato_richiesta = 'IN_ATTESA'")
	List<Richiesta> findInitRespAziendale(@Param("fullName") Integer fullName);

	@RestResource(rel = "searchRichiesta", path = "searchRichiesta")
	@Modifying
	@Query("SELECT r FROM richiesta r WHERE id_respAzinedale=:id AND stato_richiesta = 'IN_ATTESA'")
	List<Richiesta> searchRichiesta(@Param("id") Long id);
}
