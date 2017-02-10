package co.simplon.annuaire;

import java.util.List;

import co.simplon.annuaire.dao.ContactsDAO;
import co.simplon.annuaire.dao.JdbcContactsDAO;

public class Main {

    public static void main(String[] args) throws Exception {
    		String type = "";
    		if (args.length > 0) {
    			type = args[0];
    		};
    		
    		ContactsDAO dao = new JdbcContactsDAO();
        List<String> listeEmails = dao.findEmailsByContactType(type);
        
        for (String email : listeEmails) {
        		System.out.println(email);
		}
    }

}
