package Servidor;

import java.io.Serializable;

public class DayTimePaquete implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REQUEST_HORA = "rqh";
	public static String HEARTBEAT = "boomboom";
	public static String RESPUESTA_HORA = "rph";
	
	String cabecera;
	public String contenido;
	
	
	public DayTimePaquete(String _cabecera, String _contenido) {
		this.cabecera = _cabecera;
		this.contenido= _contenido;
		}

	public DayTimePaquete() {
		this.cabecera = "";
		this.contenido= "";
		}
	
	public void setCabecera(String header) {
		
		if(header == REQUEST_HORA || header == HEARTBEAT || header == RESPUESTA_HORA) {
			this.cabecera = header;
		}
	}
}
