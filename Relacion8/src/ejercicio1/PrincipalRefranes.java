package ejercicio1;

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

			numeroRealRefranes = tratarMenu(refranes, numeroRealRefranes);

		} while (opc != 4);

	}

	private static int tratarMenu(Refran[] refranes, int numeroRealRefranes) {
		int opcion = 0;
		String cadenaRefran;
		int popularidad;
		
		switch (opcion) {
		case 1:
			try {
				
			
			System.out.println("Introduce un refran:");
			cadenaRefran=teclado.nextLine();
			System.out.println("Introduce su popularidad 1-100");
			popularidad=Integer.parseInt(teclado.nextLine());
			
			refranes[numeroRealRefranes]=new Refran(cadenaRefran, popularidad);
			numeroRealRefranes++;
			
		}catch(RefranException e) {
		System.out.println(e.getMessage());
		}
	
			
			break;

		default:
			System.out.println("opcion incorrecta");
			break;
		}

	return 0;

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

}
