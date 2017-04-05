package co.simplon.annuaire.domaine;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class ContactJpaTest {

	@Test
	public void le_mapping_du_premier_contact_doit_etre_coherent() {
		// GIVEN
		Long idRecherche = 1L;

		// WHEN
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("BaseContacts");
		EntityManager em = emf.createEntityManager();
		Contact contact = em.find(Contact.class, idRecherche);

		// THEN
		assertEquals(1, contact.getId());
		assertEquals("Dave", contact.getPrenom());
		assertEquals("Smith", contact.getNom());
		assertEquals("dsmith@icloud.com", contact.getEmail());
		assertEquals("friend", contact.getType());
		assertEquals(46, contact.getAge());
	}

}
