import vista.ImpresionMenu;
import vista.ImpresionesEnemigos;
import vista.ImpresionesPersonajes;

public class MainPepe {

	public static void main(String[] args) {

		ImpresionMenu.imprimirTitulo();

		
		ImpresionesPersonajes.imprimirAatrox(); ImpresionesPersonajes.imprimirAzir();
		ImpresionesPersonajes.imprimirKled(); ImpresionesPersonajes.imprimirNeeko();
		ImpresionesEnemigos.imprimirShyvana();
		 
	}

}
