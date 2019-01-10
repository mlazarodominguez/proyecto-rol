package datos;

import model.personajes.Aatrox;
import model.personajes.Azir;
import model.personajes.Kled;
import model.personajes.Neeko;

public class DatosPersonajes {

	private Aatrox aatrox = new Aatrox(100.0, 89, 72, 12, "Aatrox", 100.0);
	private Azir azir = new Azir(1000.0, 64, 12, 69, "Azir", 300, 300, 1000.0);
	private Kled kled = new Kled(100.0, 90, 63, 12, "Kled", 350, 100.0);
	private Neeko neeko = new Neeko(100.0, 50, 12, 80, "Neeko", 350, 100.0);
	
	public DatosPersonajes() {
		
	}

	public  Aatrox getAatrox() {
		return aatrox;
	}

	public  Azir getAzir() {
		return azir;
	}

	public Kled getKled() {
		return kled;
	}

	public  Neeko getNeeko() {
		return neeko;
	}

}
