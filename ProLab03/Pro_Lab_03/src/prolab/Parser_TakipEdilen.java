package prolab;


import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser_TakipEdilen extends Kullanici {
	
	

	 public static void parserTakipEdilen() {
	 		 
	    try {
	    	
	    	String desktopPath = System.getProperty("user.home") + "/Desktop";
	        String jsonFilePath = desktopPath + "/data.json";
	    	
	        ObjectMapper objectMapper = new ObjectMapper();

	        File jsonFile = new File(jsonFilePath);
	        JsonNode userArray = objectMapper.readTree(jsonFile);
	        
	        int i=0;
	        
	        for (JsonNode userNode : userArray) {
	        	
	        	StringBuilder birlestir = new StringBuilder();
	        	
	        	String username = userNode.get("username").asText();
	            String name = userNode.get("name").asText();
	            int followersCount = userNode.get("followers_count").asInt();
	            int followingCount = userNode.get("following_count").asInt();
	            String Dil = userNode.get("language").asText();
	            String bolge = userNode.get("region").asText();
                
                Kullanici kullanici = new Kullanici(username, name, Dil, bolge, followersCount, followingCount);
                Kullanici.user user = kullanici.new user();
                user.user_hash.put(i,username);
                Kullanici.t_e_hash t_e_hash2 = kullanici.new t_e_hash();
                
	            JsonNode followingArray = userNode.get("following");
	            if (followingArray.isArray()) {
	                for (JsonNode followingNode : followingArray) {
	                	birlestir.append(followingNode).append("\n");
	                	
	                } 
        
	            } 
	            
	            t_e_hash2.t_e_hash.put(i, birlestir);
	                i++;
	            
	            System.out.println(user.user_hash.get(i-1)+" Takip Ettigi Kisiler:");
	            System.out.println(t_e_hash2.t_e_hash.get(i-1).toString());
  	            
	            
	            birlestir.setLength(0);
	            
	        	} 

	    } 
	    catch (IOException e) {
	         e.printStackTrace();
	     }
	    
		 }
	
	
	
}