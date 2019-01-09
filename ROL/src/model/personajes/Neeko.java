package model.personajes;

public class Neeko {

	private double vida;
	private int defensa;
	private int ataque;
	private int poderHabilidad;
	private String nombre;
	private int recursos;
	private double vidaMaxima;

	public Neeko() {

	}

	public Neeko(double vida, int defensa, int ataque, int poderHabilidad, String nombre, int recursos,
			double vidaMaxima) {
		super();
		this.vida = vida;
		this.defensa = defensa;
		this.ataque = ataque;
		this.poderHabilidad = poderHabilidad;
		this.nombre = nombre;
		this.recursos = recursos;
		this.vidaMaxima = vidaMaxima;
	}

	public double getVida() {
		return vida;
	}

	public void setVida(double vida) {
		this.vida = vida;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
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

	public double getVidaMaxima() {
		return vidaMaxima;
	}

	public void setVidaMaxima(double vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}

	public String toString() {
		return "Neeko [vida=" + vida + ", defensa=" + defensa + ", ataque=" + ataque + ", poderHabilidad="
				+ poderHabilidad + ", nombre=" + nombre + ", recursos=" + recursos + "]";
	}

}
