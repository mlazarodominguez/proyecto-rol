package vista;

import model.enemigos.EnemigoAleatorio;
import model.enemigos.EnemigoPrincipal;
import model.personajes.Azir;

public class MensajesPrueba {

	public static void MostrarResultadoAzir(Azir azir, EnemigoPrincipal boss) {
		if (boss.getVida() <= 0 && azir.getVida() > 0) {
			System.out.println("\n"+ boss.getNombre() +" ♥ " + boss.getVida() + "\t\t Azir ♥ " + azir.getVida());
			ImpresionesTitulo.tituloGanador();
		}
		if (boss.getVida() > 0 && azir.getVida() <= 0) {
			System.out.println("\n"+ boss.getNombre() +" ♥ "+ boss.getVida() + "\t\t Azir ♥ " + azir.getVida());
			ImpresionesTitulo.gameOver();
		}
		if (boss.getVida() <= 0 && azir.getVida() <= 0) {
			System.out.println("\n"+ boss.getNombre() +" ♥ "+ boss.getVida() + "\t\t Azir ♥ " + azir.getVida());
			System.out.println("Esto no deberia pasar");
		}
	}
	public static void mensajeProtegerPersonaje(double ataque) {
		System.out.println("Tu personaje se ha protegido: -" + ataque);
		System.out.println("Tu personaje se ha sanado");
	}
	public static void MostrarResultadoAzirVsAleatorio(Azir azir, EnemigoAleatorio boss) {
		if (boss.getVida() <= 0 && azir.getVida() > 0) {
			System.out.println("\n"+ boss.getNombre() +" ♥ " + boss.getVida() + "\t\t Azir ♥ " + azir.getVida());
			ImpresionesTitulo.tituloGanador();
		}
		if (boss.getVida() > 0 && azir.getVida() <= 0) {
			System.out.println("\n"+ boss.getNombre() +" ♥ "+ boss.getVida() + "\t\t Azir ♥ " + azir.getVida());
			ImpresionesTitulo.gameOver();
		}
		if (boss.getVida() <= 0 && azir.getVida() <= 0) {
			System.out.println("\n"+ boss.getNombre() +" ♥ "+ boss.getVida() + "\t\t Azir ♥ " + azir.getVida());
			System.out.println("Esto no deberia pasar");
		}

}
}
