package datos;

import model.enemigos.EnemigoAleatorio;
import model.enemigos.EnemigoPrincipal;

public class DatosEnemigos {

	private EnemigoPrincipal ornn = new EnemigoPrincipal(1000, 10, 50, 50, "Ornn", 1);
	private EnemigoPrincipal shyvana = new EnemigoPrincipal(100, 100, 50, 50, "Shyvana", 2);
	private EnemigoPrincipal leeroy = new EnemigoPrincipal(100, 100, 10, 50, "Leeroy Jenkins", 3);
	private EnemigoPrincipal malzahar = new EnemigoPrincipal(100, 100, 10, 50, "Malzahar", 4);
	private EnemigoPrincipal mordekaiser = new EnemigoPrincipal(100, 100, 10, 50, "Mordekaiser", 5);
	private EnemigoAleatorio a1 = new EnemigoAleatorio(100, 100, 10, 50, "Aleatorio1", 1);
	private EnemigoAleatorio a2 = new EnemigoAleatorio(100, 100, 10, 50, "Aleatorio2", 2);
	private EnemigoAleatorio a3 = new EnemigoAleatorio(100, 100, 10, 50, "Aleatorio3", 3);
	private EnemigoAleatorio a4 = new EnemigoAleatorio(100, 100, 10, 50, "Aleatorio4", 4);
	private EnemigoPrincipal listaEnemigosPpal[] = { ornn, shyvana, leeroy, malzahar, mordekaiser };
	private EnemigoAleatorio listaEnemigosAleatorio[] = { a1, a2, a3, a4 };

	// private LootAtaque[] LootAtaquev3= {new LootAtaque(15, 35, "Baile de la
	// muerte"),} Forma de crear los array declarando los objetos dentro;

	// Constructor
	public DatosEnemigos() {

	}

	public EnemigoPrincipal[] getListaEnemigosPpal() {
		return listaEnemigosPpal;
	}

	public void setListaEnemigosPpal(EnemigoPrincipal[] listaEnemigosPpal) {
		this.listaEnemigosPpal = listaEnemigosPpal;
	}

	public EnemigoAleatorio[] getListaEnemigosAleatorio() {
		return listaEnemigosAleatorio;
	}

	public void setListaEnemigosAleatorio(EnemigoAleatorio[] listaEnemigosAleatorio) {
		this.listaEnemigosAleatorio = listaEnemigosAleatorio;
	}

}
