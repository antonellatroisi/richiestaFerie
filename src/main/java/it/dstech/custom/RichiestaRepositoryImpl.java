package it.dstech.custom;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import it.dstech.models.Richiesta;
import it.dstech.models.StatoRichiesta;
import it.dstech.models.TipoRichiesta;

@Transactional
@Repository
public class RichiestaRepositoryImpl implements RichiestaRepositoryCustom {

	@PersistenceContext
	EntityManager em;

	@Override
	public Page<Richiesta> ricerca(Integer id, StatoRichiesta stato, TipoRichiesta tipo, Date start, Date end,
			Pageable p) {
		String queryPrincipale = "Select r FROM richiesta r WHERE id_anagrafica = " + id + "";
		String cond = "Select count(*) from richiesta where id_anagrafica = " + id + " ";
		if (stato != null) {
			queryPrincipale += " and stato_richiesta='" + stato + "'";
			cond += " and stato_richiesta='" + stato + "'";
		}
		if (tipo != null) {
			queryPrincipale += " and tipo_richiesta='" + tipo + "'";
			cond += " and tipo_richiesta='" + tipo + "'";

		}
		if (start != null & end != null) {
			queryPrincipale += " and data_inizio >= '" + start.getTime() + "' and data_inizio <= '" + end.getTime() + "'";
			cond += " and data_inizio >= '" + start + "' and data_inizio <= '" + end + "'";

		}
		Query q = em.createQuery(cond);
		Query qc = em.createQuery(queryPrincipale);

		Long count = (Long) q.getSingleResult();
		qc.setFirstResult((int) p.getOffset());

		q.setMaxResults(p.getPageSize());

		Page<Richiesta> results = new PageImpl<Richiesta>(qc.getResultList(), p, count);
		System.out.println(qc.getResultList());
		return results;
	}

}
