package ejercicio2;


public class Baraja {

	private Carta arrayCartas[];
	private int cartasRestantes;

	public static final int TOTAL_CARTAS = 48;
	public static final int NUMERO_MAXIMO_PALO = 12;
	public static final String[] PALOS = { "oros", "copas", "espadas", "bastos" };

	public Baraja() throws CartaException {
		int numeroActual;
		String paloActual;
		arrayCartas=new Carta[TOTAL_CARTAS];
		
		for (int i = 0; i < PALOS.length; i++) {
			paloActual=PALOS[i];
			for (int j = 1; j <= NUMERO_MAXIMO_PALO; j++) {
				numeroActual=j;
				arrayCartas[cartasRestantes]=new Carta(numeroActual,paloActual);
				cartasRestantes++;
				
			}
			
		}

	}

	public int getCartasRestantes() {
		return cartasRestantes;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder info=new StringBuilder();
		for (Carta carta: arrayCartas) {
			if ( carta!=null) {
				info.append(carta + " , ");
			}
		}
		return "Baraja [arrayCartas=" + info.toString() + ", cartasRestantes=" + cartasRestantes + "]";
	}

	public Carta repartirCartas() throws CartaException {
		if(cartasRestantes<=0) {
			throw new CartaException("No quedan cartas");
		}
		
		Carta carta1=null;
		int numeroCarta=0;
		
		while(carta1==null) {
			numeroCarta=(int) (Math.random()*48);
			carta1=arrayCartas[numeroCarta];
		}
		
		arrayCartas[numeroCarta]=null;
		cartasRestantes--;
		
		
		return carta1;
		
	}
	
	public Carta[] repartirCartas(int numeroCartas) throws CartaException {
		if(cartasRestantes<=0) {
			throw new CartaException("No quedan cartas");
		}
		if(numeroCartas>cartasRestantes) {
			throw new CartaException("No hay suficientes cartas");
		}
		if(numeroCartas<=0) {
			throw new CartaException("No se pueden pedir cartas negativas");
		}
		
		Carta[] cartas1=new Carta[numeroCartas];
		int numeroCarta=(int) (Math.random()*48);
		
		for (int i = 0; i < cartas1.length; i++) {
			while(arrayCartas[numeroCarta]==null) {
				numeroCarta=(int) (Math.random()*48);
			}
			cartas1[i]=arrayCartas[numeroCarta];
			arrayCartas[numeroCarta]=null;
			cartasRestantes--;
			
		}
		
		return cartas1;
		
	}
	

}
