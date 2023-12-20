package prolab;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser_Tweet {
	
	 public void parserTweet() {
		 

		    try {
		    	
		    	String desktopPath = System.getProperty("user.home") + "/Desktop";
		        String jsonFilePath = desktopPath + "/data.json";
		    	
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

		            System.out.println("Kullan�c� Ad�: " + username);
	                System.out.println("Ad�: " + name);

		            JsonNode tweetsArray = userNode.get("tweets");
		            if (tweetsArray.isArray()) {
		               
		                for (JsonNode tweetNode : tweetsArray) {
		                    System.out.println(tweetNode);
		                }
		               
		            }          

		            System.out.println(); // Kullan�c�lar aras�na bo�luk b�rak
		        }
		        

		    } 
		    catch (IOException e) {
		         e.printStackTrace();
		     }
		    
			 }

}
