package ejercicio2;

import java.util.Arrays;
import java.util.Scanner;

public class PrincipalJuego {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		Baraja baraja1 = null;
		int cartasRepartir;
		Carta cartas1[] = null;


		try {
			
			baraja1 = new Baraja();
			
			System.out.println("¿Cuantas cartas reparto?");
			cartasRepartir = Integer.parseInt(teclado.nextLine());

			cartas1 = new Carta[cartasRepartir];

			for (int i = 0; i < cartas1.length; i++) {
				cartas1[i] = baraja1.repartirCartas();
			}
			
			System.out.println("Cartas del jugador 1");
			System.out.println(Arrays.toString(cartas1));
			
			System.out.println("Cartas del jugador 2");
			System.out.println(Arrays.toString(baraja1.repartirCartas(cartasRepartir)));
			
		} catch (CartaException e) {
			System.out.println(e.getMessage());
		}

	}

}
