package model.loot;

public class LootPoderHabilidad {

	private int poderHabilidad;
	private int recursos;
	private String nombre;

	public LootPoderHabilidad() {

	}

	public LootPoderHabilidad(int poderHabilidad, int recursos, String nombre) {
		super();
		this.poderHabilidad = poderHabilidad;
		this.recursos = recursos;
		this.nombre = nombre;
	}

	public int getPoderHabilidad() {
		return poderHabilidad;
	}

	public void setPoderHabilidad(int poderHabilidad) {
		this.poderHabilidad = poderHabilidad;
	}

	public int getRecursos() {
		return recursos;
	}

	public void setRecursos(int recursos) {
		this.recursos = recursos;
	}

	public String getNombre() {
		return nombre;
	}

	public String toString() {
		return "LootPoderHabilidad [poderHabilidad=" + poderHabilidad + ", recursos=" + recursos + ", nombre=" + nombre
				+ "]";
	}

}
