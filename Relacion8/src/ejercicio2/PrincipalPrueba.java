package ejercicio2;

import java.util.Arrays;

public class PrincipalPrueba {

	public static void main(String[] args) {
		Baraja baraja1 = null;

		try {
			baraja1 = new Baraja();
		} catch (CartaException e) {
			System.out.println(e.getMessage());

		}
		
		System.out.println(Arrays.toString(baraja1.getArrayCartas()));
		System.out.println(baraja1.getCartasRestantes());
		
		try {
			System.out.println(baraja1.repartirCartas());
		} catch (CartaException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(Arrays.toString(baraja1.getArrayCartas()));
		System.out.println(baraja1.getCartasRestantes());
		

	}

}
