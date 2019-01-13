package main;

import java.util.Random;

import controller.combate.ControllerCombateAatrox;
import controller.combate.ControllerCombateAzir;
import controller.loot.ControllerLoot;
import controller.personajes.ControllerAatrox;
import crud.personajes.CrudAzir;
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
import vista.MensajesPrueba;

public class Ppal {

	public static void main(String[] args) {

		int personaje, confirmar = 0, cero = 0, opciones, turno = 0, opcionMin = 1, opcionMax = 3,saltoPantalla = 0,combateEsbirro = 0,
				opcionAtaqueHabil = 3,opcionProteger = 2, malzahar = 3, ornn = 0, shyvana = 1, mordekaiser = 4, leeroy = 2; 
		Random random = new Random(System.nanoTime());
		DatosPersonajes dp = new DatosPersonajes();
		DatosLoot dl = new DatosLoot();
		DatosEnemigos de = new DatosEnemigos();
		LootPoderHabilidad lph = new LootPoderHabilidad();
		LootPoderHabilidad lph2 = new LootPoderHabilidad();
		LootAtaque lAtaque = new LootAtaque();
		LootAtaque lAtaque2 = new LootAtaque();
		LootDefensa lDefensa = new LootDefensa();
		Aatrox aatrox;
		Azir azir;
		EnemigoAleatorio esbirro;
		EnemigoAleatorio bossAlea;
		EnemigoPrincipal boss;

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
					turno = 0;
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
					if (aatrox.getVida() > 0.0 && esbirro.getVida() < 0.0) {
						ImpresionMensajes.victoriaVsEsbirro();
					} else {
						ImpresionMensajes.derrotaVsEsbirro();
					}

					ImpresionMensajes.saltarPantalla();
					aatrox.setVida(aatrox.getVidaMaxima());
				}

