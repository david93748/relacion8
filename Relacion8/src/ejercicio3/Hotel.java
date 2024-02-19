package ejercicio3;

import java.util.Arrays;

public class Hotel {

	private Habitacion[] habitaciones;

	public static final String[] TIPOS_HABITACIONES = { "SIMPLE", "DOBLE", "TRIPLE" };

	public Hotel(int simples, int dobles, int triples) throws HotelException {
		if (simples < 0 || dobles < 0 || triples < 0) {
			throw new HotelException("No puede haber tipos negativos");
		}
		if (simples + dobles + triples == 0) {
			throw new HotelException("No se puede crear un hotel sin habitaciones");
		}

		int total = simples + dobles + triples;
		String tipoActual = null;
		int numeroHabitacion = 0;
		int cantidadPorTipo[] = { simples, dobles, triples };

		habitaciones = new Habitacion[total];

		for (int i = 0; i < TIPOS_HABITACIONES.length; i++) {
			for (int j = 0; j < cantidadPorTipo[i]; j++) {
				habitaciones[numeroHabitacion] = new Habitacion(numeroHabitacion+1, TIPOS_HABITACIONES[i]);
				numeroHabitacion++;
			}

		}

	}


	@Override
	public String toString() {
		return "El hotel tiene las siguientes habitaciones: " + Arrays.toString(habitaciones);
	}
	
	
	public int checkIn(String tipo) throws HotelException {
		tipo=tipo.toUpperCase();
		if(comprobarTipo(tipo)==false) {
			throw new HotelException("Tipo incorrecto");
		}
		
		boolean habitacionEncontrada=false;
		
		int numeroHabitacion = 0;
		
		for (int i = 0; i < habitaciones.length&&habitacionEncontrada==false; i++) {
			if(habitaciones[i].getTipo().equals(tipo)&&habitaciones[i].isOcupada()==false) {
				habitacionEncontrada=true;
				numeroHabitacion=i;
			}
			
		}
		
		if(habitacionEncontrada==false) {
			throw new HotelException("No hay habitaciones de ese tipo libre");
		}
		
		habitaciones[numeroHabitacion].setOcupada(true);
		
		
		return habitaciones[numeroHabitacion].getNumero();
		
	}
	
	public void checkOut(int numeroHabitacion) throws HotelException {
		if(habitaciones[numeroHabitacion-1].isOcupada()==false) {
			throw new HotelException("Esa habitacion ya esta libre");
		}
		habitaciones[numeroHabitacion-1].setOcupada(false);
	}
	
	private boolean comprobarTipo(String tipo) {
		boolean esCorrecto=false;
		
		for (int i = 0; i < TIPOS_HABITACIONES.length && esCorrecto==false; i++) {
			if(tipo.equals(TIPOS_HABITACIONES[i])) {
				esCorrecto=true;
			}
		}
		return esCorrecto;
		
	}

}
