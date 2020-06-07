package com.fr.ensim.archiLog.TpNote.Metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GarantieMetierImpl implements IGarantieMetier {
	
	private Map<Long, Garantie> listGaranties = new HashMap<Long, Garantie>();

	@Override
	public Garantie ajouterGarantie(Garantie g) {
		listGaranties.put(g.getId(), g);
		return g;
	}

	@Override
	public boolean supprimerGarantie(long gId) {
		if(listGaranties.get(gId)!=null) {
			listGaranties.remove(gId);
			return true;
		}
		else throw new RuntimeException("Garantie introuvable");
	}

	@Override
	public List<Garantie> listerGaranties() {
		List<Garantie> garanties = new ArrayList<Garantie>();
		for(Garantie p : listGaranties.values()) {
			garanties.add(p);
		}
		return garanties;
	}

	@Override
	public Garantie modifierGarantie(Garantie g) {
		Garantie g_avant = listGaranties.get(g.getId());
		if(g_avant == null) {
			throw new RuntimeException("Garantie a modifier introuvable");
		}
		else {
			listGaranties.remove(g.getId());
			listGaranties.put(g.getId(), g);
		}
		return g;
	}

}
