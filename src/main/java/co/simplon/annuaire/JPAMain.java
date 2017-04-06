package co.simplon.annuaire;

import co.simplon.annuaire.dao.ContactsDAO;
import co.simplon.annuaire.dao.JPAContactsDAO;
import co.simplon.annuaire.domaine.Contact;

public class JPAMain {
	
	public static void main(String[] args) throws Exception {
		ContactsDAO dao = new JPAContactsDAO();
		Contact contact = new Contact("Eric", "SIBER", "friends");
		dao.createContact(contact);
	}

}
