package model;

public class User {

	private int id;
	private String nume_prenume;
	private String email;
	private String parola;
	private String telefon;
	
	
	//Constructor fara id
	public User(String nume_prenume, String email, String parola, String telefon) {
		super();
		this.nume_prenume = nume_prenume;
		this.email = email;
		this.parola = parola;
		this.telefon = telefon;
		
	}
	
	//Constructor simplu
		public User(String email, String parola) {
			super();
			this.email = email;
			this.parola = parola;			
		}
	
	// Constructor cu id
	public User(int id, String nume_prenume, String email, String parola, String telefon) {
		super();
		this.id = id;
		this.nume_prenume = nume_prenume;
		this.email = email;
		this.parola = parola;
		this.telefon = telefon;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume_prenume() {
		return nume_prenume;
	}

	public void setNume_prenume(String nume_prenume) {
		this.nume_prenume = nume_prenume;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nume_prenume=" + nume_prenume + "parola=" + parola
				+ ", telefon=" + telefon + ", email=" + email + "]";
	}
	
	
	
	
}
