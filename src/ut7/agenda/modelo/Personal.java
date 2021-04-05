package ut7.agenda.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Personal extends Contacto{ // Padre: Contacto

	// Atributos
	private LocalDate fecnac; // Fecha nacimiento
	private Relacion relacion; // Relacion con el propietario
	private String firma; // Firma fija para todos los contactos en personal
	
	// Constructor
	public Personal(String nombre, String apellidos, String telefono, String email, String fecnac,
			Relacion relacion) {
		super(nombre, apellidos, telefono, email);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM. yyyy");
		this.fecnac = LocalDate.parse(fecnac,formatter); // Recibe fecha nacimiento en string, pasar a LocalDate
		this.relacion = relacion;
		firma = "Un abrazo!!";
	}
	
	//Getters y setters
	public LocalDate getFecnac() {
		return fecnac;
	}
	public void setFecnac(LocalDate fecnac) {
		this.fecnac = fecnac;
	}
	public Relacion getRelacion() {
		return relacion;
	}
	public void setRelacion(Relacion relacion) {
		this.relacion = relacion;
	}
	
	public String getFirmaEmail() {
		return firma;
	}
	// Ya que firma no requiere cambios no tiene setter
	
	// comprobar si es su cumpleaños
	public boolean esCumpleaños() {
		return fecnac==LocalDate.now();
	}
	
	// para pasar la fecha de nacimiento al string de patrón especificado
	public String formatoFecha() {
		return fecnac.format(DateTimeFormatter.ofPattern("dd MMM. yyyy")).toLowerCase();
	}
	
	// Añade al toString padre los atributo de Personal
	@Override
	public String toString() {
		return super.toString() + " \nFecha nacimiento: " + this.formatoFecha() + " \nRelación: " + this.getRelacion() + " \n";
	}
	
	
	

}
