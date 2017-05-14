package msa.fitnes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import msa.fitnes.model.Datum;
import msa.fitnes.model.Korisnik;
import msa.fitnes.model.Termin;
import msa.fitnes.utilities.Utility;

public class App {

	public static void init(){
		Korisnik korisnik1 = new Korisnik(1, "Aljosa", "Lukic");
		Korisnik korisnik2 = new Korisnik(2, "Mirjana", "Pisaric");
		KorisnikUI.listaKorisnika.add(korisnik1);
		KorisnikUI.listaKorisnika.add(korisnik2); 
		
		Termin termin1 = new Termin(korisnik1, "12:00", 180);
		Termin termin2 = new Termin(korisnik1, "13:00", 60);
		Termin termin3 = new Termin(korisnik2, "12:00", 120);
		Termin termin4 = new Termin(korisnik2, "13:30", 45);
		Termin termin5 = new Termin(korisnik2, "8:00", 180);
		
		List<Termin> termini = new ArrayList<Termin>();
		termini.add(termin1);
		termini.add(termin2);
		termini.add(termin3);
		termini.add(termin4);
		termini.add(termin5);
		Datum datum =new Datum("14/05/2017", termini);
		DatumUI.datumi.add(datum);
	}
	
	
	public static void ispisOpcija(){
		System.out.println(		  "Opcija 1: Korisnici \n"
								+ "Opcija 2: Datumi \n"
								+ "Opcija 3: Termini \n"
								+ "Opcija 0: Izlaz\n");
	}

	public static void main(String[] args) {
		init();
		int odluka = -1;
		
		while(odluka != 0){
		Date date = new Date();
		System.out.println(date);
		System.out.println();
		ispisOpcija();	
		System.out.print("opcija:");
		odluka = Utility.ocitajCeoBroj();
		
		switch (odluka) {
		case 0:
			System.out.println("Izlaz iz programa");
			break;
		case 1:
			KorisnikUI.meniKorisnikUI();
			break;
		case 2:
			DatumUI.meniDatumUI();
			break;
		case 3:
			TerminiUI.meniTerminiUI();
			break;		
		default:
			System.out.println("Opcija ne postoji");
			break;
		}
	}	
	

	}

}
