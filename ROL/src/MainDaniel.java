import controller.combate.ControllerCombateAatrox;
import controller.combate.ControllerCombateAzir;
import controller.loot.ControllerLoot;
import crud.personajes.CrudAzir;
import datos.DatosEnemigos;
import datos.DatosLoot;
import datos.DatosPersonajes;
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
import vista.MensajesPrueba;

public class MainDaniel {

	public static void main(String[] args) {

		int personaje, confirmar = 0, cero = 0, opciones, turno = 0, opcionMin = 1, opcionMax = 3,
				opcionAtaqueHabil = 3, malzahar = 3, ornn = 0, shyvana = 1; 
		DatosPersonajes dp = new DatosPersonajes();
		DatosLoot dl = new DatosLoot();
		DatosEnemigos de = new DatosEnemigos();
		LootPoderHabilidad lph = new LootPoderHabilidad();
		LootAtaque lAtaque = new LootAtaque();
		LootDefensa lDefensa = new LootDefensa();
		Aatrox aatrox;
		Azir azir;
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
			boss = de.getListaEnemigosPpal()[0]; // Este me devuelve shyvana pero es de prueba
			ImpresionMensajes.HistoriaAatrox();
			confirmar = Leer.datoInt();
			if (confirmar != cero) {
				ImpresionCombate1.imprimirAatroxyEsbirro(); // De prueba
				do {
					turno++;
					ImpresionMensajes.ImprimirTurnos(turno);
					ImpresionMensajes.OpcionesCombateAatrox(aatrox, boss);
					opciones = Leer.datoInt();
					ControllerCombateAatrox.combateAatroxBoss(aatrox, boss, opciones);
					System.out.println("Vida Aatrox: " + aatrox.getVida());
					System.out.println("Vida Boss: " + boss.getVida());
				} while (aatrox.getVida() > 0.0 && boss.getVida() > 0.0);
			} else {

			}
			break;
		case 2:// Azir
			azir = dp.getAzir();
			boss = de.getListaEnemigosPpal()[ornn]; // Ornn
			// Historia
			MensajeHistoriaAzir.historiaAzir();
			ImpresionMapas.imprimirShurima();
			MensajeHistoriaAzir.historiaAzir2();
			ImpresionesEscenarios.ImprimirCastillo2();
			MensajeHistoriaAzir.historiaAzir2v2();
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
				
				MensajeHistoriaAzir.historiaAzir4();
				ImpresionesTitulo.Titulo1();
				ImpresionMapas.imprimirmapaGeneral();
				ImpresionMensajes.saltarPantalla();
				opciones = Leer.datoInt();
				
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
						ControllerCombateAzir.combateAzirBoss(azir, boss, opciones);
						MensajesPrueba.MostrarResultadoAzir(azir, boss);
						
					} while (azir.getVida() > 0.0 && boss.getVida() > 0.0);
					if (azir.getVida() > 0.0 && boss.getVida() <= 0.0) {// Sigue el juego si gana el segundo combate
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
						}
						else {//Has perdido el tercer combate
							ImpresionesTitulo.GameOver();
						}
						
					}
					else {//Has perdido el segundo combate
						ImpresionesTitulo.GameOver();
					}
					
				}else {// Shyvana te ha traicionado
					ImpresionMensajes.traicionShyvana();
					ImpresionesTitulo.GameOver();
				}
				
			}
			else {
				ImpresionesTitulo.GameOver();//Has perdido en el primer combate
			}

		default:
			break;
		}

	}

}
