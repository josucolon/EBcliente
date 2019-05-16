package Controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
//		new SwitchServerGUI(this);		
	}
	
//    public void newTVProgram(String acronym, String description)
//    {    	
//    	try 
//    	{
//    		// Add your code related to getting the service and requesting creation of TVProgram    		
//    		rsl.getService().newTVProgram(acronym, description);
//    	} 
//    	catch (Exception e)
//    	{
//    		System.err.println("$ Error sending new TV program: " + e.toString());
//    	}
//    }
    
//    public void sendMessage(String phone, String text){
//    	try
//    	{	
//    		// Add your related to getting the service and sending a message
//    		rsl.getService().receiveMessage(phone, text);
//    		
//    	} 
//    	catch(Exception e)
//    	{
//    		System.out.println("$ Error sending a message: " + e.getMessage());
//    	}
//    }
//    
//	public void switchServer(String ip, String port, String name)
//	{
//		
//		// Add your code related to switching servers		
//		System.out.println("- Switching to server: " + ip + ":" + port + "/" + name);
//	}
  
    public static ArrayList<Vuelo> buscarvuelo(String Origen, String Destinio, String fecha) throws RemoteException 
    {
    	ArrayList<Vuelo> listaVuelos;
    	listaVuelos = rsl.getService().buscarvuelo(Origen, Destinio, fecha);
    	return listaVuelos;
    	
    }
    
    public void registro(Usuario usuario) throws RemoteException 
    {
    	rsl.getService().registro(usuario);
    }
    
    public Usuario InicioSesionG(String usuario, String password) throws RemoteException
    {
    	Usuario usu;
    	usu = rsl.getService().InicioSesionG(usuario, password);
    	return usu;
    }
    
    public Usuario InicioSesionF(String usuario, String password) throws RemoteException
    {
    	Usuario usu;
    	usu = rsl.getService().InicioSesionF(usuario, password);
    	return usu;
    }

    public void Visa(String nombre, int numTarj, int mes, int ano, int cvv) throws RemoteException
    {
    	rsl.getService().Visa(nombre, numTarj, mes, ano, cvv);
    }

    public void payPal(String usuario, String password) throws RemoteException
    {
    	rsl.getService().payPal(usuario, password);
    }
    
    public void exit(){
    	System.exit(0);
    }
    
    public static void main(String[] args) throws RemoteException {    	
    	new EBController(args);
    }

}
