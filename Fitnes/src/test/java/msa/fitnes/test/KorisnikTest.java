package msa.fitnes.test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import msa.fitnes.KorisnikUI;
import msa.fitnes.model.Korisnik;

public class KorisnikTest extends KorisnikUI {

	@Before
	public void setUp() throws Exception {
		
		Korisnik kor1 = new Korisnik(1, "Marko", "Markovic");
		Korisnik kor2 = new Korisnik(2,"Ivan","Ivanovic");
		assertTrue(kor1.getIme().equalsIgnoreCase("Marko"));
		assertTrue(kor2.getPrezime().equalsIgnoreCase("Ivanovic"));
		
		
		assertTrue(KorisnikUI.listaKorisnika.add(kor1));
	}
	
	
	@After
	public void tearDown() throws Exception {
		for (Iterator<Korisnik> iterator = listaKorisnika.iterator(); iterator.hasNext();) {
			Korisnik korisnik = (Korisnik) iterator.next();
			if(korisnik.getIme().equalsIgnoreCase("Marko")){
				iterator.remove();
			}
			
		}
	}
	
	
	@Test
	public void test() {
		Korisnik kor2 = new Korisnik(2,"Ivan","Ivanovic");
		assertNotNull(kor2);
	
	}

}
