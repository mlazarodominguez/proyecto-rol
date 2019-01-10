
import controller.combate.ControllerCombateAatrox;
import controller.loot.ControllerLoot;
import controller.personajes.ControllerAatrox;
import datos.DatosEnemigos;
import datos.DatosLoot;
import datos.DatosPersonajes;
import model.enemigos.EnemigoPrincipal;
import model.loot.LootAtaque;
import model.loot.LootPoderHabilidad;
import model.personajes.Aatrox;
import model.personajes.Azir;
import utilidades.Leer;
import vista.ImpresionCombate1;
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
				saltoPantalla = 0, opcionAtaqueHabil = 3;
		DatosPersonajes dp = new DatosPersonajes();
		DatosLoot dl = new DatosLoot();
		DatosEnemigos de = new DatosEnemigos();
		LootPoderHabilidad lph = new LootPoderHabilidad();
		LootAtaque lAtaque = new LootAtaque();
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
			boss = de.getListaEnemigosPpal()[0];
			MensajesHistoriaAatrox.impresionPantalla1();
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
				while(opciones==opcionAtaqueHabil && aatrox.getVida()< ControllerAatrox.gastoRecursos(aatrox)) {
					ImpresionMensajes.ErrorRecursos();
					opciones = Leer.datoInt();
				}
				ControllerCombateAatrox.combateAatroxBoss(aatrox, boss, opciones);
				ImpresionMensajes.MostrarResultadoAatrox(aatrox, boss);

			} while (aatrox.getVida() > 0.0 && boss.getVida() > 0.0);
			if(aatrox.getVida()>0.0 && boss.getVida() <=0.0) {
				ImpresionMensajes.AceptarLoot();
				opciones = Leer.datoInt();
				lAtaque = ControllerLoot.lootAtaque();
				ImpresionMensajes.ImprimirLootAtaque(lAtaque, dl);
				aatrox.setAtaque(aatrox.getAtaque()+lAtaque.getAtaque());
				aatrox.setVidaMaxima(aatrox.getVidaMaxima() + lAtaque.getVida());
				aatrox.setVida(aatrox.getVidaMaxima());
				
				
				
				
			}else {
				System.out.println("Game over, no vales ni para estar sentado.");
			}

			break;

		default:
			break;
		}
	}
}
