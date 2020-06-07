package com.fr.ensim.archiLog.TpNote.Client;

import java.net.URISyntaxException;

import java.io.IOException;
import java.net.URI;
import java.util.Base64;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.fr.ensim.archiLog.TpNote.Metier.Garantie;



public class ClientRestGarantie {
	public static void main(String[] args) throws URISyntaxException {
		// Client REST fourni par le framework Spring
				RestTemplate restTemplate = new RestTemplate();
				
				final String baseUrl = "http://localhost:8080";
				 URI uri = new URI(baseUrl);
				 
				Garantie garantie_1 = new Garantie("ma première garantie", 200, "ma description de ma première garantie");
				
				ResponseEntity<String> result = restTemplate.postForEntity(uri, garantie_1, String.class);
				
				//Verify request succeed
			    System.out.println("le code retour est : "+ result.getStatusCodeValue());
			    
			    Garantie garantie_2 = new Garantie("ma deuxieme garantie", 10000, "ma description de ma deuxieme garantie");
			    
			    result = restTemplate.postForEntity(uri, garantie_2, String.class);
				
				//Verify request succeed
			    System.out.println("le code retour est : "+ result.getStatusCodeValue());
			    
			    Garantie garantie_3 = new Garantie("ma troisieme garantie", 400, "ma description de ma troisième garantie");
			    
			    result = restTemplate.postForEntity(uri, garantie_3, String.class);
				
				//Verify request succeed
			    System.out.println("le code retour est : "+ result.getStatusCodeValue());
			    
			    //show a garantie
			    
			    Garantie garantie_get = restTemplate.getForObject(uri + "/api/garantie/1", Garantie.class);
			    System.out.println("garantie recupérée est : " + garantie_get);
			    
			    //update a garantie
			    
			    Garantie garantie_update = new Garantie(1,"ma garantie modifiee", 40000, "ma description de ma garantie modifiee");
			    
			    restTemplate.put(uri + "/api/garantie/1", garantie_update);
			    
			    //delete a garantie
			    
			    restTemplate.delete(uri+ "/api/garantie/2");
			    
			    
				 
		
	}

}
