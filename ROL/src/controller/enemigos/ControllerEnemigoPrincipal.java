package controller.enemigos;

import model.enemigos.EnemigoPrincipal;

public class ControllerEnemigoPrincipal {

	public static double ataqueBasico(EnemigoPrincipal boss) {
		double ataque;
		ataque = boss.getAtaque()* 1.2;
		return ataque;
	}

	public static double ataquePotenciado(EnemigoPrincipal boss) {
		double ataquePotenciado;
		ataquePotenciado = boss.getAtaque() * 3.4;
		return ataquePotenciado;
	}

	public static double sanarVida(double vida, EnemigoPrincipal boss) {
		double sanacion = 0;
		double sanacionBase = 15;
		if (boss.getVidaMax() - vida < sanacionBase && vida < boss.getVidaMax()) {
			sanacion = boss.getVidaMax() - vida;
		} else if (boss.getVidaMax() - vida > sanacionBase) {
			sanacion = sanacionBase;
		} else if (boss.getVidaMax() == vida) {
			sanacion = 0;
		}
		return sanacion;
	}
}
