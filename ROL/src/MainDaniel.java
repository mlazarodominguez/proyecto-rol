import controller.combate.ControllerCombateAatrox;
import controller.combate.ControllerCombateAzir;
import datos.DatosEnemigos;
import datos.DatosPersonajes;
import model.enemigos.EnemigoPrincipal;
import model.personajes.Aatrox;
import model.personajes.Azir;
import utilidades.Leer;
import vista.ImpresionCombate1;
import vista.ImpresionMapas;
import vista.ImpresionMensajes;
import vista.ImpresionMenu;
import vista.ImpresionesPersonajes;
import vista.ImpresionesTitulo;

public class MainDaniel {

	public static void main(String[] args) {
		
		int personaje, confirmar=0, cero = 0, opciones, turno=0;
		DatosPersonajes dp = new DatosPersonajes();
		DatosEnemigos de = new DatosEnemigos();
		Aatrox aatrox;
		Azir azir;
		EnemigoPrincipal boss;
		
		ImpresionMenu.imprimirTitulo();
		
		// Un bucle para que el usuario primero pueda visualizar cada uno de los personajes y luego confirmar su elección
		do {
			ImpresionMensajes.elegirPersonajes();
			personaje = Leer.datoInt();
			switch (personaje) {
			case 1://Aatrox
				ImpresionesTitulo.TituloAatrox();
				ImpresionesPersonajes.imprimirAatrox();
				ImpresionMensajes.confirmarPersonaje();
				confirmar = Leer.datoInt();
				
				break;
			case 2://Azir
				ImpresionesTitulo.TituloAzir();
				ImpresionesPersonajes.imprimirAzir();
				ImpresionMensajes.DescripcionAzir();
				ImpresionMensajes.confirmarPersonaje();
				confirmar = Leer.datoInt();
				break;
			case 3://Kled
				ImpresionesTitulo.TituloKled();
				ImpresionesPersonajes.imprimirKled();
				ImpresionMensajes.DescripcionKled();
				ImpresionMensajes.confirmarPersonaje();
				confirmar = Leer.datoInt();
				break;
			case 4://Neeko
				ImpresionesTitulo.TituloNeeko();
				ImpresionesPersonajes.imprimirNeeko();
				ImpresionMensajes.confirmarPersonaje();
				confirmar = Leer.datoInt();
				break;
	
			default:
				personaje=cero;
				break;
			}
		}while(confirmar==cero);
		
		switch (personaje) {
		case 1:
			aatrox = dp.getAatrox();
			boss = de.getListaEnemigosPpal()[1]; //Este me devuelve shyvana pero es de prueba
			ImpresionMensajes.HistoriaAatrox();
			confirmar = Leer.datoInt();
			if (confirmar != cero) {
				ImpresionCombate1.imprimirAatroxyEsbirro(); // De prueba
				do {
					turno++;
					ImpresionMensajes.ImprimirTurnos(turno);
					ImpresionMensajes.OpcionesCombateAatrox(aatrox);
					opciones = Leer.datoInt();
					ControllerCombateAatrox.combateAatroxBoss(aatrox, boss, opciones);
					System.out.println("Vida Aatrox: "+aatrox.getVida());
					System.out.println("Vida Boss: "+boss.getVida());
				}while(aatrox.getVida() > 0.0  && boss.getVida() > 0.0 );
			} else {
				
			}
			break;
		case 2://Azir
			azir = dp.getAzir();
			boss = de.getListaEnemigosPpal()[0]; //Ornn
			//Historia
			ImpresionMensajes.HistoriaAzir();
			ImpresionMapas.imprimirShurima();
			ImpresionMensajes.HistoriaAzir2();
			opciones = Leer.datoInt();
			if (opciones == 1) {
				//Combate
				ImpresionCombate1.imprimirAziryOrnn();
				do {
					turno++;
					ImpresionMensajes.ImprimirTurnos(turno);
					ImpresionMensajes.OpcionesCombateAzir(azir, boss);
					opciones = Leer.datoInt();
					while (opciones<1 || opciones >3) {
						System.out.println("Esa opción no está disponible");
						opciones = Leer.datoInt();
					}
					while (opciones == 3 && azir.getRecursos()<=0) {
						System.out.println("Azir no tiene mas recursos disponibles");
						opciones = Leer.datoInt();
					}
					ControllerCombateAzir.combateAzirBoss(azir, boss, opciones);
				}while(azir.getVida() > 0.0  && boss.getVida() > 0.0);
				
			} else {
				System.out.println("Eres un pussy");
			}
					
		default:
			break;
		}
		
		
	}

}
