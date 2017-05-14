package msa.fitnes;

import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import msa.fitnes.model.Datum;
import msa.fitnes.model.Korisnik;
import msa.fitnes.model.Termin;
import msa.fitnes.utilities.Utility;



public class TerminiUI extends KorisnikUI{
	public static ArrayList<Termin> listaTermina = new ArrayList<Termin>();



	public static void ispisOpcijaTermina(){
		System.out.println("=============================\n"   
				+"Opcija 1: Unos termina\n"
				+"Opcija 2: Provera termina\n"
				+"Opcija 3: Provera koje trenutno u centru\n"
				+"Opcija 4: Prvi slobodan termin\n"
				+"Opcija 0: izlaz\n");
	}

	public static void meniTerminiUI(){

		int odluka = -1;
		while(odluka!= 0){
			ispisOpcijaTermina();
			System.out.print("opcija:");
			odluka = Utility.ocitajCeoBroj();
			switch (odluka) {
			case 0:
				System.out.println("Izlaz");
				break;
			case 1:
				unosTermina();
				break;
			case 2:
				proveraTermina();
				break;
			case 3:
				proveraTerminaSada();
				break;
			case 4:
				prviSlobodanTermin();
				break;
			default:
				System.out.println("nepostojeca komanda");
				break;
			}
		}
	}


	// UNOS TERMINA 
	public static void unosTermina(){

		System.out.println("Unesite datum, u formatu dd/MM/yyyy");
		String datum = Utility.ocitajTekst();
		Datum datum1 = DatumUI.pronadjiPoDatumu(datum);

		//Ako datum postoji
		if(datum1 != null){
			Termin termin1 = new Termin();
			System.out.println("Unesite vreme u periodu od 10:00 do 22:00 u formatu (HH:mm) :");
			String vremeOD = Utility.ocitajTekst();
			LocalTime timeOD = LocalTime.parse(vremeOD);
			termin1.setVremeOD(timeOD);

			System.out.println("Unesite duzinu trajanja treninga:");
			int duzina = Utility.ocitajCeoBroj();
			termin1.setDuzina(duzina);


			System.out.println("Unesite id korisnika");
			int id = Utility.ocitajCeoBroj();

			for (Korisnik kor : listaKorisnika) {
				if(kor.getId() == id){
					System.out.println("Korisnik:" + kor.getIme() + " " + kor.getPrezime());
					termin1.setKorisnik(kor);
				}else
					System.out.println("Nema korisnika");
			}

			//provera da li je popunjen broj korisnika centra u tom trenutku, ako nije(ako je true) onda dodajemo termin
			if(proveraTermina(datum, vremeOD, duzina) == true){
				listaTermina.add(termin1);
				datum1.dodajTermine(listaTermina);

			}else
				System.out.println("Termin zauzet");


			//AKO NE POSTOJE TERMINI ZA TAJ DATUM,KREIRAJ NOVI DATUM I TERMIN
		}else {
			System.out.println("Datum je prazan, unesite termin");
			Termin termin1 = new Termin();
			List<Termin> listTermin = new ArrayList<>();
			System.out.println("Unesite vreme u periodu od 10:00 do 22:00 u formatu (HH:mm) :");
			String vremeOD = Utility.ocitajTekst();
			LocalTime timeOD = LocalTime.parse(vremeOD);
			termin1.setVremeOD(timeOD);

			System.out.println("Unesite duzinu trajanja treninga:");
			int duzina = Utility.ocitajCeoBroj();
			termin1.setDuzina(duzina);

			System.out.println("Unesite id korisnika");
			int id = Utility.ocitajCeoBroj();

			for (Korisnik kor : listaKorisnika) {
				if(kor.getId() == id){
					System.out.println("Korisnik:" + kor.getIme() + " " + kor.getPrezime());
					termin1.setKorisnik(kor);
					listTermin.add(termin1);
					Datum datum2 = new Datum(datum, listTermin);
					DatumUI.datumi.add(datum2);
				}else
					System.out.println("Nema korisnika");
			}

		}

	}

	//	public static int provera(DateTime dt){
	//
	//
	//
	//		List<Termin> termini = DatumUI.listaPoDatumu(dt);
	//
	//		for (int i = 0; i < termini.size(); i++) {
	//			for (int j = i+1; j < termini.size(); j++) {
	//				if(termini.get(i).getVremeOD().isBefore(termini.get(j).getVremeDO()) &&
	//						termini.get(i).getVremeDO().isAfter(termini.get(j).getVremeOD())){
	//
	//					brojTrenutnihkorisnika++;
	//					continue;
	//				}else if(termini.get(i).getVremeDO().isBefore(termini.get(j).getVremeOD()) && 
	//						termini.get(j).getVremeOD().isAfter(termini.get(i).getVremeDO())){
	//					brojTrenutnihkorisnika--;
	//					continue;
	//				}
	//
	//			}
	//		}
	//		return brojTrenutnihkorisnika;
	//	}


