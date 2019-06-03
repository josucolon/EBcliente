package Controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;

import DTO.VueloDTO;
import LN.Usuario;
import LP.frInicioSesion;
import LP.frPrincipal;
import SL.RMIServiceLocator;


public class EBController 
{
private static RMIServiceLocator rsl = null;
	
	public EBController() throws RemoteException 
	{		
		// Add your related code for the initialization of the Service Locator
		rsl = new RMIServiceLocator();
		rsl.setService("127.0.0.1", "1099", "EasyBooking");
				
		new frPrincipal(this);

	}
	

	
	public boolean registrar (Usuario usuario, String contrasena) throws RemoteException
	{
		boolean ret;
		ret=rsl.getService().registrar(usuario, contrasena);
		return ret;
	}
	public Usuario inicioSesion (String usuario, String contrasena, String sistema_auto) throws RemoteException
	{
		Usuario usu;
		usu=rsl.getService().inicioSesion(usuario,contrasena, sistema_auto);
		return usu;
	}
	public LinkedList<VueloDTO> getVuelos(String aer_origen, String aer_destino, String fecha_salida, String fecha_llegada) throws RemoteException
	{
		LinkedList<VueloDTO> listaVuelos;
    	listaVuelos = rsl.getService().getVuelos(aer_origen, aer_destino, fecha_salida, fecha_llegada);
    	return listaVuelos;
	}
	public int pagar(String user,String password,double precio, String sistema_pago)
	{
		int cod_pago;
		cod_pago= rsl.getService().pagar(user, password, precio, sistema_pago);
		return cod_pago;
	}
	
	public void reservar (String codVuelo, int cod_pago)
	{
		rsl.getService().reservar(codVuelo, cod_pago);
	}
    
    public void exit(){
    	System.exit(0);
    }
    
    public static void main(String[] args) throws RemoteException {    	
    	new EBController();
    }

}
