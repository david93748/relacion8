package ejercicio3;

public class Principal {

	public static void main(String[] args) {
		Hotel hotel1 = null;
		
		try {
			hotel1=new Hotel(1,2,3);
			
			System.out.println(hotel1);
			
			System.out.println(hotel1.checkIn("triple"));
			
			System.out.println(hotel1);
			
			hotel1.checkOut(4);
			
			System.out.println(hotel1);
		} catch (HotelException e) {
			System.out.println(e.getMessage());
		}
	}

}
