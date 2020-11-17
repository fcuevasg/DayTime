package Servidor;

import java.io.*;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;

public class server_client extends Thread{
	
	Socket clientsocket;
	ObjectOutputStream out;
	ObjectInputStream in;
	DayTimePaquete dtp;
	DayTimePaquete dtp_Recibido;
	
	public server_client(Socket socket_c) {
		
		clientsocket = socket_c;
	}
	
	public void run() {
		
		System.out.println("[SERVER] RUNNING");
		try {
			out = new ObjectOutputStream(clientsocket.getOutputStream());
			in = new ObjectInputStream(clientsocket.getInputStream());
			
			do {
			
			dtp_Recibido =  (DayTimePaquete) in.readObject();

			System.out.println("[SERVER] waiting");
			}while(dtp_Recibido.cabecera != DayTimePaquete.REQUEST_HORA);

				
				
				System.out.println(dtp_Recibido.cabecera);
				switch (dtp_Recibido.cabecera) {
				case "rqs":
					dtp = new DayTimePaquete(DayTimePaquete.RESPUESTA_HORA,Calendar.getInstance().getTime().toString());
					out.writeObject(dtp);
					out.flush();
					//out.close();
					break;
					

				default:
					System.out.println("test");
					break;
				}
				
			//clientsocket.close();
			
			
		} catch (IOException e) {

			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		

		
	}
}

