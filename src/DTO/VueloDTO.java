package DTO;

import java.io.Serializable;

public class VueloDTO implements Serializable
{
	private String numero = null;
	private String Aero_orig = null;
	private String Aero_dest = null;
	private String horaLlegada = null;
	private String horaSalida = null;
	private String fecha = null;
	private double precio = 0.0;
	private int plazas = 0;
	
	
	
//	ArrayList <Reserva> reservas= new ArrayList<Reserva>();
	//@NotPersistent 
	//private String fechasalida = null;
	
	public VueloDTO (String numero, String Aero_orig, String Aero_dest, String horaLlegada, String horaSalida, String fecha, double precio, int plazas)//, ArrayList <Reserva> reservas)//, String fechasalida)
	{
		this.numero = numero;
		this.Aero_orig = Aero_orig;
		this.Aero_dest = Aero_dest;
		this.fecha = fecha;
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida; 
		this.plazas = plazas;
		this.precio = precio;
//		this.reservas = reservas;
		//this.fechasalida = fechasalida;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAero_orig() {
		return Aero_orig;
	}

	public void setAero_orig(String aero_orig) {
		Aero_orig = aero_orig;
	}

	public String getAero_dest() {
		return Aero_dest;
	}

	public void setAero_dest(String aero_dest) {
		Aero_dest = aero_dest;
	}
	

public String getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	@Override
	public String toString() {
		return "VueloDTO [Aero_orig=" + Aero_orig + ", Aero_dest=" + Aero_dest + ", horaLlegada=" + horaLlegada
				+ ", horaSalida=" + horaSalida + ", fecha=" + fecha + ", precio=" + precio + "]";
	}

	//	public ArrayList<Reserva> getReservas() {
//		return reservas;
//	}
//
//	public void setReservas(ArrayList<Reserva> reservas) {
//		this.reservas = reservas;
//	}
	

}
