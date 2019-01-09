package controller.enemigos;

import model.enemigos.EnemigoAleatorio;

public class ControllerEnemigoAleatorio {

	public static double ataqueBasico(EnemigoAleatorio e1) {
		double valor;
		valor = e1.getAtaque() * 2.3;
		return valor;
	}

	public static double ataquePotenciado(EnemigoAleatorio e1) {
		double valor;
		valor = e1.getAtaque() * 3.6;
		return valor;
	}
	
	public static double sanarVida(double vida, EnemigoAleatorio e1) {
		double sanacion;
		double sanacionBase=25;
		//25 de sanacion
		if(vida<e1.getVida() && vida>e1.getVida()-sanacionBase) {
			sanacion = e1.getVida()-vida;
		}else {
			sanacion=sanacionBase;
		}
		return sanacion;
}
}
