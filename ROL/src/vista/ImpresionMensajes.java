package vista;

import datos.DatosLoot;
import model.enemigos.EnemigoPrincipal;
import model.loot.LootAtaque;
import model.loot.LootPoderHabilidad;
import model.personajes.Aatrox;
import model.personajes.Azir;

public class ImpresionMensajes {

	public static void saltarPantalla() {
		System.out.println("--> [1] para continuar la historia.");
	}

	public static void mensajeAtaquePersonaje(double ataque) {

		System.out.println("Tu personaje ha atacado al enemigo: -" + ataque);

	}

	public static void mensajeAtaqueJefe(double ataque) {
		System.out.println("Te han atacado: -" + ataque);
	}

	public static void mensajeProtegerPersonaje(double ataque) {
		System.out.println("Tu personaje se ha protegido: -" + ataque);
	}

	public static void mensajeSanarJefe(double sanacion) {
		if (sanacion == 0) {
			System.out.println("El tonto***** esta full de vida y no se ha podido sanar: " + sanacion);
		}
		System.out.println("El enemigo se ha sanado: " + sanacion);
	}

	public static void gastoRecursosVida(double recursos) {
		System.out.println("Coste: " + recursos + " Vida");
	}

	public static void gastoRecursosMana(int recursos) {
		System.out.println("Coste: " + recursos + " Maná");
	}

	public static void MostrarResultadoAatrox(Aatrox aatrox, EnemigoPrincipal boss) {
		if (boss.getVida() <= 0 && aatrox.getVida() > 0) {
			System.out.println("\nBoss ♥ " + boss.getVida() + "\t\t Aatrox♥ " + aatrox.getVida());
			ImpresionesTitulo.TituloGanador();
		}
		if (boss.getVida() > 0 && aatrox.getVida() <= 0) {
			System.out.println("\nBoss ♥ " + boss.getVida() + "\t\t Aatrox ♥ " + aatrox.getVida());
			System.out.println("Has perdido");
		}
	}

	public static void elegirPersonajes() {
		System.out.println("Elige el personaje con el que deseas pasarte League of Legend");
		System.out.println("*Pulsa 1 para conocer a Aatrox");
		System.out.println("*Pulsa 2 para conocer a Azir");
		System.out.println("*Pulsa 3 para conocer a Kled");
		System.out.println("*Pulsa 4 para conocer a Neeko");
	}

	public static void confirmarPersonaje() {
		System.out.println("Pulsa 1 para comenzar el juego con este personaje");
		System.out.println("Pulsa 0 para volver atrás");
	}

	public static void HistoriaAatrox() {
		System.out.println(
				"Al elegir Aatrox te has convertido en el heredero del mal... La historia de Aatrox se narra en las tierras de Valoran...\n\n\n");
		ImpresionMapas.imprimirmapaValoran();
		System.out.println(
				"\n\n\nTe acabas de encontrar con Ornn debes acabar con el para conseguir una recompensa y pasar al siguiente nivel");
		System.out.println("*Pulsa cualquier número para luchar");
		System.out.println("*Pulsa 0 para intentar huir");
	}

	public static void OpcionesCombateAatrox(Aatrox aatrox, EnemigoPrincipal boss) {
		System.out.println("Aatrox ♥ " + aatrox.getVida() + "\t\t Boss ♥ " + boss.getVida());
		System.out.println("\n*Pulsa 1 para atacar con un golpe básico(Daño: " + aatrox.getAtaque() + ")");
		System.out.println("*Pulsa 2 para protgerte del ataque rival");
		System.out
				.println("*Pulsa 3 para atacar con el golpe de habilidad(Daño: " + aatrox.getPoderHabilidad() + ")\n");
	}

	public static void OpcionesCombateAzir(Azir azir, EnemigoPrincipal boss) {
		System.out.println(
				"Azir ♥ " + azir.getVida() + "\t Recursos ✧   " + azir.getRecursos() + "\t\t"+ boss.getNombre() +" ♥ " + boss.getVida());
		System.out.println("\n*Pulsa 1 para atacar con un golpe básico(Daño: " + azir.getAtaque() + ")");
		System.out.println("*Pulsa 2 para protgerte del ataque rival");
		System.out.println("*Pulsa 3 para atacar con el golpe de habilidad(Daño: " + azir.getPoderHabilidad() + ")\n");
	}

	public static void DescripcionKled() {
		System.out.println(
				"\nKled es un héroe popular entre las gentes de Valoran. Muchos soldados afirman \nque ha luchado en todos las guerras y en todas ha salido como vencedor.\n"
						+ "Kled tiene un rol de luchador y es el mejor en el ataque cuerpo a cuerpo\n");
	}

