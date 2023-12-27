package prolab;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser_Bolge {
	
	public void parserBolge() {

	 

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
	            		

	            System.out.println("Kullanýcý Adý: " + username);
                System.out.println("Adý: " + name);
                System.out.println(bolge);
                Kullanici kullanici = new Kullanici(username, name, Dil, bolge, followersCount, followingCount);
                Kullanici.bolge_hash bolge2_hash = kullanici.new bolge_hash();
                bolge2_hash.bolge_hash.put(i, bolge);
                i++;
                System.out.println(bolge2_hash.bolge_hash.get(0)); //BURADA ÝSTEDÝÐÝMÝZ KULLANICININ BÖLGESÝNÝ ÇAÐIRIRIZ.
	            System.out.println(); // Kullanýcýlar arasýna boþluk býrak
	        }
	        

	    } 
	    catch (IOException e) {
	         e.printStackTrace();
	     }
	    
		 }

}
