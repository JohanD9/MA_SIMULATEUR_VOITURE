package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import domaineConduite.Direction;
import domaineConduite.Voiture;

public class TestVoiture {

	@Test
	public void testGetX() {
		Voiture voiture = new Voiture(20, 20, 20);

		int xVoiture = voiture.getCoordXEnMetres();

		assertEquals(20, xVoiture);

	}

	@Test
	public void testGetY() {
		Voiture voiture = new Voiture(20, 10, 20, 20);

		int yVoiture = voiture.getCoordYEnMetres();

		assertEquals(10, yVoiture);
	}

	@Test
	public void testGetDirection() {
		Voiture voiture = new Voiture(20, 20, 20, 20);

		assertEquals(voiture.getDirection(), Direction.DROITE);
	}

	@Test
	public void testSetY() {
		Voiture voiture = new Voiture(20, 20, 20, 20);

		voiture.setCoordYEnMetres(50);

		assertEquals(voiture.getCoordYEnMetres(), 50);
	}

	@Test
	public void testSetDirection() {
		Voiture voiture = new Voiture(20, 20, 20, 20);

		voiture.setDirection(Direction.HAUT);

		assertEquals(voiture.getDirection(), Direction.HAUT);
	}

	@Test
	public void testVitesseX() {
		Voiture voiture = new Voiture(20, 150, 20);

		assertEquals(150, voiture.getVitesseMetreParSecondes());
	}

	@Test
	public void testMiseAjourPositionEnFonctionVitesse() {
		Voiture voiture = new Voiture(20, 100, 20);
		voiture.avancerEnFonctionDeLaVitesse();
		assertEquals(120, voiture.getCoordXEnMetres());
	}

	@Test
	public void testMaximumPosition() {
		Voiture voiture = new Voiture(960, 100, 20);
		voiture.avancerEnFonctionDeLaVitesse();
		System.out.println(voiture.getCoordXEnMetres());
		assertEquals(voiture.largeurDomaine-(voiture.getLongueurVoiture()*2), voiture.getCoordXEnMetres());
	}

}
