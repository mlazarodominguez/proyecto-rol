package crud.personajes;

import model.personajes.Kled;

public class CrudKled {

	private static Kled k;

	public static void incrementarAtaque(int aumento) {
		k.setAtaque(k.getAtaque() + aumento);
	}

	public static void incrementarVida(int aumento) {

		k.setVida(k.getVida() + aumento);
	}

	public static void incrementearDefensa(int aumento) {
		k.setDefensa(k.getDefensa() + aumento);
	}

	public static void incrementarPoderHabilidad(int aumento) {
		k.setPoderHabilidad(k.getPoderHabilidad() + aumento);
	}

	public static void incrementarRecursos(int aumento) {
		k.setRecursos(k.getRecursos() + aumento);
	}
}
