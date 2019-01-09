package controller.personajes;

import model.enemigos.EnemigoPrincipal;
import model.personajes.Aatrox;

public class ControllerAatrox {

	public static double ataqueBasico(Aatrox aatrox) {
		double ataque;
		ataque = aatrox.getAtaque() * 2.3;

		return ataque;

	}

	public static double ataqueHabilidad(Aatrox aatrox) {
		double habilidad;
		habilidad = aatrox.getPoderHabilidad() * 2.3;
		return habilidad;
	}

	public static double gastoRecursos(Aatrox aatrox) {
		double recursos;
		recursos = 5;
		return recursos;
	}

	public static double proteger(EnemigoPrincipal boss) {
		double ataque;
		ataque = boss.getAtaque() - boss.getAtaque();
		return ataque;

	}
}
