package topMusicException;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import topMusicException.excepciones.AutorNoValidoException;
import topMusicException.excepciones.FechaNoValidaException;
import topMusicException.excepciones.TituloNoValidoException;

public class Cancion {
	private String title;
	private String artist;
	private int year;
	private static final Calendar CALENDAR = Calendar.getInstance();
	private static final int THISYEAR = CALENDAR.get(Calendar.YEAR);
	private static Pattern pattern = Pattern
			.compile("([\\-´,a-zA-ZáéíóúñÑ0-9]{2,}\\s?)+");
	private static Matcher matcher;

	Cancion(String title, String artist, int year)
			throws TituloNoValidoException, FechaNoValidaException,
			AutorNoValidoException {
		setTitle(title);
		setArtist(artist);
		setYear(year);

	}
/**
 * 
 * @param year
 * @throws FechaNoValidaException
 * 				Si la fecha es inferior a la minima o superior a la actual
 */
	private void setYear(int year) throws FechaNoValidaException {
		checkYear(year);
		this.year = year;

	}
/**
 * 
 * @param artist
 * @throws AutorNoValidoException
 * 				Si el valor no coincide con el patron establecido
 */
	private void setArtist(String artist) throws AutorNoValidoException {
		checkAuthor(artist);
		this.artist = artist;

	}
/**
 * 
 * @param title
 * @throws TituloNoValidoException
 * 				Si el valor no coincide con el patron establecido
 */
	private void setTitle(String title) throws TituloNoValidoException {
		checkTitle(title);
		this.title = title;

	}
/**
 * 
 * @param year
 * @throws FechaNoValidaException
 * 				Si la fecha es inferior a la minima o superior a la actual
 */
	static void checkYear(int year) throws FechaNoValidaException {
		if (!(year < THISYEAR && year > 1900))
			throw new FechaNoValidaException(
					"fecha incorrecta, prueba a introducir una fecha valida");

	}
/**
 * 
 * @param str
 * @throws AutorNoValidoException
 * 				Si el valor no coincide con el patron establecido
 */
	static void checkAuthor(String str) throws AutorNoValidoException {
		matcher = pattern.matcher(str);
		if (!matcher.find())
			throw new AutorNoValidoException(
					"titulo no valido, introduce un nombre valido");

	}
/**
 * 
 * @param str
 * @throws TituloNoValidoException
 * 				Si el valor no coincide con el patron establecido
 */
	static void checkTitle(String str) throws TituloNoValidoException {
		matcher = pattern.matcher(str);
		if (!matcher.find())
			throw new TituloNoValidoException(
					"titulo no valido, introduce un nombre valido");

	}

	@Override
	public String toString() {
		return getTitle() + ", de: " + getArtist() + ", fecha de publicacion: "
				+ getYear();
	}

	private String getTitle() {
		return this.title;
	}

	private String getArtist() {
		return this.artist;
	}

	private int getYear() {
		return this.year;
	}

}
