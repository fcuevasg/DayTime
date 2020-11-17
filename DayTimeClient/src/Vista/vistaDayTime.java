package Vista;

import javax.swing.*;



public class vistaDayTime extends JFrame{
	
	JPanel panelPrincipal;
	JTextArea display;
	public JButton request;
	
	
	
	public vistaDayTime() {
	panelPrincipal = new JPanel();
	display = new JTextArea(10, 2);
	display.setEditable(false);
	request = new JButton("Pedir hora");
	
		
		
	this.setSize(600, 300);
	this.setTitle("Cliente horas");
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	panelPrincipal.add(display);
	panelPrincipal.add(request);
	this.add(panelPrincipal);
	
	
	}
	
	
	
	public void setDisplay(String Contenido) {
		
		this.display.setText(Contenido);
	}
	
	
	

}
