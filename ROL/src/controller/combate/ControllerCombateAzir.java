package controller.combate;

import java.util.Random;

import controller.enemigos.ControllerEnemigoAleatorio;
import controller.enemigos.ControllerEnemigoPrincipal;
import controller.personajes.ControllerAzir;
import model.enemigos.EnemigoAleatorio;
import model.enemigos.EnemigoPrincipal;
import model.personajes.Azir;
import vista.ImpresionMensajes;
import vista.MensajesPrueba;

public class ControllerCombateAzir {

	public static void combateAzirBoss(Azir azir1, EnemigoPrincipal boss, int opciones) {
		Random r1 = new Random(System.nanoTime());
		int aleatorioTurno = r1.nextInt(1 - 0 + 1) + 1;
		int opcionesBoss = r1.nextInt(1 - 0 + 1) + 1;

		switch (aleatorioTurno) {
		case 1:
			// Yo ataco primero
			switch (opciones) {
			case 1:
				// Ataque básico
				boss.setVida(boss.getVida() - ControllerAzir.ataqueBasico(azir1));
				ImpresionMensajes.mensajeAtaquePersonaje(ControllerAzir.ataqueBasico(azir1));
				break;
			case 2:
				// Proteger, restauras vida y recursos
				if (ControllerAzir.restaurarVida(azir1)>azir1.getVidaMaxima() ) {
					azir1.setVida(azir1.getVidaMaxima());
					MensajesPrueba.mensajeProtegerPersonaje(ControllerAzir.proteger(boss));
				}else {
					azir1.setVida(ControllerAzir.restaurarVida(azir1));
					MensajesPrueba.mensajeProtegerPersonaje(ControllerAzir.proteger(boss));
				}
				if (ControllerAzir.restaurarRecursos(azir1)>azir1.getRecursosMax()) {
					azir1.setRecursos(azir1.getRecursosMax());
					ImpresionMensajes.restaurarRecursos();
				} else {
					azir1.setRecursos(ControllerAzir.restaurarRecursos(azir1));
					ImpresionMensajes.restaurarRecursos();
				}
				
				break;
			case 3:
				// Ataque de habilidad
				boss.setVida(boss.getVida() - ControllerAzir.ataqueHabilidad(azir1));

				azir1.setRecursos(ControllerAzir.gastoRecursos(azir1));
				ImpresionMensajes.mensajeAtaquePersonaje(ControllerAzir.ataqueHabilidad(azir1));
				break;
			default:
				break;
			}
			// Segundo ataca Boss
			if (boss.getVida() > 0.0) {
				while (boss.getVida()>=boss.getVidaMax() && opcionesBoss ==2) {
					opcionesBoss = r1.nextInt(1 - 0 + 1) + 1;
				}
				switch (opcionesBoss) {
				case 1:
					// Ataque Básico Boss
					if (opciones == 2) {
						boss.setVida(boss.getVida() + ControllerEnemigoPrincipal.sanarVida(boss.getVida(), boss));
						ImpresionMensajes.mensajeSanarJefe(ControllerEnemigoPrincipal.sanarVida(boss.getVida(), boss));
					} else {
						azir1.setVida(azir1.getVida() - ControllerEnemigoPrincipal.ataqueBasico(boss));
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
			while (boss.getVida()>=boss.getVidaMax() && opcionesBoss ==2) {
				opcionesBoss = r1.nextInt(1 - 0 + 1) + 1;
			}
			switch (opcionesBoss) {
			case 1:
				// Ataque Básico Boss
				if (opciones == 2) {
					boss.setVida(boss.getVida() + ControllerEnemigoPrincipal.sanarVida(boss.getVida(), boss));
					ImpresionMensajes.mensajeSanarJefe(ControllerEnemigoPrincipal.sanarVida(boss.getVida(), boss));
				} else {
					azir1.setVida(azir1.getVida() - ControllerEnemigoPrincipal.ataqueBasico(boss));
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
			if (azir1.getVida() > 0.0) {
				switch (opciones) {
				case 1:
					// Ataque básico
					boss.setVida(boss.getVida() - ControllerAzir.ataqueBasico(azir1));
					ImpresionMensajes.mensajeAtaquePersonaje(ControllerAzir.ataqueBasico(azir1));
					break;
				case 2:
					// Proteger
					if (ControllerAzir.restaurarVida(azir1)>azir1.getVidaMaxima() ) {
						azir1.setVida(azir1.getVidaMaxima());
						MensajesPrueba.mensajeProtegerPersonaje(ControllerAzir.proteger(boss));
					}else {
						azir1.setVida(ControllerAzir.restaurarVida(azir1));
						MensajesPrueba.mensajeProtegerPersonaje(ControllerAzir.proteger(boss));
					}
					if (ControllerAzir.restaurarRecursos(azir1)>azir1.getRecursosMax()) {
						azir1.setRecursos(azir1.getRecursosMax());
						ImpresionMensajes.restaurarRecursos();
					} else {
						azir1.setRecursos(ControllerAzir.restaurarRecursos(azir1));
						ImpresionMensajes.restaurarRecursos();
					}
					
					break;
				case 3:
					// Ataque de habilidad
					boss.setVida(boss.getVida() - ControllerAzir.ataqueHabilidad(azir1));

					azir1.setRecursos(ControllerAzir.gastoRecursos(azir1));
					ImpresionMensajes.mensajeAtaquePersonaje(ControllerAzir.ataqueHabilidad(azir1));
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

	public static void combateAzirEnemigoAleatorio(Azir azir1, EnemigoAleatorio esbirro, int opciones) {
		Random r1 = new Random(System.nanoTime());
		int aleatorioTurno = r1.nextInt(1 - 0 + 1) + 1;
		int opcionesBoss = r1.nextInt(1 - 0 + 1) + 1;

		switch (aleatorioTurno) {
		case 1:
			// Yo ataco primero
			switch (opciones) {
			case 1:
				// Ataque básico
				esbirro.setVida(esbirro.getVida() - ControllerAzir.ataqueBasico(azir1));
				ImpresionMensajes.mensajeAtaquePersonaje(ControllerAzir.ataqueBasico(azir1));
				break;
			case 2:
				// Proteger
				
				break;
			case 3:
				// Ataque de habilidad
				esbirro.setVida(esbirro.getVida() - ControllerAzir.ataqueHabilidad(azir1));

				azir1.setRecursos(azir1.getRecursos() - 100);
				ImpresionMensajes.mensajeAtaquePersonaje(ControllerAzir.ataqueHabilidad(azir1));
				ImpresionMensajes.gastoRecursosMana(ControllerAzir.gastoRecursos(azir1));
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
						azir1.setVida(azir1.getVida() - ControllerEnemigoAleatorio.ataqueBasico(esbirro));
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
					azir1.setVida(azir1.getVida() - ControllerEnemigoAleatorio.ataqueBasico(esbirro));
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
			if (azir1.getVida() > 0.0) {
				switch (opciones) {
				case 1:
					// Ataque básico
					esbirro.setVida(esbirro.getVida() - ControllerAzir.ataqueBasico(azir1));
					ImpresionMensajes.mensajeAtaquePersonaje(ControllerAzir.ataqueBasico(azir1));
					break;
				case 2:
					// Proteger

					break;
				case 3:
					// Ataque de habilidad
					esbirro.setVida(esbirro.getVida() - ControllerAzir.ataqueHabilidad(azir1));

					azir1.setRecursos(azir1.getRecursos() - ControllerAzir.gastoRecursos(azir1));
					ImpresionMensajes.mensajeAtaquePersonaje(ControllerAzir.ataqueHabilidad(azir1));
					ImpresionMensajes.gastoRecursosMana(ControllerAzir.gastoRecursos(azir1));
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
