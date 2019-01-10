
import controller.combate.ControllerCombateAatrox;
import datos.DatosEnemigos;
import datos.DatosPersonajes;
import model.enemigos.EnemigoPrincipal;
import model.personajes.Aatrox;
import utilidades.Leer;
import vista.ImpresionMapas;
import vista.ImpresionesEnemigos;
import vista.ImpresionesEscenarios;
import vista.ImpresionesPersonajes;
import vista.ImpresionesTitulo;
import vista.MensajesHistoriaAatrox;

public class MainMiguel {

	public static void main(String[] args) {
//		DatosPersonajes dp = new DatosPersonajes();
//		DatosEnemigos de = new DatosEnemigos();
//		Aatrox aatrox;
//		EnemigoPrincipal boss;
//		aatrox = dp.getAatrox();
//		boss = de.getListaEnemigosPpal()[1];
//		System.out.println(aatrox);
//		do {
//			System.out.println("1-atacar/2-proteger/3-Ataque habilidad");
//			int opciones = Leer.datoInt();
//
//			ControllerCombateAatrox.combateAatroxBoss(aatrox, boss, opciones);
//			System.out.println(aatrox.getVida());
//			System.out.println(boss.getVida());
//		} while (aatrox.getVida() > 0.0  && boss.getVida() > 0.0 );
		
		
		MensajesHistoriaAatrox.impresionPantalla1();
		ImpresionMapas.imprimirmapaValoran();
		MensajesHistoriaAatrox.impresion1Pantalla2();
		ImpresionesPersonajes.imprimirAatrox();
		MensajesHistoriaAatrox.impresion2Pantalla2();
		MensajesHistoriaAatrox.impresion1Pantalla3();
		ImpresionMapas.imprimirShurima();
		ImpresionesEscenarios.ImprimirPiramide();
		MensajesHistoriaAatrox.impresion2Pantalla3();
		MensajesHistoriaAatrox.impresion1Pantalla4();
		ImpresionesTitulo.TituloOrnn();
		ImpresionesEnemigos.imprimirOrnn();
		MensajesHistoriaAatrox.impresion2Pantalla4();
	}
		

}
