package model.loot;

public class LootAtaque {

	private int vida;
	private int ataque;
	private String nombre;

	public LootAtaque() {

	}

	public LootAtaque(int vida, int ataque, String nombre) {
		super();
		this.vida = vida;
		this.ataque = ataque;
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public String getNombre() {
		return nombre;
	}

	public String toString() {
		return "LootAtaque [vida=" + vida + ", ataque=" + ataque + ", nombre=" + nombre + "]";
	}

}
