package co.simplon.annuaire.domaine;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContactJpaTest {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(ContactJpaTest.class);

	@Test
	public void le_mapping_du_premier_contact_doit_etre_coherent() {
		if (System.getProperty("java.util.logging.config.file") == null) {
			throw new RuntimeException(
					"Ajouter -Djava.util.logging.config.file=src/test/resources/logging.properties "
							+ "dans les paramètres de la JVM pour l'exécution du test");
		}
		// GIVEN
		Long idRecherche = 1L;
		Long idHobbie = 3L;

		// WHEN
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("BaseContacts");
		EntityManager em = emf.createEntityManager();
		Contact contact = em.find(Contact.class, idRecherche);
		Hobbie hobbie = em.find(Hobbie.class, idHobbie);

		// THEN
		LOGGER.info(contact.getEmail());
		assertEquals(1, contact.getId());
		assertEquals("Dave", contact.getPrenom());
		assertEquals("Smith", contact.getNom());
		assertEquals("dsmith@icloud.com", contact.getEmail());
		assertEquals("friend", contact.getType());
		assertEquals(46, contact.getAge());
		assertEquals(2, contact.getHobbies().size());
		assertThat(contact.getHobbies(), hasItem(hobbie));
	}
}
