package prolab;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser_Tweet {
	
	 public void parserTweet() {
		 
		 Kullanici[] user = new Kullanici[10000];
			
			for(int j=0;j<10000;j++)
			{
				user[j] = new Kullanici();
				user[j].tweet_hash = new Hashtable<>();
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


		              JsonNode tweetsArray = userNode.get("tweets");
		            
		            if (tweetsArray.isArray()) {
		               int k=0;
		                for (JsonNode tweetNode : tweetsArray) {
		                    user[i].tweet_hash.put(k, tweetNode);
		                    k++;
		                }
		                i++;
		            }
		            
		            for (int userIndex = 0; userIndex < i; userIndex++) {
		                System.out.println("User : " + userIndex + "\n Tweetleri:");
		                for (int tweetIndex = 0; tweetIndex < user[userIndex].tweet_hash.size(); tweetIndex++) {
		                    System.out.println(user[userIndex].tweet_hash.get(tweetIndex));
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
