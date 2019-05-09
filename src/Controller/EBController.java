package Controller;

import java.rmi.RemoteException;

import LP.frInicioSesion;
import LP.frPrincipal;
import SL.RMIServiceLocator;



public class EBController 
{
private RMIServiceLocator rsl = null;
	
	public EBController(String[] args) throws RemoteException 
	{		
		// Add your related code for the initialization of the Service Locator
		rsl = new RMIServiceLocator();
		rsl.setService(args[0], args[1], args[2]);
				
		new frInicioSesion(this);
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
  
    public void buscarvuelo(String Origen, String Destinio, String fecha) throws RemoteException 
    {
    	rsl.getService().buscarvuelo(Origen, Destinio, fecha);
    }
    
    public void registro(String nombre, String apellido, String apellido2, String dni, String password, String pago,
    		String modoInicio, String correo) throws RemoteException 
    {
    	rsl.getService().registro(nombre, apellido, apellido2, dni, password, pago, modoInicio, correo);
    }
    
    public void InicioSesionG(String usuario, String password) throws RemoteException
    {
    	rsl.getService().InicioSesionG(usuario, password);
    }
    
    public void InicioSesionF(String usuario, String password) throws RemoteException
    {
    	rsl.getService().InicioSesionF(usuario, password);
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
