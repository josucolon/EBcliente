package SL;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

import DTO.VueloDTO;
import LN.Usuario;

public interface IServer extends Remote
{
	public boolean registrar (Usuario usuario, String contrasena) throws RemoteException;
	public Usuario inicioSesion (String usuario, String contrasena, String sistema_auto) throws RemoteException;
	public LinkedList<VueloDTO> getVuelos(String aer_origen, String aer_destino, String fecha_salida, String fecha_llegada) throws RemoteException;
	public int pagar(String user,String password,double precio, String sistema_pago);
	public void reservar (String codVuelo, int cod_pago);
	 
}