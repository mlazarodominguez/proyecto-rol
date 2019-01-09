import controller.combate.ControllerCombateAatrox;

import datos.DatosEnemigos;
import datos.DatosPersonajes;
import model.enemigos.EnemigoPrincipal;
import model.personajes.Aatrox;
import utilidades.Leer;
import vista.ImpresionMensajes;
import vista.ImpresionMenu;
import vista.ImpresionesPersonajes;
import vista.ImpresionesTitulo;

public class MainDaniel {

	public static void main(String[] args) {

		int personaje, confirmar, cero = 0, opciones, turno = 0;
		DatosPersonajes dp = new DatosPersonajes();
		DatosEnemigos de = new DatosEnemigos();
		Aatrox aatrox;
		EnemigoPrincipal boss;

		ImpresionMenu.imprimirTitulo();

		// Un bucle para que el usuario primero pueda visualizar cada uno de los
		// personajes y luego confirmar su elección
		do {
			ImpresionMensajes.elegirPersonajes();
			personaje = Leer.datoInt();
			switch (personaje) {
			case 1:
				ImpresionesTitulo.TituloAatrox();
				ImpresionesPersonajes.imprimirAatrox();
				ImpresionMensajes.confirmarPersonaje();
				confirmar = Leer.datoInt();

				break;
			case 2:
				ImpresionesTitulo.TituloAzir();
				ImpresionesPersonajes.imprimirAzir();
				ImpresionMensajes.confirmarPersonaje();
				confirmar = Leer.datoInt();
				break;
			case 3:
				ImpresionesTitulo.TituloKled();
				ImpresionesPersonajes.imprimirKled();
				ImpresionMensajes.confirmarPersonaje();
				confirmar = Leer.datoInt();
				break;
			case 4:
				ImpresionesTitulo.TituloNeeko();
				ImpresionesPersonajes.imprimirNeeko();
				ImpresionMensajes.confirmarPersonaje();
				confirmar = Leer.datoInt();
				break;

			default:
				personaje = cero;
				break;
			}
		} while (personaje == cero);

		switch (personaje) {
		case 1:
			aatrox = dp.getAatrox();
			boss = de.getListaEnemigosPpal()[1]; // Este me devuelve shyvana pero es de prueba
			ImpresionMensajes.HistoriaAatrox();
			confirmar = Leer.datoInt();
			if (confirmar != cero) {
				// De prueba
				do {
					turno++;
					System.out.println("************* Turno " + turno + " *************");
					ImpresionMensajes.OpcionesCombateAatrox(aatrox);
					opciones = Leer.datoInt();
					ControllerCombateAatrox.combateAatroxBoss(aatrox, boss, opciones);
					System.out.println("Vida Aatrox: " + aatrox.getVida());
					System.out.println("Vida Boss: " + boss.getVida());
				} while (aatrox.getVida() > 0.0 && boss.getVida() > 0.0);
			} else {

			}
			break;

		default:
			break;
		}

	}

}