				do {
					saltoPantalla = Leer.datoInt();
				} while (saltoPantalla != 1);
				MensajesHistoriaAatrox.impresion1Pantalla6();
				ImpresionesTitulo.TituloShyvana();
				ImpresionesEnemigos.imprimirShyvana();
				MensajesHistoriaAatrox.impresion2Pantalla6();
				opciones = Leer.datoInt();
				turno = 0;
				do {

					boss = de.getListaEnemigosPpal()[1];
					ImpresionCombate1.imprimirAatroxyShyvana();
					turno++;
					ImpresionMensajes.ImprimirTurnos(turno);
					ImpresionMensajes.OpcionesCombateAatrox(aatrox, boss);
					opciones = Leer.datoInt();
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
					combateEsbirro = random.nextInt(1 - 0 + 1) + 1;
					if (combateEsbirro == 2) {
						esbirro = de.getListaEnemigosAleatorio()[2];
						MensajesHistoriaAatrox.impresion1Esbirro1();
						ImpresionesEnemigos.imprimirEsbirros();
						MensajesHistoriaAatrox.impresion2Esbirro1();
						opciones = Leer.datoInt();
						do {
							turno = 0;
							ImpresionCombate1.imprimirAatroxyEsbirro();
							turno++;
							ImpresionMensajes.ImprimirTurnos(turno);
							ImpresionMensajes.OpcionesCombateAatroxAleatorio(aatrox, esbirro);
							opciones = Leer.datoInt();
							while (opciones < opcionMin || opciones > opcionMax) {// No permitir elegir una opcion que
																					// no
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
						if (aatrox.getVida() > 0.0 && esbirro.getVida() < 0.0) {
							ImpresionMensajes.victoriaVsEsbirro();
						} else {
							ImpresionMensajes.derrotaVsEsbirro();
						}

						ImpresionMensajes.saltarPantalla();
						aatrox.setVida(aatrox.getVidaMaxima());
					}
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
					turno = 0;
					do {

						boss = de.getListaEnemigosPpal()[2];
						ImpresionCombate1.imprimirAatroxyMalhazar();
						turno++;
						ImpresionMensajes.ImprimirTurnos(turno);
						ImpresionMensajes.OpcionesCombateAatrox(aatrox, boss);
						opciones = Leer.datoInt();
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
						turno = 0;
						do {

							boss = de.getListaEnemigosPpal()[3];
							ImpresionCombate1.imprimirAatroxymordekaiser();
							turno++;
							ImpresionMensajes.ImprimirTurnos(turno);
							ImpresionMensajes.OpcionesCombateAatrox(aatrox, boss);
							opciones = Leer.datoInt();
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
							combateEsbirro = random.nextInt(1 - 0 + 1) + 1;
							if (combateEsbirro == 2) {
								esbirro = de.getListaEnemigosAleatorio()[3];
								MensajesHistoriaAatrox.impresion1Esbirro1();
								ImpresionesEnemigos.imprimirEsbirros();
								MensajesHistoriaAatrox.impresion2Esbirro1();
								opciones = Leer.datoInt();
								do {
									turno = 0;
									ImpresionCombate1.imprimirAatroxyEsbirro();
									turno++;
									ImpresionMensajes.ImprimirTurnos(turno);
									ImpresionMensajes.OpcionesCombateAatroxAleatorio(aatrox, esbirro);
									opciones = Leer.datoInt();
									while (opciones < opcionMin || opciones > opcionMax) {// No permitir elegir una
																							// opcion que no
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
								if (aatrox.getVida() > 0.0 && esbirro.getVida() < 0.0) {
									ImpresionMensajes.victoriaVsEsbirro();
								} else {
									ImpresionMensajes.derrotaVsEsbirro();
								}

								ImpresionMensajes.saltarPantalla();
								aatrox.setVida(aatrox.getVidaMaxima());
							}
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
							turno = 0;
							do {

								boss = de.getListaEnemigosPpal()[4];
								ImpresionCombate1.imprimirAatroxyLeeroy();
								turno++;
								ImpresionMensajes.ImprimirTurnos(turno);
								ImpresionMensajes.OpcionesCombateAatrox(aatrox, boss);
								opciones = Leer.datoInt();
								while (opciones < opcionMin || opciones > opcionMax) {// No permitir elegir una opcion que este entre 1 y 3
									ImpresionMensajes.ErrorOpciones();

									opciones = Leer.datoInt();
								}
								while (opciones == opcionAtaqueHabil
										&& aatrox.getVida() < ControllerAatrox.gastoRecursos(aatrox)) {
									ImpresionMensajes.ErrorRecursos();
									opciones = Leer.datoInt();
								}
								ControllerCombateAatrox.combateAatroxBoss(aatrox, boss, opciones);

							} while (aatrox.getVida() > 0.0 && boss.getVida() > 0.0);
							ImpresionesTitulo.TituloFinal();
							ImpresionesTitulo.Creditos();
						} else {
							ImpresionesTitulo.teHanMatado();
						}

					} else {
						ImpresionesTitulo.teHanMatado();
					}

				} else {
					ImpresionesTitulo.teHanMatado();
				}
			} else {
				ImpresionesTitulo.teHanMatado();
			}

			break;
			
		case 2:// Azir
			azir = dp.getAzir();
			boss = de.getListaEnemigosPpal()[ornn]; // Ornn
			// Historia
			MensajeHistoriaAzir.historiaAzir();
			ImpresionMapas.imprimirShurima();
			ImpresionMensajes.saltarPantalla();
			opciones = Leer.datoInt();
			
			MensajeHistoriaAzir.historiaAzir2v40();
			ImpresionesEscenarios.ImprimirCastillo2();
			MensajeHistoriaAzir.historiaAzir2v3();
			opciones = Leer.datoInt();

			ImpresionesTitulo.TituloOrnn();
			ImpresionesEnemigos.imprimirOrnn();
			MensajeHistoriaAzir.historiaAzir3();
			MensajeHistoriaAzir.comenzarPelea();
			opciones = Leer.datoInt();
			
			
			do { // Primer Combate
				ImpresionCombate1.imprimirAziryOrnn();
				turno++;
				ImpresionMensajes.ImprimirTurnos(turno);
				ImpresionMensajes.OpcionesCombateAzir(azir, boss);
				opciones = Leer.datoInt();
				while (opciones < opcionMin || opciones > opcionMax) {// No permitir elegir una opcion que no este entre
																		// 1 y 3
					ImpresionMensajes.ErrorOpciones();
					opciones = Leer.datoInt();
				}
				while (opciones == opcionAtaqueHabil && azir.getRecursos() <= 0) { // No permitir hacer ataque de
																					// habilidad si no tiene recursos
					ImpresionMensajes.ErrorRecursos();
					opciones = Leer.datoInt();
				}
				while (opciones == opcionProteger && azir.getVida()>= azir.getVidaMaxima()) {
					ImpresionMensajes.limiteVida();
					opciones = Leer.datoInt();
				}
				ControllerCombateAzir.combateAzirBoss(azir, boss, opciones);
				MensajesPrueba.MostrarResultadoAzir(azir, boss);
			} while (azir.getVida() > 0.0 && boss.getVida() > 0.0);
			if (azir.getVida() > 0.0 && boss.getVida() <= 0.0) {// Sigue el juego si gana el combate  
				CrudAzir.resetearVida(azir); // Pone vida al maximo 
				azir.setRecursos(azir.getRecursosMax()); // Pone recursos al maximo
				ImpresionMensajes.AceptarLoot();
				ImpresionLoot1.imprimirCofre();
				opciones = Leer.datoInt();

				lph = ControllerLoot.LootHabilidad(); //Asigno un loot de habilidad aleatorio
				ImpresionMensajes.ImprimirLootHabilidad(lph, dl);
				azir.setRecursosMax(azir.getRecursosMax()+lph.getRecursos());
				azir.setRecursos(azir.getRecursosMax());
				azir.setPoderHabilidad(azir.getPoderHabilidad() + lph.getPoderHabilidad());
				ImpresionMensajes.nuevasEstadisticasAzirLootHabilidad(azir);
				ImpresionMensajes.saltarPantalla();
				opciones = Leer.datoInt();
				
				//Sigue la historia para derrotar al segundo jefe
				MensajeHistoriaAzir.historiaAzir4();
				ImpresionesTitulo.Titulo1();
				ImpresionMapas.imprimirmapaGeneral();
				ImpresionMensajes.saltarPantalla();
				opciones = Leer.datoInt();
				//Evento aleatorio
				MensajeHistoriaAzir.historiaAzirEvenAleat();
				opciones = Leer.datoInt();
				if (opciones == 1) {
					bossAlea = de.getListaEnemigosAleatorio()[cero];
					turno = cero;
					do {
						ImpresionCombate1.imprimirAziryEsbirro();
						turno++;
						ImpresionMensajes.ImprimirTurnos(turno);
						ImpresionMensajes.OpcionesCombateAzirAleatorio(azir, bossAlea);
						opciones = Leer.datoInt();
						while (opciones < opcionMin || opciones > opcionMax) {// No permitir elegir una opcion que no este entre
																				// 1 y 3
							ImpresionMensajes.ErrorOpciones();
							opciones = Leer.datoInt();
						}
						while (opciones == opcionAtaqueHabil && azir.getRecursos() <= 0) { // No permitir hacer ataque de
																							// habilidad si no tiene recursos
							ImpresionMensajes.ErrorRecursos();
							opciones = Leer.datoInt();
						}
						ControllerCombateAzir.combateAzirEnemigoAleatorio(azir, bossAlea, opciones);
						MensajesPrueba.MostrarResultadoAzirVsAleatorio(azir, bossAlea);
						
					} while (azir.getVida() > 0.0 && bossAlea.getVida() > 0.0);
					if (azir.getVida() > 0.0 && boss.getVida() <= 0.0) { //Si gana contra el esbirro
						CrudAzir.resetearVida(azir);
						azir.setRecursos(azir.getRecursosMax());
						ImpresionMensajes.AceptarLoot();
						ImpresionLoot1.imprimirCofre();
						opciones = Leer.datoInt();
						
						lAtaque = ControllerLoot.lootAtaque();
						ImpresionMensajes.ImprimirLootAtaque(lAtaque, dl);
						azir.setAtaque(azir.getAtaque() + lAtaque.getAtaque());
						azir.setVidaMaxima(azir.getVidaMaxima() + lAtaque.getVida());
						azir.setVida(azir.getVidaMaxima());
						ImpresionMensajes.nuevasEstadisticasAzirLootAtaque(azir);
						ImpresionMensajes.saltarPantalla();
						opciones = Leer.datoInt();
						
					}else { // Si pierde contra el esbirro
						ImpresionMensajes.derrotaVsEsbirro();
						CrudAzir.resetearVida(azir);
						azir.setRecursos(azir.getRecursosMax());
						ImpresionMensajes.saltarPantalla();
						opciones = Leer.datoInt();
					}
				} else {// Si elige dejar vivo al esbirro

				}
				MensajeHistoriaAzir.historiaAzir5();
				ImpresionesEscenarios.ImprimirBarco();
				MensajeHistoriaAzir.historiaAzir6();
				ImpresionesTitulo.TituloShyvana();
				ImpresionesEnemigos.imprimirShyvana();
				ImpresionMensajes.saltarPantalla();
				opciones = Leer.datoInt();
				
				MensajeHistoriaAzir.historiaAzir7(lph);
				opciones = Leer.datoInt(); //Elegir entre pelear o dar tu loot y perder
				
				if (opciones == 1) {
					boss = de.getListaEnemigosPpal()[shyvana]; //Shyvana
					turno = 0;
					MensajeHistoriaAzir.historiaAzir8();
					do { //Segundo Combate
						ImpresionCombate1.imprimirAziryShyvana();
						turno++;
						ImpresionMensajes.ImprimirTurnos(turno);
						ImpresionMensajes.OpcionesCombateAzir(azir, boss);
						opciones = Leer.datoInt();
						while (opciones < opcionMin || opciones > opcionMax) {// No permitir elegir una opcion que no este entre
																				// 1 y 3
							ImpresionMensajes.ErrorOpciones();
							opciones = Leer.datoInt();
						}
						while (opciones == opcionAtaqueHabil && azir.getRecursos() <= 0) { // No permitir hacer ataque de
																							// habilidad si no tiene recursos
							ImpresionMensajes.ErrorRecursos();
							opciones = Leer.datoInt();
						}
						while (opciones == opcionProteger && azir.getVida()>= azir.getVidaMaxima()) {
							ImpresionMensajes.limiteVida();
							opciones = Leer.datoInt();
						}
						ControllerCombateAzir.combateAzirBoss(azir, boss, opciones);
						MensajesPrueba.MostrarResultadoAzir(azir, boss);
						
					} while (azir.getVida() > 0.0 && boss.getVida() > 0.0);
					if (azir.getVida() > 0.0 && boss.getVida() <= 0.0) {// Sigue el juego si gana el segundo combate
						CrudAzir.resetearVida(azir);
						azir.setRecursos(azir.getRecursosMax());
						ImpresionMensajes.AceptarLoot();
						ImpresionLoot1.imprimirCofre();
						opciones = Leer.datoInt();
						
						lAtaque2 = ControllerLoot.lootAtaque();
						while (lAtaque2.getNombre().equals(lAtaque.getNombre())) { //Bucle para que no se repita el mismo looteo que te dio antes
							lAtaque2 = ControllerLoot.lootAtaque();
						}
						ImpresionMensajes.ImprimirLootAtaque(lAtaque2, dl);
						azir.setAtaque(azir.getAtaque() + lAtaque2.getAtaque());
						azir.setVidaMaxima(azir.getVidaMaxima() + lAtaque2.getVida());
						azir.setVida(azir.getVidaMaxima());
						ImpresionMensajes.nuevasEstadisticasAzirLootAtaque(azir);
						ImpresionMensajes.saltarPantalla();
						opciones = Leer.datoInt();
						
						//Sigue la historia para derrotar al tercer jefe
						MensajeHistoriaAzir.historiaAzir9();
						ImpresionesEscenarios.ImprimirBosque();
						ImpresionMensajes.saltarPantalla();
						opciones = Leer.datoInt();
						
						MensajeHistoriaAzir.historiaAzir10();
						ImpresionesEscenarios.ImprimirPiramide();
						ImpresionMensajes.saltarPantalla();
						opciones = Leer.datoInt();
						
						MensajeHistoriaAzir.historiaAzir11();
						ImpresionesTitulo.Titulo1Malzahar();
						ImpresionesEnemigos.imprimirMalzahar();
						MensajeHistoriaAzir.comenzarPelea();
						opciones = Leer.datoInt();
						
						boss = de.getListaEnemigosPpal()[malzahar];//Malzahar
						turno = 0;
						do { //Tercer Combate
							ImpresionCombate1.imprimirAziryMalhazar();
							turno++;
							ImpresionMensajes.ImprimirTurnos(turno);
							ImpresionMensajes.OpcionesCombateAzir(azir, boss);
							opciones = Leer.datoInt();
							while (opciones < opcionMin || opciones > opcionMax) {// No permitir elegir una opcion que no este entre
																					// 1 y 3
								ImpresionMensajes.ErrorOpciones();
								opciones = Leer.datoInt();
							}
							while (opciones == opcionAtaqueHabil && azir.getRecursos() <= 0) { // No permitir hacer ataque de
																								// habilidad si no tiene recursos
								ImpresionMensajes.ErrorRecursos();
								opciones = Leer.datoInt();
							}
							while (opciones == opcionProteger && azir.getVida()>= azir.getVidaMaxima()) {
								ImpresionMensajes.limiteVida();
								opciones = Leer.datoInt();
							}
							ControllerCombateAzir.combateAzirBoss(azir, boss, opciones);
							MensajesPrueba.MostrarResultadoAzir(azir, boss);
							
						} while (azir.getVida() > 0.0 && boss.getVida() > 0.0);
						if (azir.getVida() > 0.0 && boss.getVida() <= 0.0) {// Sigue el juego si gana el tercer combate
							CrudAzir.resetearVida(azir); // Pone vida al maximo 
							azir.setRecursos(azir.getRecursosMax()); // Pone recursos al maximo
							ImpresionMensajes.AceptarLoot();
							ImpresionLoot1.imprimirCofre();
							opciones = Leer.datoInt();

							lDefensa = ControllerLoot.asignarLootDefensa(); //Asigno un loot de habilidad aleatorio
							ImpresionMensajes.imprimirLootDefensa(lDefensa, dl);
							azir.setDefensa(azir.getDefensa()+lDefensa.getDefensa());
							azir.setVidaMaxima(azir.getVidaMaxima() + lDefensa.getVida());
							azir.setVida(azir.getVidaMaxima());
							ImpresionMensajes.nuevasEstadisticasAzirLootDefensa(azir);
							ImpresionMensajes.saltarPantalla();
							opciones = Leer.datoInt();
							
							//Sigue historia para derrotar al cuarto jefe
							MensajeHistoriaAzir.historiaAzir12();
							ImpresionesTitulo.tituloMordekaiser();
							ImpresionesEnemigos.imprimirMordekaiser();
							MensajeHistoriaAzir.matarMordekaiser();
							opciones = Leer.datoInt();
							
							boss = de.getListaEnemigosPpal()[mordekaiser]; //Mordekaiser
							turno = 0;
							do { //Cuarto Combate
								ImpresionCombate1.imprimirAziryMordekaiser();
								turno++;
								ImpresionMensajes.ImprimirTurnos(turno);
								ImpresionMensajes.OpcionesCombateAzir(azir, boss);
								opciones = Leer.datoInt();
								while (opciones < opcionMin || opciones > opcionMax) {// No permitir elegir una opcion que no este entre
																						// 1 y 3
									ImpresionMensajes.ErrorOpciones();
									opciones = Leer.datoInt();
								}
								while (opciones == opcionAtaqueHabil && azir.getRecursos() <= 0) { // No permitir hacer ataque de
																									// habilidad si no tiene recursos
									ImpresionMensajes.ErrorRecursos();
									opciones = Leer.datoInt();
								}
								while (opciones == opcionProteger && azir.getVida()>= azir.getVidaMaxima()) {
									ImpresionMensajes.limiteVida();
									opciones = Leer.datoInt();
								}
								ControllerCombateAzir.combateAzirBoss(azir, boss, opciones);
								MensajesPrueba.MostrarResultadoAzir(azir, boss);
								
							} while (azir.getVida() > 0.0 && boss.getVida() > 0.0);
							if (azir.getVida() > 0.0 && boss.getVida() <= 0.0) {// Sigue el juego si gana el cuarto combate
								CrudAzir.resetearVida(azir);
								azir.setRecursos(azir.getRecursosMax());
								ImpresionMensajes.AceptarLoot();
								ImpresionLoot1.imprimirCofre();
								opciones = Leer.datoInt();
								
								lph2 = ControllerLoot.LootHabilidad(); //Asigno un loot de habilidad aleatorio
								while (lph2.getNombre().equals(lph.getNombre())) { //Bucle para que no se repita el mismo looteo que te dio antes
									lph2 = ControllerLoot.LootHabilidad();
								}
								ImpresionMensajes.ImprimirLootHabilidad(lph2, dl);
								azir.setRecursosMax(azir.getRecursosMax()+lph2.getRecursos());
								azir.setRecursos(azir.getRecursosMax());
								azir.setPoderHabilidad(azir.getPoderHabilidad() + lph2.getPoderHabilidad());
								ImpresionMensajes.nuevasEstadisticasAzirLootHabilidad(azir);
								ImpresionMensajes.saltarPantalla();
								opciones = Leer.datoInt();
								
								//Sigue la historia para derrotar al quinto y último jefe
								MensajeHistoriaAzir.historiaAzir13();
								ImpresionesTitulo.Titulo4();
								ImpresionMapas.imprimirIonia();
								ImpresionMensajes.saltarPantalla();
								opciones = Leer.datoInt();
								
								MensajeHistoriaAzir.historiaAzir14();
								ImpresionesEscenarios.ImprimirBarco();
								MensajeHistoriaAzir.historiaAzir15();
								ImpresionesEscenarios.ImprimirCastillo();
								ImpresionMensajes.saltarPantalla();
								opciones = Leer.datoInt();
								
								MensajeHistoriaAzir.historiaAzir16();
								ImpresionesTitulo.TituloLeeroy();
								ImpresionesEnemigos.imprimirLeeroyJenkins();
								MensajeHistoriaAzir.historiaAzir17();
								opciones = Leer.datoInt();
								
								boss = de.getListaEnemigosPpal()[leeroy]; //Leeroy
								turno = 0;
								do { //Quinto Combate
									ImpresionCombate1.imprimirAziryLeeroy();
									turno++;
									ImpresionMensajes.ImprimirTurnos(turno);
									ImpresionMensajes.OpcionesCombateAzir(azir, boss);
									opciones = Leer.datoInt();
									while (opciones < opcionMin || opciones > opcionMax) {// No permitir elegir una opcion que no este entre
																							// 1 y 3
										ImpresionMensajes.ErrorOpciones();
										opciones = Leer.datoInt();
									}
									while (opciones == opcionAtaqueHabil && azir.getRecursos() <= 0) { // No permitir hacer ataque de
																										// habilidad si no tiene recursos
										ImpresionMensajes.ErrorRecursos();
										opciones = Leer.datoInt();
									}
									while (opciones == opcionProteger && azir.getVida()>= azir.getVidaMaxima()) {
										ImpresionMensajes.limiteVida();
										opciones = Leer.datoInt();
									}
									ControllerCombateAzir.combateAzirBoss(azir, boss, opciones);
									MensajesPrueba.MostrarResultadoAzir(azir, boss);
									
								} while (azir.getVida() > 0.0 && boss.getVida() > 0.0);
								if (azir.getVida() > 0.0 && boss.getVida() <= 0.0) {
									MensajeHistoriaAzir.historiaAzir18();
									ImpresionesTitulo.TituloFinal();
									MensajeHistoriaAzir.historiaAzir19();
									opciones = Leer.datoInt();
									
									if (opciones == 1) {
										ImpresionesTitulo.Creditos();
									}
									else {
										
									}
								}
								else {//Has perdido el quinto combate
									ImpresionesTitulo.teHanMatado();
								}
							}
							else {//Has perdido el cuarto combate
								ImpresionesTitulo.teHanMatado();
							}
							
						}
						else {//Has perdido el tercer combate
							ImpresionesTitulo.teHanMatado();
						}
						
					}
					else {//Has perdido el segundo combate
						ImpresionesTitulo.teHanMatado();
					}
					
				}else {// Shyvana te ha traicionado
					ImpresionMensajes.traicionShyvana();
					ImpresionesTitulo.teHanMatado();
				}
				
			}
			else {//Has perdido en el primer combate
				ImpresionesTitulo.teHanMatado();
			}

		default:
			break;
		}

	}

}

