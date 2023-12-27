package prolab;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser_Dil {
	
	 public void parserDil() {
		 
		    int i=0;
		    try {
		    	
		    	String desktopPath = System.getProperty("user.home") + "/Desktop";
		        String jsonFilePath = desktopPath + "/data.json";
		    	
		        // Jackson ObjectMapper oluþtur
		        ObjectMapper objectMapper = new ObjectMapper();

		        // JSON dosyasýný oku
		        File jsonFile = new File(jsonFilePath);
		        JsonNode userArray = objectMapper.readTree(jsonFile);

		        // Her bir kullanýcý için bilgileri iþle
		        for (JsonNode userNode : userArray) {
		            String username = userNode.get("username").asText();
		            String name = userNode.get("name").asText();
		            int followersCount = userNode.get("followers_count").asInt();
		            int followingCount = userNode.get("following_count").asInt();
		            String Dil = userNode.get("language").asText();
		            String bolge = userNode.get("region").asText();
		           
		            System.out.println("Kullanýcý Adý: " + username);
	                System.out.println("Adý: " + name);
	                System.out.println(Dil);
	                Kullanici kullanici = new Kullanici(username, name, Dil, bolge, followersCount, followingCount);
	                Kullanici.dil_hash dil2_hash = kullanici.new dil_hash();
	                dil2_hash.dil_hash.put(i, bolge);
	                i++;

		            System.out.println(); // Kullanýcýlar arasýna boþluk býrak
		        }
		        

		    } 
		    catch (IOException e) {
		         e.printStackTrace();
		     }
		    
			 }

}
