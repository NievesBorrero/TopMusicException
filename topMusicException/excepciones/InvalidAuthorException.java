package topMusicException.excepciones;

public class InvalidAuthorException extends Exception {

	public InvalidAuthorException(String msj){
		super(msj+"\n");
	}
}
