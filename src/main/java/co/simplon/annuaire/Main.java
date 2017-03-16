package co.simplon.annuaire;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.simplon.annuaire.dao.ContactsDAO;
import co.simplon.annuaire.dao.JdbcContactsDAO;

public class Main {
	final static Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) throws Exception {

		String type = "";
		if (args.length > 0) {
			type = args[0];
		}
		;

		LOGGER.info("Recherche des emails des contacts de type "
				+ type);

		ContactsDAO dao = new JdbcContactsDAO();
		List<String> listeEmails = dao.findEmailsByContactType(type);

		for (String email : listeEmails) {
			LOGGER.debug("Affichage de l'email " + email);
			System.out.println(email);
		}
	}

}
