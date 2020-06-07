package com.fr.ensim.archiLog.TpNote.Metier;

import java.util.List;

public interface IGarantieMetier {
	
	public Garantie ajouterGarantie(Garantie g);
	public boolean supprimerGarantie(long gId);
	public Garantie modifierGarantie(Garantie g);
	public List<Garantie> listerGaranties();

}
