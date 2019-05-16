package LN;

import java.util.ArrayList;

public class VueloController 
{
	private ArrayList<Vuelo> vuelos;
	public static VueloController controller; //idea básica del patrón Singleton
 
	private VueloController(){
		vuelos=new ArrayList<Vuelo>();
	}
 
	public static VueloController getInstance(){
		if(controller == null)
			controller = new VueloController();
		return controller;
	}
 
	public ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}
 
	public void setVuelos(ArrayList<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

}
