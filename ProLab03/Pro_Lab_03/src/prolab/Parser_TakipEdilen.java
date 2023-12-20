package prolab;


import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser_TakipEdilen extends Kullanici {
	

	 public static void parserTakipEdilen() {
		 
		/* for(int i=0;i<50000;i++)
		 {
			 Kullanici kullanici = new Kullanici();
			 Kullanici.user user = kullanici.new user();
			 
 
		 } */
		 
		 		 
	    try {
	    	
	    	String desktopPath = System.getProperty("user.home") + "/Desktop";
	        String jsonFilePath = desktopPath + "/data.json";
	    	
	        // Jackson ObjectMapper oluþtur
	        ObjectMapper objectMapper = new ObjectMapper();

	        // JSON dosyasýný oku
	        File jsonFile = new File(jsonFilePath);
	        JsonNode userArray = objectMapper.readTree(jsonFile);
	        
	       
	        // Her bir kullanýcý için bilgileri iþle
	        int i=0;
	        for (JsonNode userNode : userArray) {
	        	
	        	String username = userNode.get("username").asText();
	            String name = userNode.get("name").asText();
	            int followersCount = userNode.get("followers_count").asInt();
	            int followingCount = userNode.get("following_count").asInt();
	            String Dil = userNode.get("language").asText();
	            String bolge = userNode.get("region").asText();
	            
	           // System.out.println("Kullanýcý Adý: " + username);
               // System.out.println("Adý: " + name);
                
                Kullanici kullanici = new Kullanici(username, name, Dil, bolge, followersCount, followingCount);
                Kullanici.user user = kullanici.new user();
                user.user_hash.put(i,username);
                Kullanici.t_e_hash t_e_hash2 = kullanici.new t_e_hash();
 
	            JsonNode followingArray = userNode.get("following");
	            if (followingArray.isArray()) {
	                int k=0;
	                for (JsonNode followingNode : followingArray) {
	                	
	                	//System.out.println(followingNode);
	                	t_e_hash2.t_e_hash.put(k, followingNode);
	                	k++;

	                } 
	      
	            } 
	           
	            i++;
	            
	            
	            

	            System.out.println(); // Kullanýcýlar arasýna boþluk býrak
	        	}
  

	    } 
	    catch (IOException e) {
	         e.printStackTrace();
	     }
	    
		 }
	
	
	
}
