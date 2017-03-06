package topMusicException.excepciones;

public class ListaVaciaException extends Exception {
	public ListaVaciaException(String msj){
		super(msj+"\n");
	}
}
