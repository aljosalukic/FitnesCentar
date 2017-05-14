package msa.fitnes.model;

import org.joda.time.LocalTime;

public class Termin{
		
	
		protected Korisnik korisnik;
		protected LocalTime vremeOD;
		protected int duzina;
		protected LocalTime vremeDO;
		
		
		public Termin(Korisnik korisnik,LocalTime vremeOD, int duzina) {
			super();
			this.korisnik = korisnik;
			this.vremeOD = vremeOD;
			this.duzina = duzina;
			this.vremeDO = vremeOD.plusMinutes(duzina);
			
		}
		
		public Termin(Korisnik korisnik,String timeOD, int duzina) {
			super();
			this.korisnik = korisnik;
			this.vremeOD = LocalTime.parse(timeOD);
			this.duzina = duzina;
			this.vremeDO = vremeOD.plusMinutes(duzina);
			
		}


		public Termin() {
			super();
		}


		public Korisnik getKorisnik() {
			return korisnik;
		}


		public void setKorisnik(Korisnik korisnik) {
			this.korisnik = korisnik;
		}

		public LocalTime getVremeOD() {
			return vremeOD;
		}


		public void setVremeOD(LocalTime vremeOD) {
			this.vremeOD = vremeOD;
		}


		public long getDuzina() {
			return duzina;
		}


		public void setDuzina(int duzina) {
			this.duzina = duzina;
			this.vremeDO = vremeOD.plusMinutes(duzina);
		}


		public LocalTime getVremeDO() {
			return vremeDO;
		}


		@Override
		public String toString() {
			return "Termin [korisnik=" + korisnik + " " + ", vremeOD=" + vremeOD + ", duzina=" + duzina + ", vremeDO="
					+ vremeDO + "]";
		}
	
		
		
		
		
}
