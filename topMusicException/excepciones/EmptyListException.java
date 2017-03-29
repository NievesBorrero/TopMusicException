package topMusicException.excepciones;

public class EmptyListException extends Exception {
	public EmptyListException(String msj){
		super(msj+"\n");
	}
}
