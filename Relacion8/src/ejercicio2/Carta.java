package ejercicio2;

import java.util.Objects;

public class Carta {
	
	int numero;
	String palo;
	
	
	public Carta(int numero, String palo) throws CartaException {
		if(numero>12||numero<0) {
			throw new CartaException("El numero debe estar entre 0 y 12");
		}
		
		this.numero=numero;
		
		palo=palo.toUpperCase();
		
		if(!(palo.equals("OROS")||palo.equals("COPAS")||palo.equals("ESPADAS")||palo.equals("BASTOS"))) {
			throw new CartaException("El palo debe ser oro, copas, espadas o bastos");
		}
		this.palo=palo;
		
	}


	public int getNumero() {
		return numero;
	}


	public String getPalo() {
		return palo;
	}


	@Override
	public String toString() {
		return numero + " de " + palo;
	}


	@Override
	public int hashCode() {
		return Objects.hash(numero, palo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return numero == other.numero && Objects.equals(palo, other.palo);
	}
	
	
	

}
