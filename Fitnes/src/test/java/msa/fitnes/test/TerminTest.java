package msa.fitnes.test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import msa.fitnes.KorisnikUI;
import msa.fitnes.TerminiUI;
import msa.fitnes.model.Korisnik;
import msa.fitnes.model.Termin;

public class TerminTest extends TerminiUI{
	
	@Before
	public void setUp() throws Exception {
		
		Korisnik kor1 = new Korisnik(1, "Marko", "Markovic");
		Korisnik kor2 = new Korisnik(2,"Ivan","Ivanovic");
		assertTrue(kor1.getIme().equalsIgnoreCase("Marko"));
		assertTrue(kor2.getPrezime().equalsIgnoreCase("Ivanovic"));
		
		
		assertTrue(KorisnikUI.listaKorisnika.add(kor1));
		assertTrue(KorisnikUI.listaKorisnika.add(kor2));
		
		
		Termin termin1 = new Termin(kor1, "10:00", 60);
		Termin termin2 = new Termin(kor2, "12:00", 160);
		
		assertTrue(listaTermina.add(termin1));
		assertTrue(listaTermina.add(termin2));
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		for (Iterator<Korisnik> iterator = listaKorisnika.iterator(); iterator.hasNext();) {
			Korisnik korisnik = (Korisnik) iterator.next();
			if(korisnik.getIme().equalsIgnoreCase("Marko")){
				iterator.remove();
			}else if(korisnik.getIme().equalsIgnoreCase("Ivan")){
				iterator.remove();
			}
			
		}
		for (Iterator<Termin> iterator = listaTermina.iterator(); iterator.hasNext();) {
			Termin termin = (Termin) iterator.next();
			if(termin.getKorisnik().getIme().equalsIgnoreCase("Marko") && termin.getVremeOD().toString("HH:mm").equalsIgnoreCase("10:00")){
				iterator.remove();
			}else if(termin.getKorisnik().getIme().equalsIgnoreCase("Ivan") && termin.getVremeOD().toString("HH:mm").equalsIgnoreCase("12:00")){
				iterator.remove();
			}
		}
	}
	
	@Test
	public void test() {
		Korisnik kor1 = new Korisnik(1, "Marko", "Markovic");
		Termin termin1 = new Termin(kor1, "10:00", 60);
		
		
		
	}

}
