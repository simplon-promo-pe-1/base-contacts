package co.simplon.annuaire.dao;

import java.util.List;

import co.simplon.annuaire.domaine.Contact;

public interface ContactsDAO {
	/**
	 * Renvoie la liste des emails des contacts selon le type de contact
	 * @param type Type de contact
	 * @return Liste d'emails
	 * @throws Exception exception
	 */
	List<String> findEmailsByContactType(String type) throws Exception;
	
	/**
	 * Crée un nouveau contact dans le système
	 * @param contact Le contact à créer
	 * @throws Exception exception
	 */
	void createContact(Contact contact) throws Exception;
}
