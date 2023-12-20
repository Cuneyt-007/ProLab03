package prolab;

import java.util.Hashtable;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

public class Kullanici {
	
	public String k_adi;
	public String ad_soyad;
	public String dil;
	public String bölge;
	public int takipci_sayisi;
	public int takip_edilen_sayisi;
	public String tweets;
	public JsonNode takipciler;
	
	public Kullanici()
	{
		
	}
	
	 public Kullanici(String k_adi, String ad_soyad, String dil, String bölge, int takipci_sayisi, int takip_edilen_sayisi){
		
		this.ad_soyad = ad_soyad;
		this.k_adi = k_adi;
		this.dil = dil;
		this.bölge = bölge;
		this.takip_edilen_sayisi = takip_edilen_sayisi;
		this.takipci_sayisi = takipci_sayisi;
		
	} 
	 
	public class user
	{
		CustomHashMap<Integer, String> user_hash = new CustomHashMap<>();
	}
	 
	 
	public class t_e_hash
	{
		CustomHashMap<Integer, JsonNode> t_e_hash = new CustomHashMap<>();
	}
	 
	public class tak_hash
	{
		CustomHashMap<Integer, JsonNode> tak_hash = new CustomHashMap<>();
	}
	
	public class tweet_hash
	{
		CustomHashMap<Integer, JsonNode> tweet_hash = new CustomHashMap<>();
	}
	
	public class bolge_hash
	{
		CustomHashMap<Integer, String> bolge_hash = new CustomHashMap<>();
	}
	
	public class dil_hash
	{
		CustomHashMap<Integer, String> dil_hash = new CustomHashMap<>();
	}
	 
}		
	



