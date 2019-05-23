package Controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;

import LN.Usuario;
import LN.Vuelo;
import LP.frInicioSesion;
import LP.frPrincipal;
import SL.RMIServiceLocator;


public class EBController 
{
private static RMIServiceLocator rsl = null;
	
	public EBController(String [] args) throws RemoteException 
	{		
		// Add your related code for the initialization of the Service Locator
		rsl = new RMIServiceLocator();
		rsl.setService(args[0], args[1], args[2]);
				
		new frPrincipal(this);
//		frPrincipal vent = new frPrincipal(this);
//		vent.setVisible(true);
	}
	
//    
//	public void switchServer(String ip, String port, String name)
//	{
//		
//		// Add your code related to switching servers		
//		System.out.println("- Switching to server: " + ip + ":" + port + "/" + name);
//	}
  
//    public static ArrayList<Vuelo> buscarvuelo(String Origen, String Destinio, String fecha) throws RemoteException 
//    {
//    	ArrayList<Vuelo> listaVuelos;
//    	listaVuelos = rsl.getService().buscarvuelo(Origen, Destinio, fecha);
//    	return listaVuelos;
//    	
//    }
//    
//    public void registro(Usuario usuario) throws RemoteException 
//    {
//    	rsl.getService().registro(usuario);
//    }
//    
//    public Usuario InicioSesionG(String usuario, String password) throws RemoteException
//    {
//    	Usuario usu;
//    	usu = rsl.getService().InicioSesionG(usuario, password);
//    	return usu;
//    }
//    
//    public Usuario InicioSesionF(String usuario, String password) throws RemoteException
//    {
//    	Usuario usu;
//    	usu = rsl.getService().InicioSesionF(usuario, password);
//    	return usu;
//    }
//
//    public void Visa(String nombre, int numTarj, int mes, int ano, int cvv) throws RemoteException
//    {
//    	rsl.getService().Visa(nombre, numTarj, mes, ano, cvv);
//    }
//
//    public void payPal(String usuario, String password) throws RemoteException
//    {
//    	rsl.getService().payPal(usuario, password);
//    }
	
	public boolean registrar (Usuario usuario) throws RemoteException
	{
		boolean ret;
		ret=rsl.getService().registrar(usuario);
		return ret;
	}
	public boolean acceder (String usuario, String contrasena, String sistema_auto) throws RemoteException
	{
		boolean ret;
		ret=rsl.getService().acceder(usuario,contrasena, sistema_auto);
		return ret;
	}
	public LinkedList<Vuelo> getVuelos(String aer_origen, String aer_destino, String fecha_salida, String fecha_llegada) throws RemoteException
	{
		LinkedList<Vuelo> listaVuelos;
    	listaVuelos = rsl.getService().getVuelos(aer_origen, aer_destino, fecha_salida, fecha_llegada);
    	return listaVuelos;
	}
	public int pagar(String user,String password,double precio, String sistema_pago)
	{
		int pago;
		pago= rsl.getService().pagar(user, password, precio, sistema_pago);
		return pago;
	}
    
    public void exit(){
    	System.exit(0);
    }
    
    public static void main(String[] args) throws RemoteException {    	
    	new EBController(args);
    }

}