	//PROVERA PREKLAPANJA VREMENA
	public static void proveraTermina(){

		int brojTrenutnihkorisnika = 0;

		System.out.println("Unesite datum, u formatu dd/MM/yyyy");
		String datum = Utility.ocitajTekst();
		List<Termin> termini = DatumUI.listaPoDatumu(datum);


		System.out.println("Unesite vreme u periodu od 10:00 do 22:00 u formatu (HH:mm) :");
		String vremeOD = Utility.ocitajTekst();

		System.out.println("Unesite duzinu trajanja treninga:");
		int duzina = Utility.ocitajCeoBroj();

		LocalTime timeOD = LocalTime.parse(vremeOD);
		LocalTime timeDO = timeOD.plusMinutes(duzina);

		for (int i = 0; i < termini.size(); i++) {
			if(timeOD.isBefore(termini.get(i).getVremeOD()) && timeDO.isAfter(termini.get(i).getVremeOD())){

				System.out.println(termini.get(i).toString());
				++brojTrenutnihkorisnika;
				if(brojTrenutnihkorisnika == 16){
					System.out.println("Nije slobodan termin");
				}
			}
			else if(timeOD.isBefore(termini.get(i).getVremeDO()) && timeDO.isAfter(termini.get(i).getVremeDO())){

				System.out.println(termini.get(i).toString());
				++brojTrenutnihkorisnika;
				if(brojTrenutnihkorisnika == 16){
					System.out.println("Nije slobodan termin");
				}
			}else if(timeOD.isAfter(termini.get(i).getVremeOD()) && timeDO.isBefore(termini.get(i).getVremeDO())){

				System.out.println(termini.get(i).toString());
				++brojTrenutnihkorisnika;
				if(brojTrenutnihkorisnika == 16){
					System.out.println("Nije slobodan termin");
				}
			}else if(timeOD.isBefore(termini.get(i).getVremeOD()) && timeOD.isAfter(termini.get(i).getVremeDO())){

				System.out.println(termini.get(i).toString());
				++brojTrenutnihkorisnika;
				if(brojTrenutnihkorisnika == 16){
					System.out.println("Nije slobodan termin");
				}
			}else if(timeOD.isEqual(termini.get(i).getVremeOD())){

				System.out.println(termini.get(i).toString());
				++brojTrenutnihkorisnika;
				if(brojTrenutnihkorisnika == 16){
					System.out.println("Nije slobodan termin");
				}	
			}else if(timeDO.equals(termini.get(i).getVremeDO())){

				System.out.println(termini.get(i).toString());
				++brojTrenutnihkorisnika;
				if(brojTrenutnihkorisnika == 16){
					System.out.println("Nije slobodan termin");
				}
			}
		}

		System.out.println("Broj korisnika u tom terminu -----> " + brojTrenutnihkorisnika);

	}


	public static void proveraTerminaSada(){

		int brojTrenutnihkorisnika = 0;

		DateTime dt = new DateTime();
		System.out.println(dt.toString("dd/MM/yyyy"));
		List<Termin> termini = DatumUI.listaPoDatumu(dt.toString("dd/MM/yyyy"));
		String vremeOD = LocalTime.now().toString("hh:mm");
		System.out.println(vremeOD);
		LocalTime timeOD = LocalTime.parse(vremeOD);
		LocalTime timeDO = timeOD.plusMinutes(10);

		if(termini != null){
			for (int i = 0; i < termini.size(); i++) {
				if(timeOD.isBefore(termini.get(i).getVremeOD()) && timeDO.isAfter(termini.get(i).getVremeOD())){

					System.out.println(termini.get(i).toString());
					++brojTrenutnihkorisnika;
					if(brojTrenutnihkorisnika == 16){
						System.out.println("Nije slobodan termin");
					}
				}
				else if(timeOD.isBefore(termini.get(i).getVremeDO()) && timeDO.isAfter(termini.get(i).getVremeDO())){

					System.out.println(termini.get(i).toString());
					++brojTrenutnihkorisnika;
					if(brojTrenutnihkorisnika == 16){
						System.out.println("Nije slobodan termin");
					}
				}else if(timeOD.isAfter(termini.get(i).getVremeOD()) && timeDO.isBefore(termini.get(i).getVremeDO())){

					System.out.println(termini.get(i).toString());
					++brojTrenutnihkorisnika;
					if(brojTrenutnihkorisnika == 16){
						System.out.println("Nije slobodan termin");
					}
				}else if(timeOD.isBefore(termini.get(i).getVremeOD()) && timeOD.isAfter(termini.get(i).getVremeDO())){

					System.out.println(termini.get(i).toString());
					++brojTrenutnihkorisnika;
					if(brojTrenutnihkorisnika == 16){
						System.out.println("Nije slobodan termin");
					}
				}else if(timeOD.isEqual(termini.get(i).getVremeOD())){

					System.out.println(termini.get(i).toString());
					++brojTrenutnihkorisnika;
					if(brojTrenutnihkorisnika == 16){
						System.out.println("Nije slobodan termin");
					}	
				}else if(timeDO.equals(termini.get(i).getVremeDO())){

					System.out.println(termini.get(i).toString());
					++brojTrenutnihkorisnika;
					if(brojTrenutnihkorisnika == 16){
						System.out.println("Nije slobodan termin");
					}
				}
			}
		}
		System.out.println("Broj korisnika u tom terminu -----> " + brojTrenutnihkorisnika);

	}

