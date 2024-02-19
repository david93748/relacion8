package ejercicio2;

import java.util.Arrays;
import java.util.Scanner;

public class PrincipalJuego {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		Baraja baraja1 = null;
		int cartasRepartir;
		Carta cartas1[] = null;
		Carta cartas2[] = null;


		try {
			
			baraja1 = new Baraja();
			
			System.out.println("¿Cuantas cartas reparto?");
			cartasRepartir = Integer.parseInt(teclado.nextLine());

			cartas1 = new Carta[cartasRepartir];

			for (int i = 0; i < cartas1.length; i++) {
				cartas1[i] = baraja1.repartirCartas();
			}
			
			cartas2 = baraja1.repartirCartas(cartasRepartir);
			
			System.out.println("Cartas del jugador 1");
			System.out.println(Arrays.toString(cartas1));
			
			System.out.println("Cartas del jugador 2");
			System.out.println(Arrays.toString(cartas2));
			
			System.out.println(baraja1);
			
		} catch (CartaException e) {
			System.out.println(e.getMessage());
		}

	}

}
