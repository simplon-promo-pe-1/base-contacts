package co.simplon.annuaire.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import co.simplon.annuaire.domaine.Contact;

public class JPAContactsDAO implements ContactsDAO {

	@Override
	public List<String> findEmailsByContactType(String type) throws Exception {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("BaseContacts");
		EntityManager em = emf.createEntityManager();

		TypedQuery<String> q = em.createQuery(
				"select c.email from Contact c where c.type = :type",
				String.class);
		q.setParameter("type", type);

		return q.getResultList();
	}

	@Override
	public void createContact(Contact contact) throws Exception {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("BaseContacts");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(contact);
		em.getTransaction().commit();

		em.close();
	}

}
