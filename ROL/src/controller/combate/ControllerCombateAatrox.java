package controller.combate;

import java.util.Random;
//TODO SALIDA DEL SWITCH DEBIDO A LA PREFERENCIA DE TURNO.

import controller.enemigos.ControllerEnemigoAleatorio;
import controller.enemigos.ControllerEnemigoPrincipal;
import controller.personajes.ControllerAatrox;
import model.enemigos.EnemigoAleatorio;
import model.enemigos.EnemigoPrincipal;
import model.personajes.Aatrox;
import vista.ImpresionMensajes;

public class ControllerCombateAatrox {

	public static void combateAatroxBoss(Aatrox aatrox, EnemigoPrincipal boss, int opciones) {
		Random numAleatorio = new Random(System.nanoTime());

		int opcionAtaquePrimero = numAleatorio.nextInt(1 - 0 + 1) + 1;
		int opcionAtaqueBoss = numAleatorio.nextInt(1 - 0 + 1) + 1;

		switch (opcionAtaquePrimero) {
		// Primero Atacas tu.

		case 1:
			switch (opciones) {
			// Ataque
			case 1:
				boss.setVida(boss.getVida() - ControllerAatrox.ataqueBasico(aatrox));
				ImpresionMensajes.mensajeAtaquePersonaje(ControllerAatrox.ataqueBasico(aatrox));

				break;
			// Proteger
			case 2:
				aatrox.setVida(aatrox.getVida() - (ControllerAatrox.proteger(boss)));
				ImpresionMensajes.mensajeProtegerPersonaje(ControllerAatrox.proteger(boss));
				if (aatrox.getVida() < aatrox.getVidaMaxima() - ControllerAatrox.restaurarVida(aatrox)) {

					aatrox.setVida(aatrox.getVida() + ControllerAatrox.restaurarVida(aatrox));
					ImpresionMensajes.mensajeSanarPersonaje(ControllerAatrox.restaurarVida(aatrox));
				}
				break;
			// Ataque habilidad
			case 3:
				boss.setVida(boss.getVida() - ControllerAatrox.ataqueHabilidad(aatrox));
				aatrox.setVida(aatrox.getVida() - ControllerAatrox.gastoRecursos(aatrox));
				ImpresionMensajes.mensajeAtaquePersonaje(ControllerAatrox.ataqueHabilidad(aatrox));
				ImpresionMensajes.gastoRecursosVida(ControllerAatrox.gastoRecursos(aatrox));
				break;
			default:
				break;
			}
			if (boss.getVida() > 0.0) {
				switch (opcionAtaqueBoss) {
				case 1:
					if (opciones == 2) {

					} else {
						aatrox.setVida(aatrox.getVida() - ControllerEnemigoPrincipal.ataqueBasico(boss));
						ImpresionMensajes.mensajeAtaqueJefe(ControllerEnemigoPrincipal.ataqueBasico(boss));
					}
					break;

				case 2:

					boss.setVida(boss.getVida() + ControllerEnemigoPrincipal.sanarVida(boss.getVida(), boss));
					ImpresionMensajes.mensajeSanarJefe(ControllerEnemigoPrincipal.sanarVida(boss.getVida(), boss));

					break;

				default:
					break;
				}
			}
			break;

		// Primero ataca enemigo.

		case 2:
			switch (opcionAtaqueBoss) {
			case 1:
				if (opciones == 2) {

				} else {
					aatrox.setVida(aatrox.getVida() - ControllerEnemigoPrincipal.ataqueBasico(boss));
					ImpresionMensajes.mensajeAtaqueJefe(ControllerEnemigoPrincipal.ataqueBasico(boss));
				}
				break;

			case 2:

				boss.setVida(boss.getVida() + ControllerEnemigoPrincipal.sanarVida(boss.getVida(), boss));
				ImpresionMensajes.mensajeSanarJefe(ControllerEnemigoPrincipal.sanarVida(boss.getVida(), boss));

				break;

			default:
				break;
			}
			// Atacas tu
			if (aatrox.getVida() > 0.0) {
				switch (opciones) {
				// Ataque
				case 1:
					boss.setVida(boss.getVida() - ControllerAatrox.ataqueBasico(aatrox));
					ImpresionMensajes.mensajeAtaquePersonaje(ControllerAatrox.ataqueBasico(aatrox));
					break;
				// Proteger
				case 2:
					aatrox.setVida(aatrox.getVida() - (ControllerAatrox.proteger(boss)));
					ImpresionMensajes.mensajeProtegerPersonaje(ControllerAatrox.proteger(boss));
					if (aatrox.getVida() < aatrox.getVidaMaxima() - ControllerAatrox.restaurarVida(aatrox)) {

						aatrox.setVida(aatrox.getVida() + ControllerAatrox.restaurarVida(aatrox));
						ImpresionMensajes.mensajeSanarPersonaje(ControllerAatrox.restaurarVida(aatrox));
					}
					break;
				// Ataque habilidad
				case 3:
					boss.setVida(boss.getVida() - ControllerAatrox.ataqueHabilidad(aatrox));
					aatrox.setVida(aatrox.getVida() - ControllerAatrox.gastoRecursos(aatrox));
					ImpresionMensajes.mensajeAtaquePersonaje(ControllerAatrox.ataqueHabilidad(aatrox));
					ImpresionMensajes.gastoRecursosVida(ControllerAatrox.gastoRecursos(aatrox));
					break;
				default:
					break;
				}
			}
			break;

		default:
			break;
		}

	}

