package com.fr.ensim.archiLog.TpNote.Controller;

import java.net.URI;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;


import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fr.ensim.archiLog.TpNote.Metier.Garantie;
import com.fr.ensim.archiLog.TpNote.Metier.GarantieMetierImpl;



@RestController
public class GarantieRestController {
	
	private GarantieMetierImpl metier;
	
	// Simulation d'un séquenceur pour générer l'identifiant des garanties
    private AtomicInteger fakeSeq = new AtomicInteger(0);
    
    public GarantieRestController() {
		metier = new GarantieMetierImpl();
	}
    
    @GetMapping("/api/garantie")
	public List<Garantie> listerGaranties(){
    	System.out.println("lister All success");
		return metier.listerGaranties();
	}
    
    @GetMapping("/api/garantie/{id}")
    public ResponseEntity<Garantie> recupererGarantie(@PathVariable("id") int gid){
    	
    	Garantie g = metier.listerGaranties().get(gid);
    	
    	return ResponseEntity.ok().body(g);
    }
    
    
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Garantie> ajouterGarantie(@RequestBody Garantie g) {
    	
		g.setId(fakeSeq.incrementAndGet()-1);
		// URI de localisation de la ressource
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(g.getId());
        
        metier.ajouterGarantie(g);
        System.out.println("Add success");

        // réponse 201 avec la localisation et la ressource créée
        return ResponseEntity.created(location).body(g);
		
	}
    
    @DeleteMapping("/api/garantie/{id}")
	public  ResponseEntity<Garantie> supprimerGarantie(@PathVariable("id") @NonNull long gId) {
		metier.supprimerGarantie(gId);
		System.out.println("Delete success");
		return ResponseEntity.noContent().build();
	}
    
    @PutMapping("/api/garantie/{id}")
	public ResponseEntity<Garantie> modifierGarantie(@PathVariable("id") int gid, @RequestBody Garantie g) {
		
        
        metier.modifierGarantie(g);

        // réponse 201 
        return ResponseEntity.ok().body(g);
	}

}
