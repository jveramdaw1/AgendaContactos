 package ut7.agenda.modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AgendaContactos {
	private Map<Character, Set<Contacto>> agenda;
	private int contador;

	public AgendaContactos() {
		this.agenda = new TreeMap<Character, Set<Contacto>>();
		this.contador = 0;
	}
	
	public void añadirContacto(Contacto con) { // Adrian
		
		if (agenda.containsKey(con.getPrimeraLetra())==false) { // Comprueba si existe una clave que coincida con la inicial del apellido
			LinkedHashSet<Contacto> tes = new LinkedHashSet<>(); // Si no existe, la crea
			tes.add(con);
			agenda.put(con.getPrimeraLetra(), tes);
			contador ++;
		}
		else {
			LinkedHashSet<Contacto> hsa = (LinkedHashSet<Contacto>) agenda.get(con.getPrimeraLetra()); // Si existe, coge el set de contactos de dicha clave en una nueva, añade el nuevo contacto y sustituye a la vieja con la nueva  
			hsa.add(con);
			agenda.put(con.getPrimeraLetra(), hsa);
		}
		
	}

	public void contactosEnLetra() {

	}

	public int totalContactos() {
		return contador;
	}

	@Override
	public String toString() {
		String salida = "";
		for(char llave : agenda.keySet()) {
			salida += llave + "(" + agenda.get(llave).size() + " contacto/s)\n"
					+ "---------------";
			Iterator<Character> it = (Iterator<Character>) agenda.keySet();
			while(it.hasNext()) {
				Iterator<Contacto> it2 = agenda.get(it.next()).iterator();
				while(it2.hasNext()) {
					salida += it2.next().toString();
				}
			}
		}
		return salida;
	}
	/*
	 * 
	 */
	public List<Contacto> buscarContactos(String texto) {
		ArrayList <Contacto> contactos = new ArrayList<>();
		for(Contacto contacto : contactos) {
			if(contacto.getNombre().contains(texto) || contacto.getApellidos().contains(texto)) {
				contactos.add(contacto);
			}
		}

		return contactos;

	}

	public ArrayList<Personal> personalesEnLetra(char letra) { // Adrian

		ArrayList<Personal> ray = new ArrayList<>(); // Crea arraylist vacio
		if (agenda.containsKey(letra)) { // Comprueba si la letra existe entre las claves
			for (Contacto con : agenda.get(letra)) { // Si existe, por cada contacto en dicha letra
				if ( ! (con instanceof Personal) ) { // se comprueba que sea clase Personal
					ray.add((Personal) con); // Si lo es, se añade al arraylist
				}
			}
		}
		else { // Si clave no existe
			return null; // Devuelve null
		}
		return ray; // Devuelve el arraylist
	}

	public List<Personal> felicitar() {

		return null;
	}

	public void personalesPorRelacion() {

	}

	public ArrayList<Personal> personalesOrdenadosPorFechaNacimiento(char letra) { // Adrian

		ArrayList<Personal> ray = new ArrayList<>(); // Crea arraylist vacio
		if (agenda.containsKey(letra)) { // Comprueba si la letra existe entre las claves
			for (Contacto con : agenda.get(letra)) { // Si existe, por cada contacto en dicha letra
				if ( ! (con instanceof Personal) ) { // se comprueba que sea clase Personal
					ray.add((Personal) con); // Si lo es, se añade al arraylist
				}
			}
		}
		else { // Si clave no existe
			return null; // Devuelve null
		}
		
		Comparator<Personal> comfecnac = new Comparator<>() { // Para ordenar fechas de nacimiento con comparator
		    @Override
		    public int compare(Personal p1, Personal p2) {
		        return p1.getFecnac().compareTo(p2.getFecnac());
		    }
		};
		
		Collections.sort(ray, comfecnac); //Ordenar la arraylist con el comparator
		
		
		return ray; // Devuelve el arraylist

	}
	
	

}
