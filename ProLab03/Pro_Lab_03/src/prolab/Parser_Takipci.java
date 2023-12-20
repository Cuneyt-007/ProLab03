package prolab;



	import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

	public class Parser_Takipci {


		
		 public void parserTakipci() {
			 
			 
				
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

			            System.out.println("Kullanýcý Adý: " + username);
		                System.out.println("Adý: " + name);
			            
			            JsonNode followersArray = userNode.get("followers");
			            if (followersArray.isArray()) {
			                for (JsonNode followerNode : followersArray) {  
			                	System.out.println(followerNode);
			                }

			            }
			              
			            

			            System.out.println(); // Kullanýcýlar arasýna boþluk býrak
			        }
			        

			    } 
			    catch (IOException e) {
			         e.printStackTrace();
			     }
			    
				 }

	}



