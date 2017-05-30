package co.simplon.annuaire.domaine;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HobbieJpaTest {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(HobbieJpaTest.class);

	private static EntityManagerFactory emf;

	@BeforeClass
	public static void setup() {
		emf = Persistence
				.createEntityManagerFactory("BaseContacts");
	}

	@Test
	public void le_mapping_du_premier_hobbie_doit_etre_coherent() {
		// GIVEN
		Long idRecherche = 1L;

		// WHEN
		EntityManager em = emf.createEntityManager();
		Hobbie hobbie = em.find(Hobbie.class, idRecherche);

		// THEN
		LOGGER.info(hobbie.getNom());
		assertThat(hobbie.getId(), equalTo(idRecherche));
		assertThat(hobbie.getNom(), equalTo("Horseback Riding"));
		Calendar cal = Calendar.getInstance();
		cal.setTime(hobbie.getDepuis());
		assertThat(cal.get(Calendar.DAY_OF_MONTH), equalTo(3));
		assertThat(cal.get(Calendar.MONTH), equalTo(Calendar.MAY));
		assertThat(cal.get(Calendar.YEAR), equalTo(2017));
		assertThat(hobbie.getContactId(), equalTo(1L));
	}
}
