package model.personajes;

public class Azir {

	private double vida;
	private int defensa;
	private int ataque;
	private int poderHabilidad;
	private String nombre;
	private int recursos;
	private int recursosMax;
	private double vidaMaxima;

	public Azir() {

	}

	public Azir(double vida, int defensa, int ataque, int poderHabilidad, String nombre, int recursos,int resursosMax,double vidaMaxima) {
		super();
		this.vida = vida;
		this.defensa = defensa;
		this.ataque = ataque;
		this.poderHabilidad = poderHabilidad;
		this.nombre = nombre;
		this.recursos = recursos;
		this.recursosMax = resursosMax;
		this.vidaMaxima= vidaMaxima;
	}

	public int getRecursosMax() {
		return recursosMax;
	}

	public void setRecursosMax(int recursosMax) {
		this.recursosMax = recursosMax;
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
		return "Azir [vida=" + vida + ", defensa=" + defensa + ", ataque=" + ataque + ", poderHabilidad="
				+ poderHabilidad + ", nombre=" + nombre + ", recursos=" + recursos + "]";
	}

}