	public static void HistoriaKled() {
		System.out.println(
				"\nUn día, de la nada, apareció Kled en lo alto de la cima, contemplando el campo de batalla. Iba a lomo de Skaarl, un dragarto inmortal del desierto."
						+ "\nEl jinete solitario se puso de pie sobre la silla de su montura. ");

	}

	// TODO: pasar el mapa de Valoran si fuese posible para dar una idea al jugador

	public static void HistoriaKled2() {
		System.out.println("\nCuando Kled puso la vista en el campo de batalla vio algo que no le gustaría ver a nadie."
				+ "\nNo tenía muchas opciones puesto que apenas tenía recursos."
				+ "\nSe encontró con con una feroz criatura. Cuando se posó ante él se convirtió en humana. ¡Era Shyvana!"
				+ "¿Qué podría hacer Kled, si no tenía recursos?"
				+ "\n*Pulsa 1 para luchar y abrirte paso para continuar tu viaje\n"
				+ "*Pulsa 2 para dar la vuelta y escapar de Shyvana");
	}

	public static void ImprimirTurnos(int turnos) {
		System.out.println("\n************* Turno " + turnos + " *************");
	}

	public static void ErrorOpciones() {
		System.out.println("Esa opción no está disponible.Elija otra:");
	}

	public static void ErrorRecursos() {
		System.out.println("No tiene mas recursos disponibles.Elije otra opción:");
	}

	public static void ImprimirLootHabilidad(LootPoderHabilidad lph, DatosLoot dl) {
		if (lph.getNombre().equals(dl.getListaLootPoderHabilidad()[0].getNombre())) {
			ImpresionLoot1.imprimirliandry();
			System.out.println("\nObjeto común : " + lph.getNombre());
			System.out.println("Poder de habilidad : " + lph.getPoderHabilidad() + " ↑" + "\n" + "Rescursos : "
					+ lph.getRecursos() + " ↑");
		}
		if (lph.getNombre().equals(dl.getListaLootPoderHabilidad()[1].getNombre())) {
			ImpresionLoot1.imprimirTenaza();
			System.out.println("\nObjeto Épico : " + lph.getNombre());
			System.out.println("Poder de habilidad : " + lph.getPoderHabilidad() + " ↑" + "\n" + "Rescursos : "
					+ lph.getRecursos() + " ↑");
		}
		if (lph.getNombre().equals(dl.getListaLootPoderHabilidad()[2].getNombre())) {
			ImpresionLoot1.imprimirRabadon();
			System.out.println("\nLEGENDARIOO !!! : " + lph.getNombre());
			System.out.println("Poder de habilidad : " + lph.getPoderHabilidad() + " ↑" + "\n" + "Rescursos : "
					+ lph.getRecursos() + " ↑");
		}
	}

	public static void ImprimirLootAtaque(LootAtaque lph, DatosLoot dl) {
		if (lph.getNombre().equals(dl.getListaLootAtaque()[0].getNombre())) {
			ImpresionLoot1.imprimirBailemuerte();
			System.out.println("\nObjeto común : " + lph.getNombre());
			System.out.println("Atque : " + lph.getAtaque() + " ↑" + "\n" + "Vida: " + lph.getVida() + " ↑");
		}
		if (lph.getNombre().equals(dl.getListaLootAtaque()[1].getNombre())) {
			ImpresionLoot1.imprimirSanguinaria();
			System.out.println("\nObjeto Épico : " + lph.getNombre());
			System.out.println("Ataque : " + lph.getAtaque() + " ↑" + "\n" + "Vida : " + lph.getVida() + " ↑");
		}
		if (lph.getNombre().equals(dl.getListaLootAtaque()[2].getNombre())) {
			ImpresionLoot1.imprimirTrinidad();
			System.out.println("\nLEGENDARIOO !!! : " + lph.getNombre());
			System.out.println("Ataque : " + lph.getAtaque() + " ↑" + "\n" + "Vida : " + lph.getVida() + " ↑");
		}
	}

	public static void AceptarLoot() {
		System.out.println("Le has pateado el culo a ese jefe. Pulsa cualquier número para reclamar tu recompensa.");
	}

	public static void nuevasEstadisticasAzir(Azir azir) {
		System.out.println("Nuevos Recursos : " + azir.getRecursos());
		System.out.println("Nuevo poder de habilidad : " + azir.getPoderHabilidad());
	}
	public static void traicionShyvana() {
		System.out.println("\nShyvana te ha traicionado. Has sido destruido\n");
		ImpresionesTitulo.TituloFinal();
	}

}
