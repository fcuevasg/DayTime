package controlador;

import java.io.*;

public class WorkerReader extends Thread {

	ObjectInputStream reader;
	DayTimePaquete dtp;
	controlador c;
	
	public WorkerReader(controlador c, ObjectInputStream ois, DayTimePaquete _dtp) {
		
		this.reader = ois;
		this.dtp = _dtp;
		this.c = c;
				
	}
	
	
	
	public void run() {
		do {
			System.out.println("[CLIENTE] Esperando...");
			
			try {
				dtp = (DayTimePaquete) reader.readObject();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} while (dtp.cabecera != DayTimePaquete.RESPUESTA_HORA);
	
		System.out.println("[CLIENTE] Packet = " + dtp.cabecera);
		
		c.paqueteRecibido(dtp);
	}
	
	
	
	
	
}
