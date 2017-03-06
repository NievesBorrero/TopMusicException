package topMusicException.excepciones;

public class AutorNoValidoException extends Exception {

	public AutorNoValidoException(String msj){
		super(msj+"\n");
	}
}
