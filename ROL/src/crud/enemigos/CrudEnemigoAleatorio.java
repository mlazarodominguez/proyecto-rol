package crud.enemigos;

import model.enemigos.EnemigoAleatorio;

public class CrudEnemigoAleatorio {
	
	private EnemigoAleatorio e1;
	
	public void anadirEneAleatorio() {
		
	}
	
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
