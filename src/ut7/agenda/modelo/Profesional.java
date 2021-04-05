package ut7.agenda.modelo;

public class Profesional{
	private String nombreEmpresa;
	private String mensaje;
	
	public Profesional(String nombreEmpresa) {
		char primeraLetra = nombreEmpresa.toUpperCase().charAt(0);
		String restoNombre = nombreEmpresa.substring(1).toLowerCase();
		this.nombreEmpresa = primeraLetra + restoNombre;
		this.mensaje = obtenerMensaje();
		
	}
		public String obtenerMensaje(){
			int valorMensaje = 0;
			valorMensaje = (int)(Math.random() * 3 + 1);
			if(valorMensaje == 1) {	
				return "Atentamente";
			}
			else if(valorMensaje == 2) {
				return "Saludos coordiales";
			}
			return "Mis mejores deseos";
			
		}
		public String getNombreEmpresa() {
			return nombreEmpresa;
		}
		public void setNombreEmpresa(String nombreEmpresa) {
			this.nombreEmpresa = nombreEmpresa;
		}
		public String getMensaje() {
			return mensaje;
		}
		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}
		
		public String toString() {
			return "\nNombre de la empresa=" + nombreEmpresa + "\nMensaje=" + mensaje;
		}
		
		
	
	

}
