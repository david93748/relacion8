package ejercicio3;


public class Habitacion {
	private int numero;
	private String tipo;
	private boolean ocupada;
	
	public static final String[] TIPOS_HABITACIONES= {"SIMPLE", "DOBLE", "TRIPLE"};
	
	//Falta completar el control de errores en este método
	//Tirando la excepción cuando sea necesario
	public Habitacion(int numero, String tipo) throws HotelException {
		if(numero<=0) {
			throw new HotelException("El numero de habitacion debe ser positivo");
		}
		tipo=tipo.toUpperCase();
		if(comprobarTipo(tipo)==false) {
			throw new HotelException("Tipo de habitacion incorrecto");
		}
		this.numero = numero;
		this.tipo = tipo;
		this.ocupada=false;
	}

	public int getNumero() {
		return numero;
	}

	public String getTipo() {
		return tipo;
	}


	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	@Override
	public String toString() {
		String cadena;
		cadena="Nº" + numero + ", tipo: " + tipo ;
		if (ocupada) {
			cadena=cadena + " ocupada";
		}
		else {
			cadena=cadena + " libre";
		}
		return cadena;
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
