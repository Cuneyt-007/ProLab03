package prolab;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser_Dil {
	
	 public void parserDil() {
		 
		 Kullanici[] user = new Kullanici[10000];
			
			for(int j=0;j<10000;j++)
			{
				user[j] = new Kullanici();
				user[j].dil_hash = new Hashtable<>();
			}
		 
			int i=0;
		 
		    try {
		    	
		    	String desktopPath = System.getProperty("user.home") + "/Desktop";
		        String jsonFilePath = desktopPath + "/twitter_data.json";
		    	
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
		           
		            
		            System.out.println("Kullanici Adi: " + username);
		            
		            user[i].dil_hash.put(i, Dil);
		            System.out.println(user[i].dil_hash.get(i));
		        i++;

		            System.out.println(); // Kullanýcýlar arasýna boþluk býrak
		        }
		        

		    } 
		    catch (IOException e) {
		         e.printStackTrace();
		     }
		    
			 }

}
