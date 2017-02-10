package co.simplon.annuaire.dao;

import java.util.List;

public interface ContactsDAO {
	/**
	 * Renvoie la liste des emails des contacts selon le type de contact
	 * @param type Type de contact
	 * @return Liste d'emails
	 * @throws Exception exception
	 */
	List<String> findEmailsByContactType(String type) throws Exception;
}
