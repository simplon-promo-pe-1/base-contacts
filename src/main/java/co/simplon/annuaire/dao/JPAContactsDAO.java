package co.simplon.annuaire.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.simplon.annuaire.domaine.Contact;

public class JPAContactsDAO implements ContactsDAO {

	@Override
	public List<String> findEmailsByContactType(String type) throws Exception {
		// TODO
		return null;
	}

	@Override
	public void createContact(Contact contact) throws Exception {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("BaseContacts");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(contact);
		em.getTransaction().commit();
	}

}
