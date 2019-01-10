package controller.combate;

import java.util.Random;

import controller.enemigos.ControllerEnemigoAleatorio;
import controller.enemigos.ControllerEnemigoPrincipal;
import controller.personajes.ControllerNeeko;
import model.enemigos.EnemigoAleatorio;
import model.enemigos.EnemigoPrincipal;
import model.personajes.Neeko;
import vista.ImpresionMensajes;

//TODO SALIDA DEL SWITCH DEBIDO A LA PREFERENCIA DE TURNO.
public class ControllerCombateNeeko {

	public static void combateNeekoBoss(Neeko neeko, EnemigoPrincipal boss, int opciones) {
		Random numAleatorio = new Random(System.nanoTime());

		int opcionAtaquePrimero = numAleatorio.nextInt(1 - 0 + 1) + 1;
		int opcionAtaqueBoss = numAleatorio.nextInt(1 - 0 + 1) + 1;
		switch (opcionAtaquePrimero) {
		// Atacas tu primero
		case 1:
			switch (opciones) {
			// Ataque básico
			case 1:
				boss.setVida(boss.getVida() - ControllerNeeko.ataqueBasico(neeko));
				ImpresionMensajes.mensajeAtaquePersonaje(ControllerNeeko.ataqueBasico(neeko));
				break;
			// Proteger
			case 2:

				neeko.setVida(neeko.getVida() - (ControllerNeeko.proteger(boss)));
				ImpresionMensajes.mensajeProtegerPersonaje(ControllerNeeko.proteger(boss));
				break;
			// Ataque habilidad
			case 3:
				boss.setVida(boss.getVida() - ControllerNeeko.ataqueHabilidad(neeko));
				neeko.setRecursos(ControllerNeeko.gastoRecursos(neeko));
				ImpresionMensajes.mensajeAtaquePersonaje(ControllerNeeko.ataqueHabilidad(neeko));
				ImpresionMensajes.gastoRecursosMana(ControllerNeeko.gastoRecursos(neeko));
				break;

			default:
				break;
			}
			if (boss.getVida() > 0.0) {
				switch (opcionAtaqueBoss) {
				case 1:
					if (opciones == 2) {

					} else {
						neeko.setVida(neeko.getVida() - ControllerEnemigoPrincipal.ataqueBasico(boss));
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

		case 2:
			switch (opcionAtaqueBoss) {
			case 1:
				if (opciones == 2) {

				} else {
					neeko.setVida(neeko.getVida() - ControllerEnemigoPrincipal.ataqueBasico(boss));
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
			if (neeko.getVida() > 0.0) {

				switch (opciones) {
				// Ataque básico
				case 1:
					boss.setVida(boss.getVida() - ControllerNeeko.ataqueBasico(neeko));
					ImpresionMensajes.mensajeAtaquePersonaje(ControllerNeeko.ataqueBasico(neeko));
					break;
				// Proteger
				case 2:

					neeko.setVida(neeko.getVida() - (ControllerNeeko.proteger(boss)));
					ImpresionMensajes.mensajeProtegerPersonaje(ControllerNeeko.proteger(boss));
					break;
				// Ataque habilidad
				case 3:
					boss.setVida(boss.getVida() - ControllerNeeko.ataqueHabilidad(neeko));
					neeko.setRecursos(ControllerNeeko.gastoRecursos(neeko));
					ImpresionMensajes.mensajeAtaquePersonaje(ControllerNeeko.ataqueHabilidad(neeko));
					ImpresionMensajes.gastoRecursosMana(ControllerNeeko.gastoRecursos(neeko));
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

	public static void combateNeekoEnemigoAleatorio(EnemigoAleatorio esbirro, Neeko neeko, int opciones) {
		Random numAleatorio = new Random(System.nanoTime());

		int opcionAtaquePrimero = numAleatorio.nextInt(1 - 0 + 1) + 1;
		int opcionAtaqueBoss = numAleatorio.nextInt(1 - 0 + 1) + 1;

		switch (opcionAtaquePrimero) {
		// Primero Atacas tu.

		case 1:
			switch (opciones) {
			// Ataque
			case 1:
				esbirro.setVida(esbirro.getVida() - ControllerNeeko.ataqueBasico(neeko));
				ImpresionMensajes.mensajeAtaquePersonaje(ControllerNeeko.ataqueBasico(neeko));
				break;
			// Proteger
			case 2:

				break;
			// Ataque habilidad
			case 3:
				esbirro.setVida(esbirro.getVida() - ControllerNeeko.ataqueHabilidad(neeko));
				neeko.setVida(neeko.getVida() - ControllerNeeko.gastoRecursos(neeko));
				ImpresionMensajes.mensajeAtaquePersonaje(ControllerNeeko.ataqueHabilidad(neeko));
				ImpresionMensajes.gastoRecursosVida(ControllerNeeko.gastoRecursos(neeko));
				break;
			default:
				break;
			}
			if (esbirro.getVida() > 0.0) {
				switch (opcionAtaqueBoss) {
				case 1:
					if (opciones == 2) {

					} else {
						neeko.setVida(neeko.getVida() - ControllerEnemigoAleatorio.ataqueBasico(esbirro));
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
					neeko.setVida(neeko.getVida() - ControllerEnemigoAleatorio.ataqueBasico(esbirro));
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
			if (neeko.getVida() > 0.0) {
				switch (opciones) {
				// Ataque
				case 1:
					esbirro.setVida(esbirro.getVida() - ControllerNeeko.ataqueBasico(neeko));
					ImpresionMensajes.mensajeAtaquePersonaje(ControllerNeeko.ataqueBasico(neeko));
					break;
				// Proteger
				case 2:

					// Ataque habilidad
				case 3:
					esbirro.setVida(esbirro.getVida() - ControllerNeeko.ataqueHabilidad(neeko));
					neeko.setVida(neeko.getVida() - ControllerNeeko.gastoRecursos(neeko));
					ImpresionMensajes.mensajeAtaquePersonaje(ControllerNeeko.ataqueHabilidad(neeko));
					ImpresionMensajes.gastoRecursosVida(ControllerNeeko.gastoRecursos(neeko));
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
