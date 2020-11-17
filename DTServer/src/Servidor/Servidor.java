package Servidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;

public class Servidor {

	public void run() {
		
		ServerSocket serversocket;
		Socket clientsocket;
		OutputStream outclient;
		PrintWriter out;
		boolean terminar = false; 
		
		try {
			
			serversocket = new ServerSocket(6666);

			while(!terminar){
				
				clientsocket = serversocket.accept();
				new server_client(clientsocket).start();
				
			}
				serversocket.close();

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
