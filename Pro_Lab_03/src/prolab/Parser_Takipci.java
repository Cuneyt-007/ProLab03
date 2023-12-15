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
			 
			 Kullanici[] user = new Kullanici[10000];
				
				for(int j=0;j<10000;j++)
				{
					user[j] = new Kullanici();
					user[j].takipci_hash = new Hashtable<>();
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

			            
			            JsonNode followersArray = userNode.get("followers");
			            if (followersArray.isArray()) {
			            	int k=0;
			                for (JsonNode followerNode : followersArray) {  
			                	user[i].takipci_hash.put(k, followerNode);
			                	k++;
			                }
			                i++;
			            }
			            
			            for (int userIndex = 0; userIndex < i; userIndex++) {
			                System.out.println("User : " + userIndex + "\n Takipçileri:");
			                for (int followerIndex = 0; followerIndex < user[userIndex].takipci_hash.size(); followerIndex++) {
			                    System.out.println(user[userIndex].takipci_hash.get(followerIndex));
			                }
			                System.out.println();
			            }
			            

			            System.out.println(); // Kullanýcýlar arasýna boþluk býrak
			        }
			        

			    } 
			    catch (IOException e) {
			         e.printStackTrace();
			     }
			    
				 }

	}



