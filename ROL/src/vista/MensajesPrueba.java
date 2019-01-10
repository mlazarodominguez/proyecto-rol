package vista;

import model.enemigos.EnemigoPrincipal;
import model.personajes.Azir;

public class MensajesPrueba {
	
	public static void MostrarResultadoAzir(Azir azir, EnemigoPrincipal boss) {
		if (boss.getVida()<=0 && azir.getVida()>0) {
			System.out.println("\nBoss ♥ " + boss.getVida() + "\t\t Azir ♥ "+ azir.getVida());
			System.out.println("Has ganado");
		}
		if(boss.getVida()>0 && azir.getVida()<=0) {
			System.out.println("\nBoss ♥ " + boss.getVida() + "\t\t Azir ♥ "+ azir.getVida());
			System.out.println("Has perdido");
		}
		if (boss.getVida()<=0 && azir.getVida()<=0) {
			System.out.println("\nBoss ♥ " + boss.getVida() + "\t\t Azir ♥ "+ azir.getVida());
			System.out.println("Esto no deberia pasar");
		}
	}

}
