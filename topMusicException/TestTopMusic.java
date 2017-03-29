package topMusicException;

import topMusicException.excepciones.InvalidAuthorException;
import topMusicException.excepciones.InvalidYearException;
import topMusicException.excepciones.EmptyListException;
import topMusicException.excepciones.NoValidPositionException;
import topMusicException.excepciones.InvalidSongException;
import utiles.Menu;
import utiles.Teclado;

/**
 * 
 * @author pablo leon alcaide
 * @version 2.0
 */
public class TestTopMusic {
	private static TopMusic top = new TopMusic();

	/**
	 * @param args
	 * @throws InvalidSongException
	 * @throws InvalidYearException
	 * @throws InvalidAuthorException
	 */
	public static void main(String[] args) throws InvalidSongException,
			InvalidYearException, InvalidAuthorException {
		if (Teclado.deseaContinuar("Desea comenzar con lista pregenerada? s-n")) {
			top.generateTop();
		}
		Menu menu = new Menu("Top Music", new String[] {
				"Introducir en una posicion", "sacar del topmusic",
				"subir un puesto", "bajar un puesto", "mostrar top music",
				"mostrar top1", "borrar cancion" });
		do {
			try {
				switch (menu.gestionar()) {
				case 1:
					insert();
					break;
				case 2:
					pushDown();
					break;
				case 3:
					upOne();
					break;
				case 4:
					downOne();
					break;
				case 5:
					showTop();
					break;
				case 6:
					topOne();
					break;
				case 7:
					delete();
					break;
				case 8:
					System.out.println("adioooos");
					return;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (menu.getOpcion() < menu.getSALIR());
	}

	/**
	 * elimina una cancion si la posicion es valida
	 * 
	 * @throws EmptyListException
	 * @throws NoValidPositionException
	 */
	private static void delete() throws NoValidPositionException,
			EmptyListException {

		top.delete(Teclado.leerEntero("indica posicion de la cancion a "
				+ "eliminar") - 1);
		System.out.println("cancion eliminada");

	}

	/**
	 * Saca la cancion del top ten
	 * 
	 * @throws EmptyListException
	 * @throws NoValidPositionException
	 */
	private static void pushDown() throws NoValidPositionException,
			EmptyListException {
		top.moveDown(Teclado.leerEntero("indica posicion de la cancion a "
				+ "desplazar") - 1);
		System.out.println("la cancion ha descendido");

	}

	/**
	 * promociona una canción
	 * 
	 * @throws EmptyListException
	 * @throws NoValidPositionException
	 */
	private static void upOne() throws NoValidPositionException,
			EmptyListException {
		top.upOne(Teclado.leerEntero("indica posicion de la cancion que va"
				+ " a ascender") - 1);
		System.out.println("La cancion ha ascendido");

	}

	/**
	 * desciende una cancion
	 * 
	 * @throws EmptyListException
	 * @throws NoValidPositionException
	 */
	private static void downOne() throws NoValidPositionException,
			EmptyListException {
		top.downOne(Teclado.leerEntero("indica posicion de la cancion que va"
				+ " a descender") - 1);
		System.out.println("la cancion ha descendido");
	}

	/**
	 * muestra las primeras 10 canciones del ranking
	 * 
	 * @throws EmptyListException
	 */
	private static void showTop() throws EmptyListException {
		System.out.println(top.show());

	}

	/**
	 * muestra la cancion que ostenta el top one
	 * 
	 * @throws EmptyListException
	 */
	private static void topOne() throws EmptyListException {
		System.out.println(top.showOne());

	}

	/**
	 * introduce una cancion en la posicion indicada
	 */
	private static void insert() {
		int position;
		try {
			if (top.isEmpty())
				position = 0;
			else
				position = Teclado.leerEntero("indica posicion") - 1;
			String title = Teclado.leerCadena("titulo:").trim();
			Cancion.checkTitle(title);
			// si el titulo no es correcto, salta TituloNoValidoException
			String artist = Teclado.leerCadena("artista o grupo:").trim();
			Cancion.checkAuthor(artist);
			// si el artista no es correcto, salta AutorNoValidoException
			top.insert(position, title, artist,
			// Si la posicion no es valida, salta PosicionNoValidaException
					Teclado.leerEntero("fecha de publicacion:"));
			// Como la fecha es el ultimo elemento, omitimos el check pues si
			// falla no hay mas datos que introducir
			System.out.println("introducida en la posicion indicada");
		} catch (NoValidPositionException | InvalidYearException
				| InvalidSongException | InvalidAuthorException e) {
			System.err.print(e.getMessage());
			System.out.println();
		}
	}
}
