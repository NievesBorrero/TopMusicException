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

import topMusicException.excepciones.InvalidAuthorException;
import topMusicException.excepciones.InvalidYearException;
import topMusicException.excepciones.EmptyListException;
import topMusicException.excepciones.NoValidPositionException;
import topMusicException.excepciones.InvalidSongException;

public class TopMusic {
	private static final String EMPTY_LIST = "la lista esta vacia";
	private ArrayList<Cancion> topMusic = new ArrayList<Cancion>();

	/**
	 * Muestra el primer elemento de la lista
	 * 
	 * @throws EmptyListException
	 */
	String showOne() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException(EMPTY_LIST);
		return "El tema que viene pegando fuerte es: "
				+ topMusic.get(0).toString();

	}

	/**
	 * muestra los 10 primeros titulos de la lista
	 * 
	 * @throws EmptyListException
	 * 
	 */
	StringBuilder show() throws EmptyListException {
		StringBuilder ten = new StringBuilder();
		if (isEmpty()) {
			throw new EmptyListException(EMPTY_LIST);
		}
		ten.append("Top Ten:\n");
		for (Cancion c : topMusic) {
			ten.append(c.toString() + "\n");
		}
		return ten;
	}

	/**
	 * desciende una posicion en el ranking
	 * 
	 * @throws NoValidPositionException
	 *             si la posicion introducida esta fuera de rango
	 * @throws EmptyListException
	 */
	void downOne(int index) throws NoValidPositionException,
			EmptyListException {
		if (isEmpty())
			throw new EmptyListException(EMPTY_LIST);
		if (!validPosition(index))
			throw new NoValidPositionException("imposible localizar cancion");
		topMusic.add(index + 1, topMusic.remove(index));

	}

	/**
	 * Sube un puesto en el ranking
	 * 
	 * @throws NoValidPositionException
	 *             si la posicion introducida esta fuera de rango
	 * @throws EmptyListException
	 */
	void upOne(int index) throws NoValidPositionException, EmptyListException {
		if (isEmpty())
			throw new EmptyListException(EMPTY_LIST);
		if (!validPosition(index))
			throw new NoValidPositionException("imposible localizar cancion");
		if (index == 0)
			throw new NoValidPositionException("no puede subir mas");
		topMusic.add(index - 1, topMusic.remove(index));

	}

	/**
	 * desplaza un elemento fuera del top 10
	 * 
	 * @throws NoValidPositionException
	 *             si la posicion introducida esta fuera de rango
	 * @throws EmptyListException
	 */
	void moveDown(int index) throws NoValidPositionException,
			EmptyListException {
		if (isEmpty())
			throw new EmptyListException(EMPTY_LIST);
		if (!validPosition(index))
			throw new NoValidPositionException("imposible localizar cancion");
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
	private boolean validPosition(int index) {
		if (index < 0 || index > topMusic.size())
			return false;
		return true;
	}

	/**
	 * introduce una cancion en una posicion valida de la lista
	 * 
	 * @throws NoValidPositionException
	 *             si la posicion introducida esta fuera de rango
	 */
	void insert(int index, String title, String artist, int year)
			throws InvalidAuthorException, InvalidYearException,
			InvalidSongException, NoValidPositionException {
		try {
			topMusic.add(index, new Cancion(title, artist, year));
		} catch (IndexOutOfBoundsException e) {
			throw new NoValidPositionException("error al insertar");
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
	 * @throws InvalidAuthorException
	 *             si no coincide con el pattern establecido
	 * @throws InvalidYearException
	 *             si la fecha es superior a la actual o inferior a la minima
	 * @throws InvalidSongException
	 *             si no coincide con el pattern establecido
	 */
	void generateTop() throws InvalidSongException, InvalidYearException,
			InvalidAuthorException {
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
	 * @throws NoValidPositionException
	 *             si la posicion introducida esta fuera de rango
	 * @param posicion
	 * @throws EmptyListException
	 */
	void delete(int index) throws NoValidPositionException,
			EmptyListException {
		if (isEmpty())
			throw new EmptyListException(EMPTY_LIST);
		if (!validPosition(index))
			throw new NoValidPositionException("posicion invalida");
		topMusic.remove(topMusic.get(index));
	}

}
