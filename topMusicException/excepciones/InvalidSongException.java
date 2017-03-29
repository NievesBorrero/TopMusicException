package topMusicException.excepciones;

public class InvalidSongException extends Exception {
	
	public InvalidSongException(String msj){
		super(msj+"\n");
	}
}
