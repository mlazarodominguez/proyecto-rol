package controller.personajes;

import model.enemigos.EnemigoAleatorio;
import model.enemigos.EnemigoPrincipal;
import model.personajes.Aatrox;

public class ControllerAatrox {

	public static double ataqueBasico(Aatrox aatrox) {
		double ataque;
		ataque = aatrox.getAtaque() * 0.7;

		return ataque;

	}

	public static double ataqueHabilidad(Aatrox aatrox) {
		double habilidad;
		habilidad = aatrox.getPoderHabilidad() * 4.5;
		return habilidad;
	}

	public static double gastoRecursos(Aatrox aatrox) {
		double recursos;
		recursos = 25;
		return recursos;
	}

	public static double proteger(EnemigoPrincipal boss) {
		double ataque;
		ataque = boss.getAtaque() - boss.getAtaque();
		return ataque;

	}
	
	public static double restaurarVida(Aatrox aatrox) {
		double sanacion =15;
		return sanacion;
	}
	public static double proteger(EnemigoAleatorio esbirro) {
		double ataque;
		ataque = esbirro.getAtaque() - esbirro.getAtaque();
		return ataque;

	}
}
