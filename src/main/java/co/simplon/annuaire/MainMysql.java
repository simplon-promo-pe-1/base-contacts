package co.simplon.annuaire;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.simplon.annuaire.dao.ContactsDAO;
import co.simplon.annuaire.dao.JdbcMysqlContactsDAO;

public class MainMysql {

	private final static Logger LOGGER = LoggerFactory.getLogger(MainMysql.class);
	
    public static void main(String[] args) throws Exception {
		String type = "";
		if (args.length > 0) {
			type = args[0];
		};
		LOGGER.info("Lecture des emails des contacts de type " + type);
		
		ContactsDAO dao = new JdbcMysqlContactsDAO();
		List<String> listeEmails = dao.findEmailsByContactType(type);

		for (String email : listeEmails) {
			LOGGER.debug("Affichage de l'email " + email);
			System.out.println(email);
		}
    }
}
