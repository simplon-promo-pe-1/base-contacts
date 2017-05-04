package co.simplon.annuaire.domaine;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACTS")
public class Contact {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private long id;
	@Column(name = "FNAME", length = 100)
	private String prenom;
	@Column(name = "LNAME", length = 100)
	private String nom;
	@Column(name = "EMAIL", length = 255)
	private String email;
	@Column(name = "CONTACT_TYPE", length = 30)
	private String type;
	@Column(name = "AGE")
	private int age;

	@OneToMany
	@JoinColumn(name = "CONTACT_ID")
	private Set<Hobbie> hobbies;

	public Contact() {
		super();
	}

	public Contact(String prenom, String nom, String type) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.type = type;
	}
	
	public Contact(long id, String prenom, String nom, String type) {
		this(prenom, nom, type);
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNom() {
		return nom;
	}

	public String getType() {
		return type;
	}

	public Set<Hobbie> getHobbies() {
		return hobbies;
	}
	
}
