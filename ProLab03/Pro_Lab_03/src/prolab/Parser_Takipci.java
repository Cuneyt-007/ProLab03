package prolab;



	import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import prolab.Kullanici.t_e_hash;
import prolab.Kullanici.user;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

	public class Parser_Takipci {


		
		 public void parserTakipci() {
			 
			 	
				
			    try {
			    	
			    	String desktopPath = System.getProperty("user.home") + "/Desktop";
			        String jsonFilePath = desktopPath + "/twitter_data.json";
			    	
			        // Jackson ObjectMapper oluþtur
			        ObjectMapper objectMapper = new ObjectMapper();

			        // JSON dosyasýný oku
			        File jsonFile = new File(jsonFilePath);
			        JsonNode userArray = objectMapper.readTree(jsonFile);
			        
			        Kullanici kullanici = new Kullanici();
			        Kullanici.tak_hash tak_hash2 = kullanici.new tak_hash();
			       
			        int i=1;
			        // Her bir kullanýcý için bilgileri iþle
			        for (JsonNode userNode : userArray) {
			        	
			        	StringBuilder birlestir = new StringBuilder();
			            
			        	String username = userNode.get("username").asText();
			            String name = userNode.get("name").asText();
			            int followersCount = userNode.get("followers_count").asInt();
			            int followingCount = userNode.get("following_count").asInt();
			            String Dil = userNode.get("language").asText();
			            String bolge = userNode.get("region").asText();
			            
			            Kullanici kullanici1 = new Kullanici(username, name, Dil, bolge, followersCount, followingCount);
		                Kullanici.user user = kullanici.new user();
		                user.user_hash.put(i,username);
		                
		                

			            
			            JsonNode followersArray = userNode.get("followers");
			            if (followersArray.isArray()) {
			                for (JsonNode followerNode : followersArray) {  
			                	birlestir.append(followerNode).append("\n");
			                }

			            }
			            
			            tak_hash2.tak_hash.put(i, birlestir.toString());
		                i++;
		            
		            birlestir.setLength(0);
			              
			        }
			        
			        System.out.println(tak_hash2.tak_hash.get(10000).toString());
			        
			    } 
			    catch (IOException e) {
			         e.printStackTrace();
			     }
			    
				 }

	}



