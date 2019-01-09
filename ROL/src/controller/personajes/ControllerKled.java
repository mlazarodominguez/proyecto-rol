package controller.personajes;

import model.enemigos.EnemigoPrincipal;
import model.personajes.Kled;

public class ControllerKled {

	public static double ataqueBasico(Kled kled) {
		double ataque;
		ataque = kled.getAtaque() * 2.3;

		return ataque;

	}

	public static double ataqueHabilidad(Kled kled) {
		double habilidad;
		habilidad = kled.getPoderHabilidad() * 2.3;
		return habilidad;
	}

	public static int gastoRecursos(Kled kled) {
		int recursos;
		recursos = kled.getRecursos() - 25;
		return recursos;
	}

	public static double proteger(EnemigoPrincipal boss) {
		double ataque;
		ataque = boss.getAtaque() - boss.getAtaque();
		return ataque;

	}

}
