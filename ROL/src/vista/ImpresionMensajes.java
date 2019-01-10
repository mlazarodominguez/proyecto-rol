package vista;

import model.enemigos.EnemigoPrincipal;
import model.personajes.Aatrox;
import model.personajes.Azir;

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
		System.out.println("*Pulsa 3 para atacar con el golpe de habilidad(Daño: "+ aatrox.getPoderHabilidad());
	}

	public static void OpcionesCombateAzir(Azir azir, EnemigoPrincipal boss) {
		System.out.println("Azir ♥ "+ azir.getVida() + "\t Recursos ✧   "+ azir.getRecursos() + "\t\t Boss ♥ " + boss.getVida());
		System.out.println("\n*Pulsa 1 para atacar con un golpe básico(Daño: " + azir.getAtaque() + ")");
		System.out.println("*Pulsa 2 para protgerte del ataque rival");
		System.out.println("*Pulsa 3 para atacar con el golpe de habilidad(Daño: "+ azir.getPoderHabilidad()+")\n");
	}

	public static void DescripcionAzir() {
		System.out.println("\nAzir, emperador de Shurima en un pasado remoto, fue traicionado y asesinado en la hora de su mayor triunfo \npero ahora, milenios después, ha renacido como un ser Ascendido de inmenso poder.\n"
				+ "Azir es un mago muy poderoso con un gran conocimiento en hechizos.\n");
	}
	public static void DescripcionKled() {
		System.out.println("\nKled es un héroe popular entre las gentes de Valoran. Muchos soldados afirman \nque ha luchado en todos las guerras y en todas ha salido como vencedor.\n"
				+ "Kled tiene un rol de luchador y es el mejor en el ataque cuerpo a cuerpo\n");
	}

	public static void HistoriaAzir() {
		System.out.println("\nAzir caminaba sobre los dorados adoquines del Camino del Emperador. Las inmensas estatuas de los primeros señores de Shurima —sus antepasados— lo contemplaban."
				+"\nEl firmamento nocturno no era como Azir lo recordaba. Las estrellas y las constelaciones no estaban en su sitio. Habían pasado milenios. Ahora Shruima sólo era una ciudad de fantasmas.\n\n");
	}
	
	public static void HistoriaAzir2() {
		System.out.println("\n\nMientras seguía avanzando por el Camino del Emperador, una oleada de energia lo golpeo empujándolo, era Ornn un semidiós de Freljord,\n"
				+"el culpable del aniquiliamiento de Shurima pero ahora Azir tenía en su mano poder vengarlos...\n"+
				"\n*Pulsa 1 para luchar contra Ornn y vengar a los tuyos\n"
				+"*Pulsa 2 para rendirte");
	}
	public static void ImprimirTurnos(int turnos) {
		System.out.println("\n************* Turno " + turnos +" *************");
	}
	

}
