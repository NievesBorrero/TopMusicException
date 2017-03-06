package topMusicException.excepciones;

public class FechaNoValidaException extends Exception {
	public FechaNoValidaException(String msj){
		super(msj+"\n");
	}
}
