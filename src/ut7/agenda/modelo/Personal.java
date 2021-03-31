package ut7.agenda.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Personal extends Contacto{

	private LocalDate fecnac;
	private Relacion relacion;
	private String firma;
	
	public Personal(String nombre, String apellidos, String telefono, String email, LocalDate fecnac,
			Relacion relacion) {
		super(nombre, apellidos, telefono, email);
		this.fecnac = fecnac;
		this.relacion = relacion;
		firma = "Un abrazo!!";
	}
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
	
	public String getFirma() {
		return firma;
	}
	
	public boolean esCumpleaños() {
		return fecnac==LocalDate.now();
	}
	
	public String formatoFecha() {
		return fecnac.format(DateTimeFormatter.ofPattern("dd MMM. yyyy")).toLowerCase();
	}
	
	@Override
	public String toString() {
		return this.getApellidos().toUpperCase() + ", " + this.getNombre().toUpperCase() + " (PERSONAL) \nTfno: " + this.getTelefono() + " | email: " + this.getEmail() + " \nFecha nacimiento: " + this.formatoFecha() + " \nRelación: " + this.getRelacion() + " \n";
	}
	
	
	

}
