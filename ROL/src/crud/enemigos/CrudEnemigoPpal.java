package crud.enemigos;

import model.enemigos.EnemigoPrincipal;

public class CrudEnemigoPpal {
	
	private EnemigoPrincipal e1;
	
	public void anadirEnemigo() {
		
	}
		
	//public void anadirEnemigo(double vida, int ataque, int armadura, String nombre, int numJefe) {
	//	EnemigoPrincipal enemigoX = new EnemigoPrincipal(vida,ataque,armadura,nombre,numJefe);
	//	EnemigoPrincipal listaModificada[] = new EnemigoPrincipal[DatosEnemigos.getListaEnemigosPpal().length+1];
	//}
	
	public void incrementarAtaque(int aumento) {
		e1.setAtaque(e1.getAtaque()+aumento);
	}
	
	public void incrementarVida(double aumento) {
		e1.setVida(e1.getVida()+aumento);
	}
	
	public void incrementarArmadura(int aumento) {
		e1.setArmadura(e1.getArmadura()+aumento);
	}

}
