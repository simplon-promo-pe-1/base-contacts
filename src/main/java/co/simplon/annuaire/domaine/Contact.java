package co.simplon.annuaire.domaine;

public class Contact {

	private long id;
	private String prenom;
	private String nom;
	private String email;
	private String type;
	private int age;
	
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
	
}
