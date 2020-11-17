package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import Vista.*;


public class controlador {
	Socket socketDayTime;
	ObjectOutputStream writerDayTime;
	ObjectInputStream readerDayTime;
	vistaDayTime vista;
	String time;
	DayTimePaquete dtp;
	DayTimePaquete dtp_Recibido;
	WorkerReader worker;
	
	
	
	
	
	public controlador() {
		
		try {
			socketDayTime = new Socket(InetAddress.getLocalHost(), 6666);
			writerDayTime = new ObjectOutputStream(socketDayTime.getOutputStream());
			readerDayTime = new ObjectInputStream(socketDayTime.getInputStream());
			vista = new vistaDayTime();	
			vista.setVisible(true);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	public void inicio(controlador c) {
		vista.request.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dtp = new DayTimePaquete();
				dtp.setCabecera(DayTimePaquete.REQUEST_HORA);
				try {
					writerDayTime.writeObject(dtp);
					writerDayTime.flush();
					//writerDayTime.close();
				 worker = new WorkerReader(c, readerDayTime, dtp_Recibido);
				 worker.start();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				
						
				
			}
		});
	
		
		
	}




	public void paqueteRecibido(DayTimePaquete dtp2) {
		dtp_Recibido = dtp2;
		vista.setDisplay(dtp_Recibido.contenido);
		
		
	}
	
	
	
	
	
	
	
	

}
