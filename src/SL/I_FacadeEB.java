package SL;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LN.Usuario;
import LN.Vuelo;

public interface I_FacadeEB extends Remote
{
	public ArrayList<Vuelo> buscarvuelo(String Origen, String Destinio, String fecha)throws RemoteException; 
	
    public void registro(Usuario usuario)throws RemoteException; 
    
    public Usuario InicioSesionG(String usuario, String password)throws RemoteException;  
    
    public Usuario InicioSesionF(String usuario, String password)throws RemoteException; 
    	
    public void Visa(String nombre, int numTarj, int mes, int ano, int cvv)throws RemoteException;
    	
    public void payPal(String usuario, String password)throws RemoteException;
    
    	
    
}
