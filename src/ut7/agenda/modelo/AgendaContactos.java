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
import java.util.TreeSet;
/**
 * @version 1.0,
 * @author Jhon Vera, Diana Peralta, Adrian Vitoria
 * Simula una agenda de contactos 
 */ 
public class AgendaContactos {
	private Map<Character, Set<Contacto>> agenda;
	private int contador;

	public AgendaContactos() {
		this.agenda = new TreeMap<Character, Set<Contacto>>();
	}
	
	public void añadirContacto(Contacto con) { // Adrian
		
		if (agenda.containsKey(con.getPrimeraLetra())==false) { // Comprueba si existe una clave que coincida con la inicial del apellido
			LinkedHashSet<Contacto> tes = new LinkedHashSet<>(); // Si no existe, la crea
			tes.add(con);
			agenda.put(con.getPrimeraLetra(), tes);
		}
		else {
			LinkedHashSet<Contacto> hsa = (LinkedHashSet<Contacto>) agenda.get(con.getPrimeraLetra()); // Si existe, coge el set de contactos de dicha clave en una nueva, añade el nuevo contacto y sustituye a la vieja con la nueva  
			hsa.add(con);
			agenda.put(con.getPrimeraLetra(), hsa);
		}
		
	}
	/*
	 * Busca todos los contactos de la agenda, y todos los que empiezen por dicha letra son almacenados en el treeSet
	 * @param la letra de la coleccion Set que se busca
	 * @return Un conjunto set de la letra buscada
	 */
	public Set<Contacto> contactosEnLetra(char letra) {
		Set <Contacto> contactos = new TreeSet<Contacto>();
			contactos.addAll(agenda.get(letra));
			return contactos;
	}
	
	/*
	 * Cuenta todos los contactos que existen en la agenda
	 * @return enumero de contactos que hay
	 */
	public int totalContactos() {
		int contador = 0;
		for(char key : agenda.keySet()) {
			contador += agenda.get(key).size();
		}
		return contador;
	}

	@Override
	public String toString() {
		String salida = "";
		for(char key : agenda.keySet()) {
			salida += key + " (" + agenda.get(key).size() + " contacto/s)\n"
					+ "---------------\n";
			Iterator<Contacto> it = agenda.get(key).iterator();
			while(it.hasNext()) {
				salida += it.next().toString() + "\n";
			}
		}
		return salida + "\n("+ totalContactos() + " contacto/s)";
	}
	/*
	 * Compara todos los contactos de la agenda y compara si el parametro indroducido coincide con alguno
	 * @param el string que sera buscado entre los contactos
	 * @return los contactos que se coincidan con el texto
	 */
	public List<Contacto> buscarContactos(String texto) {
		ArrayList <Contacto> contactos = new ArrayList<>();
		for(char key : agenda.keySet()) {
			Iterator<Contacto> it = agenda.get(key).iterator();
			while(it.hasNext()) {
				Contacto temp = it.next();
				if(temp.getNombre().contains(texto.toUpperCase()) || temp.getApellidos().contains(texto.toUpperCase())) {
					contactos.add(temp);
				}
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
	/*
	 * Busca los contactos a los que hay que felicitar por su cumpleaños
	 * @return un arrayList "cumple" con todos los contactos a los que hay que felicitar 
	 */
	public List<Personal> felicitar() {
		ArrayList<Personal> cumple = new ArrayList<Personal>();
		for(char key : agenda.keySet()) {
			Iterator<Contacto> it = agenda.get(key).iterator();
			while(it.hasNext()) {
				Contacto temp = it.next();
				if(temp.getClass().equals(Personal.class)) {
					Personal p = (Personal)temp;
					if(p.esCumpleaños() == true) {
						cumple.add(p);
					}
				}
			}
		}
		return cumple;
	}
	/*
	 * Busca todos los contactos personales que se encuentran en la agenda
	 * @return un Map "relacion" en el que aparecen solo contactos personales organizados por clave
	 * añadiendo en la coleccion List sus nombres y apellidos
	 */
	public Map<Relacion,List<String>> personalesPorRelacion() {
		TreeMap<Relacion,List<String>> relacion = new TreeMap<Relacion,List<String>>();
		for(char key : agenda.keySet()) {
			Iterator<Contacto> it = agenda.get(key).iterator();
			while(it.hasNext()) {
				Contacto temp = it.next();
				if(temp.getClass().equals(Personal.class)) {
					Personal p = (Personal)temp;
					if(relacion.containsKey(p.getRelacion()) == true) {
						relacion.get(p.getRelacion()).add(p.getApellidos() + " " + p.getNombre());
					}
					else {
						List<String> nom = new ArrayList<String>();
						nom.add(p.getApellidos() + " " + p.getNombre());
						relacion.put(p.getRelacion(), nom);
					}
				}
			}
		}
		return relacion;
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
