
import controller.combate.ControllerCombateAatrox;
import datos.DatosEnemigos;
import datos.DatosPersonajes;
import model.enemigos.EnemigoPrincipal;
import model.personajes.Aatrox;
import utilidades.Leer;

public class MainMiguel {

	public static void main(String[] args) {
		DatosPersonajes dp = new DatosPersonajes();
		DatosEnemigos de = new DatosEnemigos();
		Aatrox aatrox;
		EnemigoPrincipal boss;
		aatrox = dp.getAatrox();
		boss = de.getListaEnemigosPpal()[1];
		System.out.println(aatrox);
		do {
			System.out.println("1-atacar/2-proteger/3-Ataque habilidad");
			int opciones = Leer.datoInt();

			ControllerCombateAatrox.combateAatroxBoss(aatrox, boss, opciones);
			System.out.println(aatrox.getVida());
			System.out.println(boss.getVida());
		} while (aatrox.getVida() > 0.0  && boss.getVida() > 0.0 );

	}

}
