package co.simplon.annuaire.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import co.simplon.annuaire.domaine.Contact;

public class JPAContactsDAO implements ContactsDAO {

	EntityManager em;

	public JPAContactsDAO() {
		super();
		em = getEntityManager();
	}

	@Override
	public List<String> findEmailsByContactType(String type) throws Exception {
		TypedQuery<String> q = em.createNamedQuery("findEmailsByContactType",
				String.class);
		q.setParameter("type", type);
		List<String> emails = q.getResultList();
		em.close();
		return emails;
	}

	@Override
	public void createContact(Contact contact) throws Exception {
		em.getTransaction().begin();
		em.persist(contact);
		em.getTransaction().commit();

		em.close();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("BaseContacts");
		EntityManager em = emf.createEntityManager();
		return em;
	}
}
