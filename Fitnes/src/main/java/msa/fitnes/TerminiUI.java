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
		System.out.println(   "Opcija 1: Unos termina\n"
				+"Opcija 2: Provera termina\n"
				+"Opcija 3: Provera koje trenutno u centru\n"
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
			default:
				System.out.println("nepostojeca komanda");
				break;
			}
		}
	}

	public static void unosTermina(){

		Termin termin1 = new Termin();


		System.out.println("Unesite datum, u formatu dd/MM/yyyy");
		String datum = Utility.ocitajTekst();
		Datum datum1 = new Datum(datum);

		System.out.println("Unesite vreme u periodu od 10:00 do 22:00 u formatu (HH:mm) :");
		String vremeOD = Utility.ocitajTekst();
		LocalTime timeOD = LocalTime.parse(vremeOD);
		termin1.setVremeOD(timeOD);
		System.out.println("Unesite duzinu trajanja treninga:");
		int duzina = Utility.ocitajCeoBroj();
		termin1.setDuzina(duzina);
		termin1.setVremeDO();


		System.out.println("Unesite id korisnika");
		int id = Utility.ocitajCeoBroj();

		for (Korisnik kor : listaKorisnika) {
			if(kor.getId() == id){
				System.out.println("Korisnik:" + kor.getIme() + " " + kor.getPrezime());
				termin1.setKorisnik(kor);
			}else
				System.out.println("Nema korisnika");
		}


		listaTermina.add(termin1);

		datum1.setTermini(listaTermina);

		DatumUI.datumi.add(datum1);

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
<<<<<<< HEAD
=======
					break;
>>>>>>> 6b995bab6af2ee1c69d9b7dbe9b3e783b4ab2637
				}
			}
			else if(timeOD.isBefore(termini.get(i).getVremeDO()) && timeDO.isAfter(termini.get(i).getVremeDO())){

				System.out.println(termini.get(i).toString());
				++brojTrenutnihkorisnika;
				if(brojTrenutnihkorisnika == 16){
					System.out.println("Nije slobodan termin");
				}
<<<<<<< HEAD
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

=======
			}else
				System.out.println("Nema zakazanih termina tada");
			}
		
		
		
		
		
>>>>>>> 6b995bab6af2ee1c69d9b7dbe9b3e783b4ab2637
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

<<<<<<< HEAD
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

=======
		for (int i = 0; i < termini.size(); i++) {
			if(timeOD.isBefore(termini.get(i).getVremeOD()) && timeDO.isAfter(termini.get(i).getVremeOD())){
				
				System.out.println(termini.get(i).toString());
				++brojTrenutnihkorisnika;
				if(brojTrenutnihkorisnika >= 16){
					System.out.println("Nije slobodan termin");
				}
			}
			else if(timeOD.isBefore(termini.get(i).getVremeDO()) && timeDO.isAfter(termini.get(i).getVremeDO())){
				
				System.out.println(termini.get(i).toString());
				++brojTrenutnihkorisnika;
				if(brojTrenutnihkorisnika >= 16){
					System.out.println("Nije slobodan termin");
				}
			}else
				System.out.println("Nema zakazanih termina tada");

		}
		
		
>>>>>>> 6b995bab6af2ee1c69d9b7dbe9b3e783b4ab2637
	}




}






