package co.simplon.annuaire;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.simplon.annuaire.dao.ContactsDAO;
import co.simplon.annuaire.dao.JdbcMysqlContactsDAO;
import co.simplon.annuaire.domaine.Contact;

public class MainMysqlInsert {

	private final static Logger LOGGER = LoggerFactory.getLogger(MainMysqlInsert.class);

    public static void main(String[] args) throws Exception {
    		Contact contact = new Contact("Eric", "Siber", "friend");
    		contact.setAge(35);
    		contact.setEmail("eric.siber@gmail.com");
    	
		ContactsDAO dao = new JdbcMysqlContactsDAO();
		dao.createContact(contact);
    }
}
