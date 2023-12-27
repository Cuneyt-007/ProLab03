package prolab;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import prolab.Kullanici.t_e_hash;
import prolab.Kullanici.tweet_hash;
import prolab.Kullanici.user;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser_Tweet {
	
	 public void parserTweet() {
		 

		    try {
		    	
		    	String desktopPath = System.getProperty("user.home") + "/Desktop";
		        String jsonFilePath = desktopPath + "/data.json";
		    	
		        // Jackson ObjectMapper oluþtur
		        ObjectMapper objectMapper = new ObjectMapper();

		        // JSON dosyasýný oku
		        File jsonFile = new File(jsonFilePath);
		        JsonNode userArray = objectMapper.readTree(jsonFile);

		        int i=0;
		        // Her bir kullanýcý için bilgileri iþle
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
	                Kullanici.tweet_hash tweet_hash2 = kullanici.new tweet_hash();

		            JsonNode tweetsArray = userNode.get("tweets");
		            if (tweetsArray.isArray()) {
		               
		                for (JsonNode tweetNode : tweetsArray) {
		                	birlestir.append(tweetNode).append("\n");
		                    
		                }
		               
		            }          

		            tweet_hash2.tweet_hash.put(i, birlestir);
	                i++;
	            
	            System.out.println(user.user_hash.get(i-1)+" Tweetleri:");
	            System.out.println(tweet_hash2.tweet_hash.get(i-1).toString());
	            
	            birlestir.setLength(0);
		        }
		        
		        

		    } 
		    catch (IOException e) {
		         e.printStackTrace();
		     }
		    
			 }

}
