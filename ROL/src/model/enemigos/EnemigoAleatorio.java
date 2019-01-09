package model.enemigos;

public class EnemigoAleatorio {
	
	//Atributos
	
	private double vida;
	private double vidaMax;
	private int ataque;
	private int armadura;
	private String nombre;
	private int identificador;
	
	//Constructores
	
	public EnemigoAleatorio() {
		
	}
	
	public EnemigoAleatorio(double vida,double vidaMax, int ataque, int armadura, String nombre, int identificador) {
		super();
		this.vida = vida;
		this.vidaMax=vidaMax;
		this.ataque = ataque;
		this.armadura = armadura;
		this.nombre = nombre;
		this.identificador = identificador;
	}

	//Get and Set
	
	public double getVida() {
		return vida;
	}

	public void setVida(double vida) {
		this.vida = vida;
	}
	
	public double getVidaMax() {
		return vidaMax;
	}

	public void setVidaMax(double vidaMax) {
		this.vidaMax = vidaMax;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getArmadura() {
		return armadura;
	}

	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	//To String
	
	public String toString() {
		return "EnemigoAleatorio [vida=" + vida + ", vidaMax="+ vidaMax +", ataque=" + ataque + ", armadura=" + armadura + ", nombre=" + nombre
				+ ", identificador=" + identificador + "]";
	}
	
}