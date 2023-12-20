package prolab;


import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    
    public static void main(String[] args) {
        
    	Parser_TakipEdilen sa = new Parser_TakipEdilen();
    	sa.parserTakipEdilen();
    	
    	/*CustomHashMap<Integer, Integer> hash = new CustomHashMap<>();
    	hash.put(1, 1);
    	System.out.println(hash.get(1));*/
    	
    }
}

