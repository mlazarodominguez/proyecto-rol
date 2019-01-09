package model.combate;

import model.enemigos.EnemigoAleatorio;
import model.enemigos.EnemigoPrincipal;
import model.personajes.Aatrox;
import model.personajes.Azir;
import model.personajes.Kled;
import model.personajes.Neeko;

public class Combate {

	private Aatrox aatrox;
	private Azir azir;
	private Kled kled;
	private Neeko neeko;
	private EnemigoPrincipal boss;
	private EnemigoAleatorio randomEnemy;

	public Combate() {

	}

	public Combate(Aatrox aatrox, EnemigoPrincipal boss) {

		this.aatrox = aatrox;
		this.boss = boss;
	}

	public Combate(Aatrox aatrox, EnemigoAleatorio randomEnemy) {
		super();
		this.aatrox = aatrox;
		this.randomEnemy = randomEnemy;
	}

	public Combate(Azir azir, EnemigoPrincipal boss) {
		super();
		this.azir = azir;
		this.boss = boss;
	}

	public Combate(Azir azir, EnemigoAleatorio randomEnemy) {
		super();
		this.azir = azir;
		this.randomEnemy = randomEnemy;
	}

	public Combate(Kled kled, EnemigoPrincipal boss) {
		super();
		this.kled = kled;
		this.boss = boss;
	}

	public Combate(Kled kled, EnemigoAleatorio randomEnemy) {
		super();
		this.kled = kled;
		this.randomEnemy = randomEnemy;
	}

	public Combate(Neeko neeko, EnemigoPrincipal boss) {
		super();
		this.neeko = neeko;
		this.boss = boss;
	}

	public Combate(Neeko neeko, EnemigoAleatorio randomEnemy) {
		super();
		this.neeko = neeko;
		this.randomEnemy = randomEnemy;
	}

	public Aatrox getAatrox() {
		return aatrox;
	}

	public void setAatrox(Aatrox aatrox) {
		this.aatrox = aatrox;
	}

	public Azir getAzir() {
		return azir;
	}

	public void setAzir(Azir azir) {
		this.azir = azir;
	}

	public Kled getKled() {
		return kled;
	}

	public void setKled(Kled kled) {
		this.kled = kled;
	}

	public Neeko getNeeko() {
		return neeko;
	}

	public void setNeeko(Neeko neeko) {
		this.neeko = neeko;
	}

	public EnemigoPrincipal getBoss() {
		return boss;
	}

	public void setBoss(EnemigoPrincipal boss) {
		this.boss = boss;
	}

	public EnemigoAleatorio getRandomEnemy() {
		return randomEnemy;
	}

	public void setRandomEnemy(EnemigoAleatorio randomEnemy) {
		this.randomEnemy = randomEnemy;
	}

	public String toString() {
		return "Combate [aatrox=" + aatrox + ", azir=" + azir + ", kled=" + kled + ", neeko=" + neeko + ", boss=" + boss
				+ ", randomEnemy=" + randomEnemy + "]";
	}

}
