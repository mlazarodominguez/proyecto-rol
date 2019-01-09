package model.loot;

public class LootDefensa {

	private int defensa;
	private int vida;
	private String nombre;

	public LootDefensa() {

	}

	public LootDefensa(int defensa, int vida, String nombre) {
		super();
		this.defensa = defensa;
		this.vida = vida;
		this.nombre = nombre;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public String getNombre() {
		return nombre;
	}

	public String toString() {
		return "LootDefensa [defensa=" + defensa + ", vida=" + vida + ", nombre=" + nombre + "]";
	}

}
