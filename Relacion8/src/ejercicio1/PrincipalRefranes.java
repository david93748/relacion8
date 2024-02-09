package ejercicio1;

import java.util.Arrays;
import java.util.Scanner;

public class PrincipalRefranes {

	private static Scanner teclado = new Scanner(System.in);

	private static final int MAXIMO_REFRANES = 50;

	public static void main(String[] args) {

		Refran[] refranes = new Refran[MAXIMO_REFRANES];
		int numeroRealRefranes = 0;
		int opc;

		do {
			opc = mostrarMenu();

			numeroRealRefranes = tratarMenu(refranes, numeroRealRefranes, opc);

		} while (opc != 4);

	}

	private static int tratarMenu(Refran[] refranes, int numeroRealRefranes, int opcion) {
		String cadenaRefran, palabraBuscar;
		int popularidad;
		boolean estaRepetido = false;
		Refran refranEncontrado = null;

		switch (opcion) {
		case 1:
			try {

				System.out.println("Introduce un refran:");
				cadenaRefran = teclado.nextLine();
				System.out.println("Introduce su popularidad 1-100");
				popularidad = Integer.parseInt(teclado.nextLine());

				estaRepetido = comprobarRepetido(cadenaRefran, refranes);

				if (estaRepetido == false) {
					refranes[numeroRealRefranes] = new Refran(cadenaRefran, popularidad);
					numeroRealRefranes++;
				} else {
					System.out.println("El refran esta repetido");
				}

			} catch (RefranException e) {
				System.out.println(e.getMessage());
			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.println("Numero maximo de refranes alcanzado");
			}

			break;

		case 2:
			System.out.println("Introduce la palabra a buscar:");
			palabraBuscar = teclado.nextLine();

			refranEncontrado = buscarRefran(palabraBuscar, refranes);
			System.out.println(refranEncontrado);

			break;

		case 3:

			Arrays.sort(refranes, 0, numeroRealRefranes);

			for (int i = 0; i < refranes.length; i++) {

				if (refranes[i] != null) {
					System.out.println(refranes[i]);
				}
			}

			break;

		default:
			System.out.println("opcion incorrecta");
			break;
		}

		return numeroRealRefranes;

	}

	private static int mostrarMenu() {
		int opcion;

		System.out.println("Elije una opcion:");
		System.out.println("1. Guardar refran");
		System.out.println("2. Buscar refran por palabra");
		System.out.println("3. Listar refranes");
		System.out.println("4. Salir");

		opcion = Integer.parseInt(teclado.nextLine());

		return opcion;
	}

	public static boolean comprobarRepetido(String cadenarefran, Refran[] refranes) {
		boolean estaRepetido = false;

		for (int i = 0; i < refranes.length && estaRepetido == false; i++) {
			if (refranes[i] != null) {
				if (refranes[i].getNombre().equals(cadenarefran)) {
					estaRepetido = true;
				}
			}
		}

		return estaRepetido;
	}

	public static Refran buscarRefran(String palabraBuscar, Refran[] refranes) {
		Refran refranEncontrado = null;
		boolean encontrado = false;

		palabraBuscar = palabraBuscar.toUpperCase();

		for (int i = 0; i < refranes.length && encontrado == false; i++) {
			if (refranes[i] != null) {
				if (refranes[i].getNombre().contains(palabraBuscar)) {
					refranEncontrado = refranes[i];
					encontrado = true;
				}
			}
		}
		return refranEncontrado;
	}

}
