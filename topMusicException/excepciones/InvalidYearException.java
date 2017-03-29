package topMusicException.excepciones;

public class InvalidYearException extends Exception {
	public InvalidYearException(String msj){
		super(msj+"\n");
	}
}
