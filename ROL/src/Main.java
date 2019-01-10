import java.util.Random;

import controller.loot.ControllerLoot;
import datos.DatosLoot;
import model.loot.LootPoderHabilidad;
import utilidades.Leer;
import vista.ImpresionLoot1;

public class Main {
	public static void main(String[] args) {
		
		
		Random r1 = new Random(System.nanoTime());
		ControllerLoot cl = new ControllerLoot();
		LootPoderHabilidad lph = new LootPoderHabilidad();
		int opciones = 0;
		DatosLoot dl = new DatosLoot();
		
		/*for (int i = 0; i < 2; i++) {
			int aleatorioLoot = r1.nextInt(16 - 0 + 1) + 1;
			System.out.println(aleatorioLoot);
		}*/
		
		//lpd = cl.LootHabilidad();
		
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

}
