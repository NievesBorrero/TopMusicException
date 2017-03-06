package topMusicException.excepciones;

public class TituloNoValidoException extends Exception {
	
	public TituloNoValidoException(String msj){
		super(msj+"\n");
	}
}
