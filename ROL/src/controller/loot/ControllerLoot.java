package controller.loot;

import java.util.Random;

import datos.DatosLoot;
import model.loot.LootPoderHabilidad;

public class ControllerLoot {
	
	public LootPoderHabilidad LootHabilidad() {
		Random r1 = new Random(System.nanoTime());
		DatosLoot lootHabilidad = new DatosLoot();
		int minComun = 0, maxComun = 10, minEpica = 11, maxEpica = 15, minLeg = 16, maxLeg = 17, posArray=0;
		int aleatorioLoot = r1.nextInt(16 - 0 + 1) + 1;
		if (aleatorioLoot>=minComun && aleatorioLoot<=maxComun) {
			posArray = 0;
		}
		if (aleatorioLoot>=minEpica && aleatorioLoot<=maxEpica) {
			posArray = 1;
		}
		if (aleatorioLoot>=minLeg && aleatorioLoot<=maxLeg) {
			posArray = 2;
		}
		return lootHabilidad.getListaLootPoderHabilidad()[posArray];
	}

}
