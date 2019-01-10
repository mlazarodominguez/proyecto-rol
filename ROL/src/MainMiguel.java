

import datos.DatosEnemigos;
import datos.DatosLoot;
import datos.DatosPersonajes;
import model.enemigos.EnemigoPrincipal;
import model.loot.LootPoderHabilidad;
import model.personajes.Aatrox;
import model.personajes.Azir;
import utilidades.Leer;
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
		int personaje, confirmar = 0, cero = 0, opciones, turno = 0, opcionMin = 1, opcionMax = 3, saltoPantalla = 0,
				opcionAtaqueHabil = 3;
		DatosPersonajes dp = new DatosPersonajes();
		DatosLoot dl = new DatosLoot();
		DatosEnemigos de = new DatosEnemigos();
		LootPoderHabilidad lph = new LootPoderHabilidad();
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
				MensajeHistoriaAzir.DescripcionAzir();
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

			break;

		default:
			break;
		}
	}
}
