package datos;

import model.loot.LootAtaque;
import model.loot.LootDefensa;
import model.loot.LootPoderHabilidad;

public class DatosLoot {

	private LootAtaque baileMuerte = new LootAtaque(15, 35, "Baile de la muerte");
	private LootAtaque sanguinaria = new LootAtaque(12, 45, "Sanguinaria");
	private LootAtaque trinidad = new LootAtaque(20, 40, "Fuerza de la Trinidad");
	private LootDefensa randuin = new LootDefensa(36, 80, "Presagio de Randuin");
	private LootDefensa sterak = new LootDefensa(36, 45, "Calibrador de Sterak");
	private LootDefensa shurelya = new LootDefensa(45, 50, "Ensueño de Shurelya");
	private LootPoderHabilidad liandry = new LootPoderHabilidad(85, 130, "Tormento de Liandry");
	private LootPoderHabilidad tenaza = new LootPoderHabilidad(60, 100, "Tenaza de la muerte ígnea");
	private LootPoderHabilidad rabadon = new LootPoderHabilidad(120, 60, "Sombrero mortal de Rabadon");
	private LootAtaque listaLootAtaque[] = { baileMuerte, sanguinaria, trinidad };
	private LootDefensa listaLootDefensa[] = { randuin, sterak, shurelya };
	private LootPoderHabilidad listaLootPoderHabilidad[] = { liandry, tenaza, rabadon };
	
	public LootAtaque[] getListaLootAtaque() {
		return listaLootAtaque;
	}
	public void setListaLootAtaque(LootAtaque[] listaLootAtaque) {
		this.listaLootAtaque = listaLootAtaque;
	}
	public LootDefensa[] getListaLootDefensa() {
		return listaLootDefensa;
	}
	public void setListaLootDefensa(LootDefensa[] listaLootDefensa) {
		this.listaLootDefensa = listaLootDefensa;
	}
	public LootPoderHabilidad[] getListaLootPoderHabilidad() {
		return listaLootPoderHabilidad;
	}
	public void setListaLootPoderHabilidad(LootPoderHabilidad[] listaLootPoderHabilidad) {
		this.listaLootPoderHabilidad = listaLootPoderHabilidad;
	}
	
	
			

	

}
