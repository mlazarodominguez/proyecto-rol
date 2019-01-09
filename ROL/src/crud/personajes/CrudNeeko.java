package crud.personajes;

import model.personajes.Neeko;

public class CrudNeeko {
	private static Neeko n;

	public static void incrementarAtaque(int aumento) {
		n.setAtaque(n.getAtaque() + aumento);
	}

	public static void incrementarVida(int aumento) {

		n.setVida(n.getVida() + aumento);
	}

	public static void incrementearDefensa(int aumento) {
		n.setDefensa(n.getDefensa() + aumento);
	}

	public static void incrementarPoderHabilidad(int aumento) {
		n.setPoderHabilidad(n.getPoderHabilidad() + aumento);
	}

	public static void incrementarRecursos(int aumento) {
		n.setRecursos(n.getRecursos() + aumento);
	}
}
