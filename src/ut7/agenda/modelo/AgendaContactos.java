 package ut7.agenda.modelo;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AgendaContactos {
	private Map<Character, Set<Contacto>> agenda;

	public AgendaContactos() {
		this.agenda = new TreeMap<Character, Set<Contacto>>();
	}
	
	public void añadirContacto(Contacto con) {
		LinkedHashSet<Contacto> tes = new LinkedHashSet<>();
		
		agenda.put(con.getPrimeraLetra(),  
				)
	}

	public void contactosEnLetra() {

	}

	public void totalContactos() {

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

	public List<Contacto> buscarContactos(String texto) {

		return null;

	}

	public List<Personal> personalesEnLetra(char letra) {

		return null;
	}

	public List<Personal> felicitar() {

		return null;
	}

	public void personalesPorRelacion() {

	}

	public List<Personal> personalesOrdenadosPorFechaNacimiento(char letra) {

		return null;

	}

}
