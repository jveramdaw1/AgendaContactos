package ut7.agenda.modelo;

public class Profesional extends Contacto{
	
	//Atributos
	private String nombreEmpresa;
	private String mensaje;
	
	//Constructor
	public Profesional(String nombre, String apellidos, String telefono, String email, String nombreEmpresa, String mensaje) {
		//Atributos clase Contacto
		super(nombre, apellidos, telefono, email);
		//Separador para obtener la primera letra del nombre de la empresa en mayuscula
		char primeraLetra = nombreEmpresa.toUpperCase().charAt(0);
		String restoNombre = nombreEmpresa.substring(1).toLowerCase();
		this.nombreEmpresa = primeraLetra + restoNombre;
		//Atributo que obtiene en mensaje aleatorio
		this.mensaje = obtenerMensaje();
		
	}
	/*
	 * Metodo que obtiene un valor aleatorio y asigna un mensaje para este
	 */
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
		
		//Getters
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
			return super.toString() + "\nNombre de la empresa=" + nombreEmpresa + "\nMensaje=" + mensaje;
		}
		
		public String getFirmaEmail() {
			return null;
		}
		
	
	

}
