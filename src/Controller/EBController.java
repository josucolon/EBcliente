package Controller;

import java.rmi.RemoteException;

import SL.RMIServiceLocator;



public class EBController 
{
private RMIServiceLocator rsl = null;
	
	public EBController(String[] args) throws RemoteException 
	{		
		// Add your related code for the initialization of the Service Locator
		rsl = new RMIServiceLocator();
		rsl.setService(args[0], args[1], args[2]);
				
//		new SMSWindow(this);
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
  
    public void buscarvuelo(String Origen, String Destinio, String fecha) {
    	//This method will be use in other Labs.
    }
    
    public void registro(String nombre, String apellido, String apellido2, String dni, String password, String pago,
    		String modoInicio, String correo) {
    	//This method will be use in other Labs.
    }
    
    public void InicioSesionG(String usuario, String password) {
    	//This method will be use in other Labs.
    }
    
    public void InicioSesionF(String usuario, String password) {
    	//This method will be use in other Labs.
    }

    public void Visa(String nombre, int numTarj, int mes, int ano, int cvv) {
    	//This method will be use in other Labs.
    }

    public void payPal(String usuario, String password) {
    	//This method will be use in other Labs.
    }
    
    public void exit(){
    	System.exit(0);
    }
    
    public static void main(String[] args) throws RemoteException {    	
    	new EBController(args);
    }

}