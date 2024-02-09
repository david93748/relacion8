package ejercicio1;

public class Refran implements Comparable<Refran>{
	private String nombre;
	private int popularidad;
	
	public Refran(String nombre, int popularidad) throws RefranException {
		setNombre(nombre);
		setPopularidad(popularidad);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}
	public int getPopularidad() {
		return popularidad;
	}
	public void setPopularidad(int popularidad) throws RefranException {
		if ( popularidad < 0 || popularidad > 100) {
			throw new RefranException("Popularidad incorrecta");
		}
		this.popularidad = popularidad;
	}
	@Override
	public String toString() {
		return "Refran [nombre=" + nombre + ", popularidad=" + popularidad + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Refran other = (Refran) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public int compareTo(Refran otro) {
		return otro.popularidad-this.popularidad;
	};
	
	
}
