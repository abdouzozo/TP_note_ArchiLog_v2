package com.fr.ensim.archiLog.TpNote.Metier;


public class Garantie {
	
	private long id;
	private String nom;
	private int montant;
	private String description;
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Garantie(int id, String nom, int montant, String description) {
		
		super();
		this.id = id;
		this.nom = nom;
		this.montant = montant;
		this.description = description;
	}
	
	public Garantie(String nom, int montant, String description) {
		super();
		this.nom = nom;
		this.montant = montant;
		this.description = description;
	}
	public Garantie() {
		super();
	}
	
	 @Override
	    public String toString() {
	        return "Garantie : " +
	                "id = " + id + " : " +
	                " nom = " + nom + " : " +
	                " montant = " + montant + " : " +
	                " description = " + description + " ." 
	                ;
	    }

}
