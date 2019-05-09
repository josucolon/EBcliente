package SL;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface I_FacadeEB extends Remote
{
	public void buscarvuelo(String Origen, String Destinio, String fecha)throws RemoteException; 
	
    public void registro(String nombre, String apellido, String apellido2, String dni, String password, String pago,
    		String modoInicio, String correo)throws RemoteException; 
    
    public void InicioSesionG(String usuario, String password)throws RemoteException;  
    
    public void InicioSesionF(String usuario, String password)throws RemoteException; 
    	
    public void Visa(String nombre, int numTarj, int mes, int ano, int cvv)throws RemoteException;
    	
    public void payPal(String usuario, String password)throws RemoteException;
    
    	
    
}
