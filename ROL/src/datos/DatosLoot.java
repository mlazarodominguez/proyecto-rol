package datos;

import model.loot.LootAtaque;
import model.loot.LootDefensa;
import model.loot.LootPoderHabilidad;

public class DatosLoot {
	//int vida, int ataque, String nombre
	private LootAtaque baileMuerte = new LootAtaque(5, 10, "Baile de la muerte");
	private LootAtaque sanguinaria = new LootAtaque(10, 15, "Sanguinaria");
	private LootAtaque trinidad = new LootAtaque(15, 20, "Fuerza de la Trinidad");
	//int defensa, int vida, String nombre
	private LootDefensa randuin = new LootDefensa(36, 10, "Presagio de Randuin");
	private LootDefensa sterak = new LootDefensa(36, 20, "Calibrador de Sterak");
	private LootDefensa shurelya = new LootDefensa(45, 30, "Ensueño de Shurelya");
	//int poderHabilidad, int recursos, String nombre
	private LootPoderHabilidad liandry = new LootPoderHabilidad(10, 100, "Tormento de Liandry");
	private LootPoderHabilidad tenaza = new LootPoderHabilidad(15, 100, "Tenaza de la muerte ígnea");
	private LootPoderHabilidad rabadon = new LootPoderHabilidad(20, 100, "Sombrero mortal de Rabadon");
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
