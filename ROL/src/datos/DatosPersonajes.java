package datos;

import model.personajes.Aatrox;
import model.personajes.Azir;


public class DatosPersonajes {
	//double vida, int defensa, int ataque, int poderHabilidad, String nombre, double vidaMaxima
	private Aatrox aatrox = new Aatrox(100.0, 89, 72, 12, "Aatrox", 100.0);
	//double vida, int defensa, int ataque, int poderHabilidad, String nombre, int recursos, int resursosMax, double vidaMaxima
	private Azir azir = new Azir(100.0, 64, 30, 60, "Azir", 200, 200, 100.0);
	
	public DatosPersonajes() {
		
	}

	public  Aatrox getAatrox() {
		return aatrox;
	}

	public  Azir getAzir() {
		return azir;
	}

}
