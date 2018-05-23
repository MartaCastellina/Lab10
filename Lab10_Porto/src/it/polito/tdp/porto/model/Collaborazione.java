package it.polito.tdp.porto.model;

public class Collaborazione {

	private int autore1;
	private int autore2;
	public Collaborazione(int autore1, int autore2) {
		super();
		this.autore1 = autore1;
		this.autore2 = autore2;
	}
	public int getAutore1() {
		return autore1;
	}
	public void setAutore1(int autore1) {
		this.autore1 = autore1;
	}
	public int getAutore2() {
		return autore2;
	}
	public void setAutore2(int autore2) {
		this.autore2 = autore2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + autore1;
		result = prime * result + autore2;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Collaborazione other = (Collaborazione) obj;
		if (autore1 != other.autore1)
			return false;
		if (autore2 != other.autore2)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Collaborazione [autore1=" + autore1 + ", autore2=" + autore2 + "]";
	}
	
}
