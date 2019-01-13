
import java.util.Random;

import controller.combate.ControllerCombateAatrox;
import controller.loot.ControllerLoot;
import controller.personajes.ControllerAatrox;
import datos.DatosEnemigos;
import datos.DatosLoot;
import datos.DatosPersonajes;
import model.enemigos.EnemigoAleatorio;
import model.enemigos.EnemigoPrincipal;
import model.loot.LootAtaque;
import model.loot.LootDefensa;
import model.loot.LootPoderHabilidad;
import model.personajes.Aatrox;
import model.personajes.Azir;
import utilidades.Leer;
import vista.ImpresionCombate1;
import vista.ImpresionLoot1;
import vista.ImpresionMapas;
import vista.ImpresionMensajes;
import vista.ImpresionMenu;
import vista.ImpresionesEnemigos;
import vista.ImpresionesEscenarios;
import vista.ImpresionesPersonajes;
import vista.ImpresionesTitulo;
import vista.MensajeHistoriaAzir;
import vista.MensajesHistoriaAatrox;

public class MainMiguel {

	public static void main(String[] args) {
		int personaje, confirmar = 0, cero = 0, opciones = 0, turno = 0, opcionMin = 1, opcionMax = 3,
				saltoPantalla = 0, opcionAtaqueHabil = 3, combateEsbirro = 0;
		Random random = new Random(System.nanoTime());
		DatosPersonajes dp = new DatosPersonajes();
		DatosLoot dl = new DatosLoot();
		DatosEnemigos de = new DatosEnemigos();
		LootPoderHabilidad lph = new LootPoderHabilidad();
		LootAtaque lAtaque = new LootAtaque();
		LootDefensa lDefensa = new LootDefensa();
		Aatrox aatrox;
		Azir azir;
		EnemigoPrincipal boss;
		EnemigoAleatorio esbirro;

		ImpresionMenu.imprimirTitulo();

		// Un bucle para que el usuario primero pueda visualizar cada uno de los
		// personajes y luego confirmar su elección
		do {
			ImpresionMensajes.elegirPersonajes();
			personaje = Leer.datoInt();
			switch (personaje) {
			case 1:// Aatrox
				ImpresionesTitulo.TituloAatrox();
				ImpresionesPersonajes.imprimirAatrox();
				ImpresionMensajes.confirmarPersonaje();
				confirmar = Leer.datoInt();

				break;
			case 2:// Azir
				ImpresionesTitulo.TituloAzir();
				ImpresionesPersonajes.imprimirAzir();
				MensajeHistoriaAzir.descripcionAzir();
				ImpresionMensajes.confirmarPersonaje();
				confirmar = Leer.datoInt();
				break;
			case 3:// Kled
				ImpresionesTitulo.TituloKled();
				ImpresionesPersonajes.imprimirKled();
				ImpresionMensajes.DescripcionKled();
				ImpresionMensajes.confirmarPersonaje();
				confirmar = Leer.datoInt();
				break;
			case 4:// Neeko
				ImpresionesTitulo.TituloNeeko();
				ImpresionesPersonajes.imprimirNeeko();
				ImpresionMensajes.confirmarPersonaje();
				confirmar = Leer.datoInt();
				break;

			default:
				personaje = cero;
				break;
			}
		} while (confirmar == cero);

		switch (personaje) {
		case 1:
			aatrox = dp.getAatrox();
			boss = de.getListaEnemigosPpal()[0];
			MensajesHistoriaAatrox.impresionPantalla1();
			ImpresionesTitulo.Titulo1();
			ImpresionMapas.imprimirmapaGeneral();
			ImpresionMensajes.saltarPantalla();
			do {
				saltoPantalla = Leer.datoInt();
			} while (saltoPantalla != 1);
			MensajesHistoriaAatrox.impresion1Pantalla2();
			ImpresionesTitulo.TituloAatrox();
			ImpresionesPersonajes.imprimirAatrox();
			MensajesHistoriaAatrox.impresion2Pantalla2();
			ImpresionMensajes.saltarPantalla();
			do {
				saltoPantalla = Leer.datoInt();
			} while (saltoPantalla != 1);
			MensajesHistoriaAatrox.impresion1Pantalla3();
			ImpresionesTitulo.Titulo3();
			ImpresionMapas.imprimirShurima();
			ImpresionesEscenarios.ImprimirPiramide();
			MensajesHistoriaAatrox.impresion2Pantalla3();
			ImpresionMensajes.saltarPantalla();
			do {
				saltoPantalla = Leer.datoInt();
			} while (saltoPantalla != 1);
			MensajesHistoriaAatrox.impresion1Pantalla4();
			ImpresionesTitulo.TituloOrnn();
			ImpresionesEnemigos.imprimirOrnn();
			MensajesHistoriaAatrox.impresion2Pantalla4();
			opciones = Leer.datoInt();
			do {
				ImpresionCombate1.imprimirAatroxyOrnn();
				turno++;
				ImpresionMensajes.ImprimirTurnos(turno);
				ImpresionMensajes.OpcionesCombateAatrox(aatrox, boss);
				opciones = Leer.datoInt();
				while (opciones < opcionMin || opciones > opcionMax) {// No permitir elegir una opcion que no este entre
					// 1 y 3

					ImpresionMensajes.ErrorOpciones();

					opciones = Leer.datoInt();
				}
				while (opciones == opcionAtaqueHabil && aatrox.getVida() < ControllerAatrox.gastoRecursos(aatrox)) {
					ImpresionMensajes.ErrorRecursos();
					opciones = Leer.datoInt();
				}
				ControllerCombateAatrox.combateAatroxBoss(aatrox, boss, opciones);
				ImpresionMensajes.MostrarResultadoAatrox(aatrox, boss);

			} while (aatrox.getVida() > 0.0 && boss.getVida() > 0.0);
			if (aatrox.getVida() > 0.0 && boss.getVida() <= 0.0) {
				ImpresionLoot1.imprimirCofre();
				ImpresionMensajes.AceptarLoot();
				opciones = Leer.datoInt();
				lDefensa = ControllerLoot.asignarLootDefensa(); // Asigno un loot de habilidad aleatorio
				ImpresionMensajes.imprimirLootDefensa(lDefensa, dl);
				aatrox.setDefensa(aatrox.getDefensa() + lDefensa.getDefensa());
				aatrox.setVidaMaxima(aatrox.getVidaMaxima() + lDefensa.getVida());
				aatrox.setVida(aatrox.getVidaMaxima());
				ImpresionMensajes.saltarPantalla();
				do {
					saltoPantalla = Leer.datoInt();
				} while (saltoPantalla != 1);
				MensajesHistoriaAatrox.impresion1Pantalla5();
				ImpresionesTitulo.TituloShyvana();
				ImpresionesEnemigos.imprimirShyvana();
				MensajesHistoriaAatrox.impresion2Pantalla5();
				ImpresionesEscenarios.ImprimirBosque();
				ImpresionMensajes.saltarPantalla();
				do {
					saltoPantalla = Leer.datoInt();

				} while (saltoPantalla != 1);
				combateEsbirro = random.nextInt(1 - 0 + 1) + 1;
				if (combateEsbirro == 2) {
					esbirro = de.getListaEnemigosAleatorio()[1];
					MensajesHistoriaAatrox.impresion1Esbirro1();
					ImpresionesEnemigos.imprimirEsbirros();
					MensajesHistoriaAatrox.impresion2Esbirro1();
					opciones = Leer.datoInt();
					do {
						ImpresionCombate1.imprimirAatroxyEsbirro();
						turno++;
						ImpresionMensajes.ImprimirTurnos(turno);
						ImpresionMensajes.OpcionesCombateAatroxAleatorio(aatrox, esbirro);
						opciones = Leer.datoInt();
						while (opciones < opcionMin || opciones > opcionMax) {// No permitir elegir una opcion que no
																				// este entre
							// 1 y 3

							ImpresionMensajes.ErrorOpciones();

							opciones = Leer.datoInt();
						}
						while (opciones == opcionAtaqueHabil
								&& aatrox.getVida() < ControllerAatrox.gastoRecursos(aatrox)) {
							ImpresionMensajes.ErrorRecursos();
							opciones = Leer.datoInt();
						}
						ControllerCombateAatrox.combateAatroxEnemigoAleatorio(aatrox, esbirro, opciones);

					} while (aatrox.getVida() > 0.0 && esbirro.getVida() > 0.0);
				}
				ImpresionMensajes.saltarPantalla();
				do {
					saltoPantalla = Leer.datoInt();
				} while (saltoPantalla != 1);
				MensajesHistoriaAatrox.impresion1Pantalla6();
				ImpresionesTitulo.TituloShyvana();
				ImpresionesEnemigos.imprimirShyvana();
				MensajesHistoriaAatrox.impresion2Pantalla6();
				opciones = Leer.datoInt();
				do {
					boss = de.getListaEnemigosPpal()[1];
					ImpresionCombate1.imprimirAatroxyShyvana();
					turno++;
					ImpresionMensajes.ImprimirTurnos(turno);
					ImpresionMensajes.OpcionesCombateAatrox(aatrox, boss);

					while (opciones < opcionMin || opciones > opcionMax) {// No permitir elegir una opcion que no este
																			// entre
						// 1 y 3

						ImpresionMensajes.ErrorOpciones();

						opciones = Leer.datoInt();
					}
					while (opciones == opcionAtaqueHabil && aatrox.getVida() < ControllerAatrox.gastoRecursos(aatrox)) {
						ImpresionMensajes.ErrorRecursos();
						opciones = Leer.datoInt();
					}
					ControllerCombateAatrox.combateAatroxBoss(aatrox, boss, opciones);
					ImpresionMensajes.MostrarResultadoAatrox(aatrox, boss);

				} while (aatrox.getVida() > 0.0 && boss.getVida() > 0.0);
				if (aatrox.getVida() > 0.0 && boss.getVida() <= 0.0) {
					ImpresionLoot1.imprimirCofre();
					ImpresionMensajes.AceptarLoot();
					opciones = Leer.datoInt();
					lAtaque = ControllerLoot.lootAtaque();
					ImpresionMensajes.ImprimirLootAtaque(lAtaque, dl);
					aatrox.setAtaque(aatrox.getAtaque() + lAtaque.getAtaque());
					aatrox.setVidaMaxima(aatrox.getVidaMaxima() + lAtaque.getVida());
					aatrox.setVida(aatrox.getVidaMaxima());
					ImpresionMensajes.saltarPantalla();
					do {
						saltoPantalla = Leer.datoInt();

					} while (saltoPantalla != 1);
					MensajesHistoriaAatrox.impresion1Pantalla7();
					ImpresionMapas.imprimirmapaValoran();
					ImpresionMapas.imprimirIonia();
					ImpresionMensajes.saltarPantalla();
					do {
						saltoPantalla = Leer.datoInt();
					} while (saltoPantalla != 1);
					MensajesHistoriaAatrox.impresion1Pantalla8();
					ImpresionesTitulo.Titulo2();
					ImpresionMapas.imprimirmapaValoran();
					ImpresionesEscenarios.ImprimirBarco();
					ImpresionMensajes.saltarPantalla();
					do {
						saltoPantalla = Leer.datoInt();
					} while (saltoPantalla != 1);
					MensajesHistoriaAatrox.impresion1Pantalla9();
					ImpresionesEscenarios.ImprimirBosque();
					MensajesHistoriaAatrox.impresion2Pantalla9();
					ImpresionMensajes.saltarPantalla();
					do {
						saltoPantalla = Leer.datoInt();
					} while (saltoPantalla != 1);
					MensajesHistoriaAatrox.impresion2Pantalla10();
					ImpresionesEscenarios.ImprimirCastillo();
					MensajesHistoriaAatrox.impresion2Pantalla10();
					ImpresionMensajes.saltarPantalla();
					do {
						saltoPantalla = Leer.datoInt();
					} while (saltoPantalla != 1);
					MensajesHistoriaAatrox.impresion1Pantalla11();
					ImpresionesTitulo.Titulo1Malzahar();
					ImpresionesEnemigos.imprimirMalzahar();
					MensajesHistoriaAatrox.impresion2Pantalla11();
					opciones = Leer.datoInt();
					do {
						boss = de.getListaEnemigosPpal()[2];
						ImpresionCombate1.imprimirAatroxyMalhazar();
						turno++;
						ImpresionMensajes.ImprimirTurnos(turno);
						ImpresionMensajes.OpcionesCombateAatrox(aatrox, boss);

						while (opciones < opcionMin || opciones > opcionMax) {// No permitir elegir una opcion que no
																				// este
																				// entre
							// 1 y 3

							ImpresionMensajes.ErrorOpciones();

							opciones = Leer.datoInt();
						}
						while (opciones == opcionAtaqueHabil
								&& aatrox.getVida() < ControllerAatrox.gastoRecursos(aatrox)) {
							ImpresionMensajes.ErrorRecursos();
							opciones = Leer.datoInt();
						}
						ControllerCombateAatrox.combateAatroxBoss(aatrox, boss, opciones);
						ImpresionMensajes.MostrarResultadoAatrox(aatrox, boss);

					} while (aatrox.getVida() > 0.0 && boss.getVida() > 0.0);
					if (aatrox.getVida() > 0.0 && boss.getVida() <= 0.0) {
						ImpresionLoot1.imprimirCofre();
						ImpresionMensajes.AceptarLoot();
						opciones = Leer.datoInt();
						lDefensa = ControllerLoot.asignarLootDefensa(); // Asigno un loot de habilidad aleatorio
						ImpresionMensajes.imprimirLootDefensa(lDefensa, dl);
						aatrox.setDefensa(aatrox.getDefensa() + lDefensa.getDefensa());
						aatrox.setVidaMaxima(aatrox.getVidaMaxima() + lDefensa.getVida());
						aatrox.setVida(aatrox.getVidaMaxima());
						ImpresionMensajes.saltarPantalla();
						do {
							saltoPantalla = Leer.datoInt();

						} while (saltoPantalla != 1);
						MensajesHistoriaAatrox.impresion1Pantalla12();
						ImpresionesEscenarios.ImprimirBosque();
						MensajesHistoriaAatrox.impresion2Pantalla11();
						ImpresionMensajes.saltarPantalla();
						do {
							saltoPantalla = Leer.datoInt();
						} while (saltoPantalla != 1);
						MensajesHistoriaAatrox.impresion1Pantalla13();
						ImpresionesEscenarios.ImprimirCastillo2();
						MensajesHistoriaAatrox.impresion2Pantalla13();
						ImpresionMensajes.saltarPantalla();
						do {
							saltoPantalla = Leer.datoInt();
						} while (saltoPantalla != 1);
						MensajesHistoriaAatrox.impresion1Pantalla14();
						ImpresionesTitulo.tituloMordekaiser();
						ImpresionesEnemigos.imprimirMordekaiser();
						MensajesHistoriaAatrox.impresion2Pantalla14();
						opciones = Leer.datoInt();
						do {
							boss = de.getListaEnemigosPpal()[3];
							ImpresionCombate1.imprimirAatroxymordekaiser();
							turno++;
							ImpresionMensajes.ImprimirTurnos(turno);
							ImpresionMensajes.OpcionesCombateAatrox(aatrox, boss);

							while (opciones < opcionMin || opciones > opcionMax) {// No permitir elegir una opcion que
																					// no
																					// este
																					// entre
								// 1 y 3

								ImpresionMensajes.ErrorOpciones();

								opciones = Leer.datoInt();
							}
							while (opciones == opcionAtaqueHabil
									&& aatrox.getVida() < ControllerAatrox.gastoRecursos(aatrox)) {
								ImpresionMensajes.ErrorRecursos();
								opciones = Leer.datoInt();
							}
							ControllerCombateAatrox.combateAatroxBoss(aatrox, boss, opciones);
							ImpresionMensajes.MostrarResultadoAatrox(aatrox, boss);

						} while (aatrox.getVida() > 0.0 && boss.getVida() > 0.0);
						if (aatrox.getVida() > 0.0 && boss.getVida() <= 0.0) {
							ImpresionLoot1.imprimirCofre();
							ImpresionMensajes.AceptarLoot();
							opciones = Leer.datoInt();
							lAtaque = ControllerLoot.lootAtaque();
							ImpresionMensajes.ImprimirLootAtaque(lAtaque, dl);
							aatrox.setAtaque(aatrox.getAtaque() + lAtaque.getAtaque());
							aatrox.setVidaMaxima(aatrox.getVidaMaxima() + lAtaque.getVida());
							aatrox.setVida(aatrox.getVidaMaxima());
							ImpresionMensajes.saltarPantalla();
							do {
								saltoPantalla = Leer.datoInt();

							} while (saltoPantalla != 1);
							MensajesHistoriaAatrox.impresion1Pantalla15();
							ImpresionesEscenarios.ImprimirBarco();
							MensajesHistoriaAatrox.impresion2Pantalla15();
							ImpresionMensajes.saltarPantalla();
							do {
								saltoPantalla = Leer.datoInt();
							} while (saltoPantalla != 1);
							MensajesHistoriaAatrox.impresion1Pantalla16();
							ImpresionesTitulo.Titulo4();
							ImpresionMapas.imprimirIonia();
							MensajesHistoriaAatrox.impresion2Pantalla16();
							ImpresionMensajes.saltarPantalla();
							do {
								saltoPantalla = Leer.datoInt();
							} while (saltoPantalla != 1);
							MensajesHistoriaAatrox.impresion1Pantalla17();
							ImpresionesEscenarios.ImprimirBosque();
							MensajesHistoriaAatrox.impresion2Pantalla17();
							ImpresionMensajes.saltarPantalla();
							do {
								saltoPantalla = Leer.datoInt();
							} while (saltoPantalla != 1);
							MensajesHistoriaAatrox.impresion1Pantalla18();
							ImpresionesTitulo.TituloLeeroy();
							ImpresionesEnemigos.imprimirLeeroyJenkins();
							MensajesHistoriaAatrox.impresion2Pantalla18();
							opciones = Leer.datoInt();
							do {
								boss = de.getListaEnemigosPpal()[4];
								ImpresionCombate1.imprimirAatroxyLeeroy();
								turno++;
								ImpresionMensajes.ImprimirTurnos(turno);
								ImpresionMensajes.OpcionesCombateAatrox(aatrox, boss);

								while (opciones < opcionMin || opciones > opcionMax) {// No permitir elegir una opcion
																						// que
																						// no
																						// este
																						// entre
									// 1 y 3

									ImpresionMensajes.ErrorOpciones();

									opciones = Leer.datoInt();
								}
								while (opciones == opcionAtaqueHabil
										&& aatrox.getVida() < ControllerAatrox.gastoRecursos(aatrox)) {
									ImpresionMensajes.ErrorRecursos();
									opciones = Leer.datoInt();
								}
								ControllerCombateAatrox.combateAatroxBoss(aatrox, boss, opciones);
								ImpresionesTitulo.TituloFinal();
								ImpresionesTitulo.Creditos();

							} while (aatrox.getVida() > 0.0 && boss.getVida() > 0.0);

						} else {
							System.out.println("Game over, no vales ni para estar sentado.");
						}

					} else {
						System.out.println("Game over, no vales ni para estar sentado.");
					}

				} else {
					System.out.println("Game over, no vales ni para estar sentado.");
				}
			} else {
				System.out.println("Game over, no vales ni para estar sentado.");
			}

			break;

		default:
			break;
		}
	}
}
