package vista;

import model.personajes.Aatrox;

public class ImpresionMensajes {

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
		System.out.println("Al elegir Aatrox te has convertido en el heredero del mal... La historia de Aatrox se narra en las tierras de Valoran...\n\n\n");
		ImpresionMapas.imprimirmapaValoran();
		System.out.println("\n\n\nTe acabas de encontrar con Ornn debes acabar con el para conseguir una recompensa y pasar al siguiente nivel");
		System.out.println("*Pulsa cualquier número para luchar");
		System.out.println("*Pulsa 0 para intentar huir");
	}
	public static void OpcionesCombateAatrox(Aatrox aatrox) {
		System.out.println("*Pulsa 1 para atacar con un golpe básico(Daño: " + aatrox.getAtaque() + ")");
		System.out.println("*Pulsa 2 para protgerte del ataque rival");
		System.out.println("*Pulsa 3 para atacar con el golpe de habilidad(Daño: "+ aatrox.getPoderHabilidad()+ " sólo puede usarse una vez por combate)");
	}
}
