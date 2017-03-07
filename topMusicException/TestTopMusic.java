package topMusicException;

import topMusicException.excepciones.AutorNoValidoException;
import topMusicException.excepciones.FechaNoValidaException;
import topMusicException.excepciones.PosicionNoValidaException;
import topMusicException.excepciones.TituloNoValidoException;
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
	 * @throws TituloNoValidoException
	 * @throws FechaNoValidaException
	 * @throws AutorNoValidoException
	 */
	public static void main(String[] args) throws TituloNoValidoException,
			FechaNoValidaException, AutorNoValidoException {
		if (Teclado.deseaContinuar("Desea comenzar con lista pregenerada? s-n")) {
			top.generateTop();
		}
		Menu menu = new Menu("Top Music", new String[] {
				"Introducir en una posicion", "sacar del topmusic",
				"subir un puesto", "bajar un puesto", "mostrar top music",
				"mostrar top1", "borrar cancion" });
		do {
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
		} while (menu.getOpcion() < menu.getSALIR());
	}

	/**
	 * elimina una cancion si la posicion es valida
	 */
	private static void delete() {
		if (top.isEmpty()) {
			System.out.println("la lista esta vacia, accion imposible");
			return;
		}
		try {
			top.delete(Teclado.leerEntero("indica posicion de la cancion a "
					+ "eliminar") - 1);
			System.out.println("cancion eliminada");
		} catch (PosicionNoValidaException e) {
			System.err.print("\n" + e.getMessage());
			System.out.println();
		}

	}

	/**
	 * Saca la cancion del top ten
	 */
	private static void pushDown() {
		if (top.isEmpty()) {
			System.out.println("la lista est� vac�a, acci�n imposible");
			return;
		}
		try {
			top.moveDown(Teclado.leerEntero("indica posicion de la cancion a "
					+ "desplazar") - 1);
			System.out.println("la cancion ha descendido");
		} catch (PosicionNoValidaException e) {
			System.err.print(e.getMessage());
			System.out.println();
		}

	}

	/**
	 * promociona una canción
	 */
	private static void upOne() {
		if (top.isEmpty()) {
			System.out.println("la lista esta vacia, accion imposible");
			return;
		}
		try {
			top.upOne(Teclado.leerEntero("indica posicion de la cancion que va"
					+ " a ascender") - 1);
			System.out.println("La cancion ha ascendido");
		} catch (PosicionNoValidaException e) {
			System.err.print(e.getMessage());
			System.out.println();

		}

	}

	/**
	 * desciende una cancion
	 */
	private static void downOne() {
		if (top.isEmpty()) {
			System.out.println("la lista esta vacia, accion imposible");
			return;
		}
		try {
			top.downOne(Teclado
					.leerEntero("indica posicion de la cancion que va"
							+ " a descender") - 1);
			System.out.println("la cancion ha descendido");
		} catch (PosicionNoValidaException e) {
			System.err.print(e.getMessage());
			System.out.println();
		}

	}

	/**
	 * muestra las primeras 10 canciones del ranking
	 */
	private static void showTop() {
		System.out.println(top.show());

	}

	/**
	 * muestra la cancion que ostenta el top one
	 */
	private static void topOne() {
		System.out.println(top.showOne());

	}

	/**
	 * introduce una cancion en la posicion indicada
	 */
	private static void insert() {
		int posicion;
		try {
			if (top.isEmpty())
				posicion = 0;
			else
				posicion = Teclado.leerEntero("indica posicion") - 1;
			String titulo = Teclado.leerCadena("titulo:").trim();
			Cancion.checkTitle(titulo);
			// si el titulo no es correcto, salta TituloNoValidoException
			String artista = Teclado.leerCadena("artista o grupo:").trim();
			Cancion.checkAuthor(artista);
			// si el artista no es correcto, salta AutorNoValidoException
			top.insert(posicion, titulo, artista,
			// Si la posicion no es valida, salta PosicionNoValidaException
					Teclado.leerEntero("fecha de publicacion:"));
			// Como la fecha es el ultimo elemento, omitimos el check pues si
			// falla no hay mas datos que introducir
			System.out.println("introducida en la posicion indicada");
		} catch (PosicionNoValidaException | FechaNoValidaException
				| TituloNoValidoException | AutorNoValidoException e) {
			System.err.print(e.getMessage());
			System.out.println();
		}
	}
}
