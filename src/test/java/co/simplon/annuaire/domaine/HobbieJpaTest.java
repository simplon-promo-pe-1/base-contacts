package co.simplon.annuaire.domaine;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HobbieJpaTest {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(HobbieJpaTest.class);

	@Test
	public void le_mapping_du_premier_hobbie_doit_etre_coherent() {
		// GIVEN
		Long idRecherche = 1L;

		// WHEN
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("BaseContacts");
		EntityManager em = emf.createEntityManager();
		Hobbie hobbie = em.find(Hobbie.class, idRecherche);

		// THEN
		LOGGER.info(hobbie.getNom());
		assertThat(hobbie.getId(), equalTo(idRecherche));
		assertThat(hobbie.getNom(), equalTo("Horseback Riding"));
		assertThat(hobbie.getContactId(), equalTo(1L));
	}
}
