package prolab;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser_Bolge {
	
	public void parserBolge() {
		
		Kullanici[] user = new Kullanici[10000];
		
		for(int j=0;j<10000;j++)
		{
			user[j] = new Kullanici();
			user[j].bolge_hash = new Hashtable<>();
		}
	 
		int i=0;
		
	    try {
	    	
	    	String desktopPath = System.getProperty("user.home") + "/Desktop";
	        String jsonFilePath = desktopPath + "/twitter_data.json";
	    	
	        // Jackson ObjectMapper olu�tur
	        ObjectMapper objectMapper = new ObjectMapper();

	        // JSON dosyas�n� oku
	        File jsonFile = new File(jsonFilePath);
	        JsonNode userArray = objectMapper.readTree(jsonFile);

	        // Her bir kullan�c� i�in bilgileri i�le
	        for (JsonNode userNode : userArray) {
	            String username = userNode.get("username").asText();
	            String name = userNode.get("name").asText();
	            int followersCount = userNode.get("followers_count").asInt();
	            int followingCount = userNode.get("following_count").asInt();
	            String bolge = userNode.get("region").asText();
	            		

	            System.out.println("Kullanici Adi: " + username);
        
	            user[i].bolge_hash.put(i, bolge);
	            System.out.println(user[i].bolge_hash.get(i));
	            i++;

	            System.out.println(); // Kullan�c�lar aras�na bo�luk b�rak
	        }
	        

	    } 
	    catch (IOException e) {
	         e.printStackTrace();
	     }
	    
		 }

}
