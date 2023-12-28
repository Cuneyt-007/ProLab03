package prolab;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser_TakipEdilen extends Kullanici {
	
	

	 public static void parserTakipEdilen() {
	 		 
	    try {
	    	
	    	String desktopPath = System.getProperty("user.home") + "/Desktop";
	        String jsonFilePath = desktopPath + "/twitter_data.json";
	    	
	        ObjectMapper objectMapper = new ObjectMapper();

	        File jsonFile = new File(jsonFilePath);
	        JsonNode userArray = objectMapper.readTree(jsonFile);
	   
	        int i=1;
	        
	        Kullanici kullanici = new Kullanici();
            Kullanici.t_e_hash t_e_hash2 = kullanici.new t_e_hash();
	        
	        for (JsonNode userNode : userArray) {
	        	
	        	
	        	
	        	String username = userNode.get("username").asText();
	            String name = userNode.get("name").asText();
	            int followersCount = userNode.get("followers_count").asInt();
	            int followingCount = userNode.get("following_count").asInt();
	            String Dil = userNode.get("language").asText();
	            String bolge = userNode.get("region").asText();
                
                Kullanici kullanici1 = new Kullanici(username, name, Dil, bolge, followersCount, followingCount);
                Kullanici.user user = kullanici1.new user();
                user.user_hash.put(i,username);  
                StringBuilder birlestir = new StringBuilder();
                
                
	            JsonNode followingArray = userNode.get("following");
	            if (followingArray.isArray()) {
	                for (JsonNode followingNode : followingArray) {
	                	birlestir.append(followingNode).append("\n");
	                	
	                } 
        
	            } 

	              t_e_hash2.t_e_hash.put(i, birlestir.toString());

	            i++;
	            
	            birlestir.setLength(0);
	            
	        	}
	        System.out.println(t_e_hash2.t_e_hash.get(2));
	        
	    } 
	    catch (IOException e) {
	         e.printStackTrace();
	     }
	    
		 }
	
	
	
}