package controller.combate;

import java.util.Random;

import controller.enemigos.ControllerEnemigoAleatorio;
import controller.enemigos.ControllerEnemigoPrincipal;
import controller.personajes.ControllerKled;
import model.enemigos.EnemigoAleatorio;
import model.enemigos.EnemigoPrincipal;
import model.personajes.Kled;
import vista.ImpresionMensajes;

public class ControllerCombateKled {

	public static void combateKledBoss(Kled kled1, EnemigoPrincipal boss, int opciones) {
		Random r1 = new Random(System.nanoTime());
		int aleatorioTurno = r1.nextInt(1 - 0 + 1) + 1;
		int opcionesBoss = r1.nextInt(1 - 0 + 1) + 1;

		switch (aleatorioTurno) {

		case 1:
			// Yo ataco primero
			switch (opciones) {
			case 1:
				// Ataque básico
				boss.setVida(boss.getVida() - ControllerKled.ataqueBasico(kled1));
				ImpresionMensajes.mensajeAtaquePersonaje(ControllerKled.ataqueBasico(kled1));
				break;
			case 2:
				// Proteger
				ImpresionMensajes.mensajeProtegerPersonaje(ControllerKled.proteger(boss));
				break;
			case 3:
				// Ataque de habilidad
				boss.setVida(boss.getVida() - ControllerKled.ataqueHabilidad(kled1));
				// TODO restriccion para que solo pueda usar el ataque de habilidad una vez
				kled1.setRecursos(kled1.getRecursos() - ControllerKled.gastoRecursos(kled1));
				ImpresionMensajes.mensajeAtaquePersonaje(ControllerKled.ataqueHabilidad(kled1));
				ImpresionMensajes.gastoRecursosMana(ControllerKled.gastoRecursos(kled1));
				break;
			default:
				break;
			}
			// Segundo ataca Boss
			if (boss.getVida() > 0.0) {
				switch (opcionesBoss) {
				case 1:
					// Ataque Básico Boss
					if (opciones == 2) {

					} else {
						kled1.setVida(kled1.getVida() - ControllerEnemigoPrincipal.ataqueBasico(boss));
						ImpresionMensajes.mensajeAtaqueJefe(ControllerEnemigoPrincipal.ataqueBasico(boss));
					}
					break;
				case 2:
					// Sanacion del boss
					boss.setVida(boss.getVida() + ControllerEnemigoPrincipal.sanarVida(boss.getVida(), boss));
					ImpresionMensajes.mensajeSanarJefe(ControllerEnemigoPrincipal.sanarVida(boss.getVida(), boss));
					break;

				default:
					break;
				}
			}
			break;

		case 2:
			// Primero ataca boss
			switch (opcionesBoss) {
			case 1:
				// Ataque Básico Boss
				if (opciones == 2) {

				} else {
					kled1.setVida(kled1.getVida() - ControllerEnemigoPrincipal.ataqueBasico(boss));
					ImpresionMensajes.mensajeAtaqueJefe(ControllerEnemigoPrincipal.ataqueBasico(boss));
				}
				break;
			case 2:
				// Sanacion del boss
				boss.setVida(boss.getVida() + ControllerEnemigoPrincipal.sanarVida(boss.getVida(), boss));
				ImpresionMensajes.mensajeSanarJefe(ControllerEnemigoPrincipal.sanarVida(boss.getVida(), boss));
				break;

			default:
				break;
			}
			// Segungo ataco yo
			if (kled1.getVida() > 0.0) {
				switch (opciones) {
				case 1:
					// Ataque básico
					boss.setVida(boss.getVida() - ControllerKled.ataqueBasico(kled1));
					ImpresionMensajes.mensajeAtaquePersonaje(ControllerKled.ataqueBasico(kled1));
					break;
				case 2:
					// Proteger
					ImpresionMensajes.mensajeProtegerPersonaje(ControllerKled.proteger(boss));
					break;
				case 3:
					// Ataque de habilidad
					boss.setVida(boss.getVida() - ControllerKled.ataqueHabilidad(kled1));
					// TODO restriccion para que solo pueda usar el ataque de habilidad una vez
					kled1.setRecursos(kled1.getRecursos() - ControllerKled.gastoRecursos(kled1));
					ImpresionMensajes.mensajeAtaquePersonaje(ControllerKled.ataqueHabilidad(kled1));
					ImpresionMensajes.gastoRecursosMana(ControllerKled.gastoRecursos(kled1));
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

	public static void combateKledEnemigoAleatorio(Kled kled1, EnemigoAleatorio esbirro, int opciones) {
		Random r1 = new Random(System.nanoTime());
		int aleatorioTurno = r1.nextInt(1 - 0 + 1) + 1;
		int opcionesBoss = r1.nextInt(1 - 0 + 1) + 1;

		switch (aleatorioTurno) {
		case 1:
			// Yo ataco primero
			switch (opciones) {
			case 1:
				// Ataque básico
				esbirro.setVida(esbirro.getVida() - ControllerKled.ataqueBasico(kled1));
				ImpresionMensajes.mensajeAtaquePersonaje(ControllerKled.ataqueBasico(kled1));
				break;
			case 2:
				// Proteger

				break;
			case 3:
				// Ataque de habilidad
				esbirro.setVida(esbirro.getVida() - ControllerKled.ataqueHabilidad(kled1));
				// TODO restriccion para que solo pueda usar el ataque de habilidad una vez
				kled1.setRecursos(kled1.getRecursos() - ControllerKled.gastoRecursos(kled1));
				ImpresionMensajes.mensajeAtaquePersonaje(ControllerKled.ataqueHabilidad(kled1));
				ImpresionMensajes.gastoRecursosMana(ControllerKled.gastoRecursos(kled1));
				break;
			default:
				break;
			}
			// Segundo ataca Boss
			if (esbirro.getVida() > 0.0) {
				switch (opcionesBoss) {
				case 1:
					// Ataque Básico Boss
					if (opciones == 2) {

					} else {
						kled1.setVida(kled1.getVida() - ControllerEnemigoAleatorio.ataqueBasico(esbirro));
						ImpresionMensajes.mensajeAtaqueJefe(ControllerEnemigoAleatorio.ataqueBasico(esbirro));
					}
					break;
				case 2:
					// Sanacion del boss
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

		case 2:
			// Primero ataca boss
			switch (opcionesBoss) {
			case 1:
				// Ataque Básico Boss
				if (opciones == 2) {

				} else {
					kled1.setVida(kled1.getVida() - ControllerEnemigoAleatorio.ataqueBasico(esbirro));
					ImpresionMensajes.mensajeAtaqueJefe(ControllerEnemigoAleatorio.ataqueBasico(esbirro));
				}
				break;
			case 2:
				// Sanacion del boss
				esbirro.setVida(esbirro.getVida() + ControllerEnemigoAleatorio.sanarVida(esbirro.getVida(), esbirro));
				ImpresionMensajes.mensajeSanarJefe(ControllerEnemigoAleatorio.sanarVida(esbirro.getVida(), esbirro));
				break;

			default:
				break;
			}
			// Segungo ataco yo
			if (kled1.getVida() > 0.0) {
				switch (opciones) {
				case 1:
					// Ataque básico
					esbirro.setVida(esbirro.getVida() - ControllerKled.ataqueBasico(kled1));
					ImpresionMensajes.mensajeAtaquePersonaje(ControllerKled.ataqueBasico(kled1));
					break;
				case 2:
					// Proteger

					break;
				case 3:
					// Ataque de habilidad
					esbirro.setVida(esbirro.getVida() - ControllerKled.ataqueHabilidad(kled1));
					// TODO restriccion para que solo pueda usar el ataque de habilidad una vez
					kled1.setRecursos(kled1.getRecursos() - ControllerKled.gastoRecursos(kled1));
					ImpresionMensajes.mensajeAtaquePersonaje(ControllerKled.ataqueHabilidad(kled1));
					ImpresionMensajes.gastoRecursosMana(ControllerKled.gastoRecursos(kled1));
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