	public static boolean proveraTermina(String datum,String vremeOD, int duzina){

		boolean daLiMoze = false;
		int brojTrenutnihkorisnika = 0;


		List<Termin> termini = DatumUI.listaPoDatumu(datum);
		LocalTime timeOD = LocalTime.parse(vremeOD);
		LocalTime timeDO = timeOD.plusMinutes(duzina);

		for (int i = 0; i < termini.size(); i++) {
			if(timeOD.isBefore(termini.get(i).getVremeOD()) && timeDO.isAfter(termini.get(i).getVremeOD())){

				++brojTrenutnihkorisnika;
			}
			else if(timeOD.isBefore(termini.get(i).getVremeDO()) && timeDO.isAfter(termini.get(i).getVremeDO())){
				++brojTrenutnihkorisnika;

			}else if(timeOD.isAfter(termini.get(i).getVremeOD()) && timeDO.isBefore(termini.get(i).getVremeDO())){

				++brojTrenutnihkorisnika;

			}else if(timeOD.isBefore(termini.get(i).getVremeOD()) && timeOD.isAfter(termini.get(i).getVremeDO())){

				++brojTrenutnihkorisnika;

			}else if(timeOD.isEqual(termini.get(i).getVremeOD())){

				++brojTrenutnihkorisnika;

			}else if(timeDO.equals(termini.get(i).getVremeDO())){

				++brojTrenutnihkorisnika;
			}
		}

		System.out.println("Broj korisnika u tom terminu -----> " + brojTrenutnihkorisnika);

		if(brojTrenutnihkorisnika <= 2){
			daLiMoze = true;
		}
		return daLiMoze;

	}



	// VRACA BROJ KORISNIKA TERETANE U ZADATOM TRENUTKU
	public static int brojKorisnika(DateTime dt1,LocalTime timeOD,int duzina){

		int num = 0;
		List<Termin> termini = DatumUI.listaPoDatumu(dt1.toString("dd/MM/yyyy"));
		LocalTime timeDO = timeOD.plusMinutes(duzina);

		if(termini != null){
			for (int i = 0; i < termini.size(); i++) {

				if(timeOD.isBefore(termini.get(i).getVremeOD()) && timeDO.isAfter(termini.get(i).getVremeOD())){
					++num;
				}
				else if(timeOD.isBefore(termini.get(i).getVremeDO()) && timeDO.isAfter(termini.get(i).getVremeDO())){
					++num;
				}else if(timeOD.isAfter(termini.get(i).getVremeOD()) && timeDO.isBefore(termini.get(i).getVremeDO())){
					++num;
				}else if(timeOD.isBefore(termini.get(i).getVremeOD()) && timeOD.isAfter(termini.get(i).getVremeDO())){
					++num;
				}else if(timeOD.isEqual(termini.get(i).getVremeOD())){
					++num;
				}else if(timeDO.equals(termini.get(i).getVremeDO())){
					++num;
				}
			}
		}

		return num;
	}

	// Proverava prvi slobodan termin te duzine od ovog trenutka
	public static void prviSlobodanTermin(){
		DateTime dt = new DateTime();
		Datum datum = DatumUI.pronadjiPoDatumu(dt);

		LocalTime timeOD = new LocalTime().now();
		System.out.println("Unesite duzinu treninga:");
		int duzina = Utility.ocitajCeoBroj();
		LocalTime timeDO = timeOD.plusMinutes(duzina);

		int brojKorisnika = brojKorisnika(dt, timeOD, duzina);

		//ODREDJUJEMO MAX BROJ KORISNIKA I DA NAM PRETRAZI PRVI SLOBODAN TERMIN
		while(brojKorisnika >= 4){
			timeOD = timeOD.plusMinutes(10);
			//AKO KRAJ TERMINA PRELAZI 22:00 PREBACUJEMO SE NA SLEDECI DAN 
			if(timeDO.isAfter(LocalTime.parse("22:00"))){
				dt = dt.plusDays(1);
				timeOD = LocalTime.parse("10:00");
			}
			brojKorisnika = brojKorisnika(dt, timeOD, duzina);
		}

		System.out.println("Prvi slobodan termin je " + dt + " od " + timeOD);	

	}




}






