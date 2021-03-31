package ut7.agenda.modelo;
public abstract class Contacto {
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;

	public Contacto(String nombre, String apellidos, String telefono,
			String email) {
		this.nombre = nombre.toUpperCase();
		this.apellidos = apellidos.toUpperCase();
		this.telefono = telefono;
		this.email = email.toLowerCase();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return nombre.hashCode() + apellidos.hashCode() + email.hashCode() * 11;
	}
	
	public char getPrimeraLetra() {
		char letra = getApellidos().charAt(0);
		return letra;
	}
	
	public boolean equals(Object obj) {
		if(hashCode() == obj.hashCode()) {
			return true;
		}
		return false;
	}
	
	public int compareTo(Contacto c) {
		if(apellidos.hashCode() < c.apellidos.hashCode()) {
			return -1;
		}
		if(apellidos== c.apellidos) {
			return 0;
		}
		return 1;
	}
	public int compareTo2(Contacto c) {
		if(nombre.hashCode() < c.nombre.hashCode()) {
			return -1;
		}
		if(nombre== c.nombre) {
			return 0;
		}
		return 1;
	}
	
	public abstract String getFirma();
	
	public String toString() {
		return apellidos + ", " + nombre + "(" + Contacto.class.getSimpleName().toUpperCase() + ")\n" +
				"Tfno: " + telefono + " | email: " + email + "\n";
	}
	
	
}
