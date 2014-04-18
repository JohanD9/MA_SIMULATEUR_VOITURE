package src.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import domaineConduite.Direction;
import domaineConduite.Voiture;



public class TestVoiture {
	

	@Test
	public void testGetX(){
		Voiture voiture = new Voiture(20) ;
		
		int xVoiture = voiture.getCoordXEnMetres() ;
		
		assertEquals(20, xVoiture);
		
	}
	
	@Test
	public void testGetY(){
		Voiture voiture = new Voiture(20, 10, 20) ;
		
		int yVoiture = voiture.getCoordYEnMetres() ;
		
		assertEquals(10, yVoiture);
	}
	
	@Test
	public void testGetDirection()
	{
		Voiture voiture = new Voiture (20,20,20);
		
		assertEquals(voiture.getDirection(), Direction.DROITE);
	}
	
	@Test
	public void testSetY()
	{
		Voiture voiture = new Voiture (20,20,20);
		
		voiture.setCoordYEnMetres(50);
		
		assertEquals(voiture.getCoordYEnMetres(), 50);
	}
	
	@Test
	public void testSetDirection()
	{
		Voiture voiture = new Voiture (20,20,20);
		
		voiture.setDirection(Direction.HAUT);
		
		assertEquals(voiture.getDirection(), Direction.HAUT);
	}
	
	@Test
	public void testVitesseX() {
		Voiture voiture = new Voiture(20,150);
		
		assertEquals(150,voiture.getVitesseMetreParSecondes());
	}
	
	@Test
	public void testMiseAjourPositionEnFonctionVitesse() {
		Voiture voiture = new Voiture(20,100);
		voiture.avancerEnFonctionDeLaVitesse();
		assertEquals(120, voiture.getCoordXEnMetres());
	}
	
	@Test
	public void testMaximumPosition(){
		Voiture voiture = new Voiture(960,100);
		voiture.avancerEnFonctionDeLaVitesse();
		assertEquals(980, voiture.getCoordXEnMetres());
	}
	
	@Test
	public void testAccelerationVitesseMetreSeconde () {
		Voiture voiture = new Voiture (500, 50);
		
		voiture.accelerationVitesseMetreSeconde();
		
		assertEquals(60, voiture.getVitesseMetreParSecondes());
	}
	
	@Test
	public void testRalentissementVitesseMetreSeconde () {
		Voiture voiture = new Voiture (500, 50);
		
		voiture.ralentissementVitesseMetreSeconde();
		
		assertEquals(40, voiture.getVitesseMetreParSecondes());
	}

	@Test
	public void testModifierAccelerationVitesseMetreSeconde () {
		Voiture voiture = new Voiture (500, 50);
		
		voiture.modifierVitesseMetreSeconde(Direction.DROITE);
		assertEquals(60, voiture.getVitesseMetreParSecondes());
	}
	
	@Test
	public void testModifierRalentissementVitesseMetreSeconde () {
		Voiture voiture = new Voiture (500, 50);
		
		voiture.modifierVitesseMetreSeconde(Direction.GAUCHE);
		
		assertEquals(40, voiture.getVitesseMetreParSecondes());
	}
	
}
