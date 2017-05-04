package co.simplon.annuaire.domaine;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "HOBBIES")
public class Hobbie {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Long id;

	@Column(name = "HOBBY")
	private String nom;

	@Transient
	private Date depuis;

	@Column(name = "CONTACT_ID")
	private Long contactId;

	public Hobbie() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDepuis() {
		return depuis;
	}

	public void setDepuis(Date depuis) {
		this.depuis = depuis;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

}
