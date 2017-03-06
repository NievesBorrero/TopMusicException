package topMusicException;

/**
 * TopMusic. Implementa un programa que gestione una lista de las canciones más escuchadas. El usuario podrá:
 *a. Añadir una canción (en una posición) al TopMusic.
 *b. Sacar un elemento del TopMusic.
 *c. Subir un puesto en el TopMusic.
 *d. Bajar un puesto en el TopMusic.
 *e. Mostrar la lista TopMusic.
 *f. Mostrar la canción más escuchada.
 *Sobre la canción se almacenará el título, artista o grupo y año de grabación
 * @author pablo
 * @version 2.0
 */
import java.util.*;

import topMusicException.excepciones.AutorNoValidoException;
import topMusicException.excepciones.FechaNoValidaException;
import topMusicException.excepciones.ListaVaciaException;
import topMusicException.excepciones.PosicionNoValidaException;
import topMusicException.excepciones.TituloNoValidoException;

public class TopMusic {
	private ArrayList<Cancion> topMusic = new ArrayList<Cancion>();

	/**
	 * Muestra el primer elemento de la lista
	 */
	String showOne() {
		if (topMusic.isEmpty())
			return "la lista esta vacia";
		return "El tema que viene pegando fuerte es: "
				+ topMusic.get(0).toString();

	}

	/**
	 * muestra los 10 primeros titulos de la lista
	 * 
	 */
	StringBuilder show() {
		StringBuilder diez = new StringBuilder();
		if (topMusic.isEmpty()) {
			diez.append("la lista esta vacia");
			return diez;
		}
		diez.append("Top Ten:\n");
		for (Cancion c : topMusic) {
			diez.append(c.toString() + "\n");
		}
		return diez;
	}

	/**
	 * desciende una posicion en el ranking
	 * 
	 * @throws PosicionNoValidaException
	 *             si la posicion introducida esta fuera de rango
	 */
	void downOne(int index) throws PosicionNoValidaException {
		if (!posicionValida(index))
			throw new PosicionNoValidaException("imposible localizar cancion");
		topMusic.add(index + 1, topMusic.remove(index));

	}

	/**
	 * Sube un puesto en el ranking
	 * 
	 * @throws PosicionNoValidaException
	 *             si la posicion introducida esta fuera de rango
	 */
	void upOne(int index) throws PosicionNoValidaException {
		if (!posicionValida(index))
			throw new PosicionNoValidaException("imposible localizar cancion");
		if (index == 0)
			throw new PosicionNoValidaException("no puede subir mas");
		topMusic.add(index - 1, topMusic.remove(index));

	}

	/**
	 * desplaza un elemento fuera del top 10
	 * 
	 * @throws PosicionNoValidaException
	 *             si la posicion introducida esta fuera de rango
	 */
	void moveDown(int index) throws PosicionNoValidaException {
		if (!posicionValida(index))
			throw new PosicionNoValidaException("imposible localizar cancion");
		Cancion aux = topMusic.get(index);
		topMusic.remove(index);
		topMusic.set(10, aux);
	}

	/**
	 * indica si la posicion indicada es valida o no
	 * 
	 * @param index
	 * @return true/ false
	 */
	private boolean posicionValida(int index) {
		if (index < 0 || index > topMusic.size())
			return false;
			return true;
	}

	/**
	 * introduce una cancion en una posicion valida de la lista
	 * 
	 * @throws PosicionNoValidaException
	 *             si la posicion introducida esta fuera de rango
	 */
	void insert(int index, String titulo, String artista, int fecha)
			throws AutorNoValidoException, FechaNoValidaException,
			TituloNoValidoException, PosicionNoValidaException {
		try {
			topMusic.add(index, new Cancion(titulo, artista, fecha));
		} catch (IndexOutOfBoundsException e) {
			throw new PosicionNoValidaException("error al insertar");
		}

	}

	/**
	 * @return true si topMusic no contiene ninguna canci�n
	 */
	boolean isEmpty() {
		return topMusic.isEmpty();
	}

	/**
	 * Genera un topMusic predise�ado
	 * 
	 * @throws AutorNoValidoException
	 *             si no coincide con el pattern establecido
	 * @throws FechaNoValidaException
	 *             si la fecha es superior a la actual o inferior a la minima
	 * @throws TituloNoValidoException
	 *             si no coincide con el pattern establecido
	 */
	void generateTop() throws TituloNoValidoException, FechaNoValidaException,
			AutorNoValidoException {
		topMusic.add(new Cancion("El torito", "El fary", 1985));
		topMusic.add(new Cancion("All along the watchtower", "Bob Dylan", 1967));
		topMusic.add(new Cancion("Fear of the dark", "Iron Maiden", 1992));
		topMusic.add(new Cancion("Hells Bells", "AC DC", 1980));
		topMusic.add(new Cancion("American Psycho", "Misfits", 1997));
		topMusic.add(new Cancion("You", "Bad Religion", 1993));
		topMusic.add(new Cancion("Mi gran noche", "Raphael", 1966));
		topMusic.add(new Cancion("Californication", "RHCP", 2004));
		topMusic.add(new Cancion("Sofokao", "Barricada", 2004));
		topMusic.add(new Cancion("La torre", "Talco", 2008));
	}

	/**
	 * elimina una cancion indicada por su posicion
	 * 
	 * @throws PosicionNoValidaException
	 *             si la posicion introducida esta fuera de rango
	 * @param posicion
	 */
	void delete(int index) throws PosicionNoValidaException {
		if (!posicionValida(index))
			throw new PosicionNoValidaException("posicion invalida");
		topMusic.remove(topMusic.get(index));
	}

}
