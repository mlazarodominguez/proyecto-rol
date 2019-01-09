package controller.personajes;

import model.enemigos.EnemigoPrincipal;
import model.personajes.Neeko;

public class ControllerNeeko {

	public static double ataqueBasico(Neeko neeko) {
		double ataque;
		ataque = neeko.getAtaque() * 2.3;

		return ataque;

	}

	public static double ataqueHabilidad(Neeko neeko) {
		double habilidad;
		habilidad = neeko.getPoderHabilidad() * 2.3;
		return habilidad;
	}

	public static int gastoRecursos(Neeko neeko) {
		int recursos;
		recursos = neeko.getRecursos() - 25;
		return recursos;
	}

	public static double proteger(EnemigoPrincipal boss) {
		double ataque;
		ataque = boss.getAtaque() - boss.getAtaque();
		return ataque;

	}

}
