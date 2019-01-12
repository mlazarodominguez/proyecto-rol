package vista;

import model.enemigos.EnemigoPrincipal;
import model.personajes.Azir;

public class MensajesPrueba {

	public static void MostrarResultadoAzir(Azir azir, EnemigoPrincipal boss) {
		if (boss.getVida() <= 0 && azir.getVida() > 0) {
			System.out.println("\n"+ boss.getNombre() +" ♥ " + boss.getVida() + "\t\t Azir ♥ " + azir.getVida());
			ImpresionesTitulo.TituloGanador();
		}
		if (boss.getVida() > 0 && azir.getVida() <= 0) {
			System.out.println("\n"+ boss.getNombre() +" ♥ "+ boss.getVida() + "\t\t Azir ♥ " + azir.getVida());
			ImpresionesTitulo.GameOver();
		}
		if (boss.getVida() <= 0 && azir.getVida() <= 0) {
			System.out.println("\n"+ boss.getNombre() +" ♥ "+ boss.getVida() + "\t\t Azir ♥ " + azir.getVida());
			System.out.println("Esto no deberia pasar");
		}
	}

}