	public static void combateAatroxEnemigoAleatorio(Aatrox aatrox, EnemigoAleatorio esbirro, int opciones) {
		Random numAleatorio = new Random(System.nanoTime());

		int opcionAtaquePrimero = numAleatorio.nextInt(1 - 0 + 1) + 1;
		int opcionAtaqueBoss = numAleatorio.nextInt(1 - 0 + 1) + 1;

		switch (opcionAtaquePrimero) {
		// Primero Atacas tu.

		case 1:
			switch (opciones) {
			// Ataque
			case 1:
				esbirro.setVida(esbirro.getVida() - ControllerAatrox.ataqueBasico(aatrox));
				ImpresionMensajes.mensajeAtaquePersonaje(ControllerAatrox.ataqueBasico(aatrox));
				break;
			// Proteger
			case 2:
				ImpresionMensajes.mensajeProtegerPersonaje(ControllerAatrox.proteger(esbirro));
				if (aatrox.getVida() < aatrox.getVidaMaxima() - ControllerAatrox.restaurarVida(aatrox)) {

					aatrox.setVida(aatrox.getVida() + ControllerAatrox.restaurarVida(aatrox));
					ImpresionMensajes.mensajeSanarPersonaje(ControllerAatrox.restaurarVida(aatrox));
				}
				break;
			// Ataque habilidad
			case 3:
				esbirro.setVida(esbirro.getVida() - ControllerAatrox.ataqueHabilidad(aatrox));
				aatrox.setVida(aatrox.getVida() - ControllerAatrox.gastoRecursos(aatrox));
				ImpresionMensajes.mensajeAtaquePersonaje(ControllerAatrox.ataqueHabilidad(aatrox));
				ImpresionMensajes.gastoRecursosVida(ControllerAatrox.gastoRecursos(aatrox));
				break;
			default:
				break;
			}
			if (esbirro.getVida() > 0.0) {
				switch (opcionAtaqueBoss) {
				case 1:
					if (opciones == 2) {

					} else {
						aatrox.setVida(aatrox.getVida() - ControllerEnemigoAleatorio.ataqueBasico(esbirro));
						ImpresionMensajes.mensajeAtaqueJefe(ControllerEnemigoAleatorio.ataqueBasico(esbirro));
					}
					break;

				case 2:

					esbirro.setVida(
							esbirro.getVida() + ControllerEnemigoAleatorio.sanarVida(esbirro.getVida(), esbirro));
					ImpresionMensajes
							.mensajeSanarJefe(ControllerEnemigoAleatorio.sanarVida(esbirro.getVida(), esbirro));

					break;

				default:
					break;
				}
			}
			break;

		// Primero ataca enemigo.

		case 2:
			switch (opcionAtaqueBoss) {
			case 1:
				if (opciones == 2) {

				} else {
					aatrox.setVida(aatrox.getVida() - ControllerEnemigoAleatorio.ataqueBasico(esbirro));
					ImpresionMensajes.mensajeAtaqueJefe(ControllerEnemigoAleatorio.ataqueBasico(esbirro));
				}
				break;

			case 2:

				esbirro.setVida(esbirro.getVida() + ControllerEnemigoAleatorio.sanarVida(esbirro.getVida(), esbirro));
				ImpresionMensajes.mensajeSanarJefe(ControllerEnemigoAleatorio.sanarVida(esbirro.getVida(), esbirro));

				break;

			default:
				break;
			}
			// Atacas tu
			if (aatrox.getVida() > 0.0) {
				switch (opciones) {
				// Ataque
				case 1:
					esbirro.setVida(esbirro.getVida() - ControllerAatrox.ataqueBasico(aatrox));
					ImpresionMensajes.mensajeAtaquePersonaje(ControllerAatrox.ataqueBasico(aatrox));
					break;
				// Proteger
				case 2:
					ImpresionMensajes.mensajeProtegerPersonaje(ControllerAatrox.proteger(esbirro));
					if (aatrox.getVida() < aatrox.getVidaMaxima() - ControllerAatrox.restaurarVida(aatrox)) {

						aatrox.setVida(aatrox.getVida() + ControllerAatrox.restaurarVida(aatrox));
						ImpresionMensajes.mensajeSanarPersonaje(ControllerAatrox.restaurarVida(aatrox));
					}
					// Ataque habilidad
				case 3:
					esbirro.setVida(esbirro.getVida() - ControllerAatrox.ataqueHabilidad(aatrox));
					aatrox.setVida(aatrox.getVida() - ControllerAatrox.gastoRecursos(aatrox));
					ImpresionMensajes.mensajeAtaquePersonaje(ControllerAatrox.ataqueHabilidad(aatrox));
					ImpresionMensajes.gastoRecursosVida(ControllerAatrox.gastoRecursos(aatrox));
					break;
				default:
					break;
				}
			}
			break;

		default:
			break;
		}

	}

}
