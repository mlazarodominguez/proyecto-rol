import controller.combate.ControllerCombateAatrox;
import controller.combate.ControllerCombateAzir;
import controller.loot.ControllerLoot;
import datos.DatosEnemigos;
import datos.DatosLoot;
import datos.DatosPersonajes;
import model.enemigos.EnemigoPrincipal;
import model.loot.LootPoderHabilidad;
import model.personajes.Aatrox;
import model.personajes.Azir;
import utilidades.Leer;
import vista.ImpresionCombate1;
import vista.ImpresionLoot1;
import vista.ImpresionMapas;
import vista.ImpresionMensajes;
import vista.ImpresionMenu;
import vista.ImpresionesPersonajes;
import vista.ImpresionesTitulo;
import vista.MensajesPrueba;

public class MainDaniel {

	public static void main(String[] args) {
		
		int personaje, confirmar=0, cero = 0, opciones, turno=0;
		DatosPersonajes dp = new DatosPersonajes();
		DatosLoot dl = new DatosLoot();
		DatosEnemigos de = new DatosEnemigos();
		ControllerLoot cl = new ControllerLoot();
		LootPoderHabilidad lph = new LootPoderHabilidad();
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
					while (opciones<1 || opciones >3) {//No permitir elegir una opcion que no este entre 1 y 3
						System.out.println("Esa opción no está disponible.Elija otra:");
						opciones = Leer.datoInt();
					}
					while (opciones == 3 && azir.getRecursos()<=0) { //No permitir hacer ataque de habilidad si no tiene recursos
						System.out.println("Azir no tiene mas recursos disponibles.Elije otra opción:");
						opciones = Leer.datoInt();
					}
					ControllerCombateAzir.combateAzirBoss(azir, boss, opciones);
					MensajesPrueba.MostrarResultadoAzir(azir, boss);
				}while(azir.getVida() > 0.0  && boss.getVida() > 0.0);
				if (azir.getVida() > 0.0 && boss.getVida() <= 0.0) {//Sigue el juego si gana el combate
					System.out.println("Quieres tu recompensa?");
					System.out.println("*1 para si");
					System.out.println("*2 para no");
					opciones = Leer.datoInt();
					if (opciones == 1) {
						lph = cl.LootHabilidad();
						System.out.println("Nombre de looteo: " + lph.getNombre());
						if (lph.getNombre().equals(dl.getListaLootPoderHabilidad()[0].getNombre())) {
							ImpresionLoot1.imprimirliandry();
							System.out.println("Esto es liandry");
						}
						if (lph.getNombre().equals(dl.getListaLootPoderHabilidad()[1].getNombre())) {
							ImpresionLoot1.imprimirTenaza();
							System.out.println("Esto es la tenaza");
						}
						if (lph.getNombre().equals(dl.getListaLootPoderHabilidad()[2].getNombre())) {
							ImpresionLoot1.imprimirRabadon();
							System.out.println("Esto es rabadon");
						}
					}
				}
				
			} else {
				System.out.println("Eres un pussy");
			}
					
		default:
			break;
		}
		
		
	}

}
