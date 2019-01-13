package controller.personajes;

import model.enemigos.EnemigoPrincipal;
import model.personajes.Azir;

public class ControllerAzir {
	
	public static double restaurarVida(Azir azir) {
		double sanacion = 15;
		return azir.getVida() + sanacion;
	}

	public static double ataqueBasico(Azir azir) {
		double ataque;
		ataque = azir.getAtaque(); //* 2.3;
		return ataque;
	}

	public static double ataqueHabilidad(Azir azir) {
		double habilidad;
		habilidad = azir.getPoderHabilidad(); //* 2.3;
		return habilidad;
	}

	public static int gastoRecursos(Azir azir) {
		int recursos;
		recursos = azir.getRecursos() - 100;
		return recursos;
	}

	public static double proteger(EnemigoPrincipal boss) {
		double ataque;
		ataque = boss.getAtaque() - boss.getAtaque();
		return ataque;

	}
	public static int restaurarRecursos(Azir azir) {
		int recursos = 50;
		return azir.getRecursos()+ recursos;
	}
}
