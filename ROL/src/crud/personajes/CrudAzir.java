package crud.personajes;

import model.personajes.Azir;

public class CrudAzir {

	private static Azir a;

	public static void incrementarAtaque(int aumento) {
		a.setAtaque(a.getAtaque() + aumento);
	}

	public static void incrementarVida(int aumento) {

		a.setVida(a.getVida() + aumento);
	}

	public static void incrementearDefensa(int aumento) {
		a.setDefensa(a.getDefensa() + aumento);
	}

	public static void incrementarPoderHabilidad(int aumento) {
		a.setPoderHabilidad(a.getPoderHabilidad() + aumento);
	}

	public static void incrementarRecursos(int aumento) {
		a.setRecursos(a.getRecursos() + aumento);
	}
}
