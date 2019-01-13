package crud.personajes;

import model.personajes.Aatrox;



public class CrudAatrox {

	private static Aatrox a;

	public static void incrementarAtaque(int aumento) {
		a.setAtaque(a.getAtaque() + aumento);
	}

	public static void incrementarVida(int aumento) {
		a.setVida(a.getVida() + aumento);
	}

	public static void incrementarPoderHabilidad(int aumento) {
		a.setPoderHabilidad(a.getPoderHabilidad() + aumento);
	}
}