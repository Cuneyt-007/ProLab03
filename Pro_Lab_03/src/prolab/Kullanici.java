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
	public Hashtable<Integer,JsonNode> takipEdilen_hash;
	public Hashtable<Integer,JsonNode> takipci_hash;
	public Hashtable<Integer,JsonNode> tweet_hash;
	public Hashtable<Integer,String> bolge_hash;
	public Hashtable<Integer,String> dil_hash;
	
	public Kullanici(){
		takipEdilen_hash = new Hashtable<>();
		takipci_hash = new Hashtable<>();
	}

	 public Kullanici(String k_adi, String ad_soyad, String dil, String bölge, int takipci_sayisi, int takip_edilen_sayisi){
		
		this.ad_soyad = ad_soyad;
		this.k_adi = k_adi;
		this.dil = dil;
		this.bölge = bölge;
		this.takip_edilen_sayisi = takip_edilen_sayisi;
		this.takipci_sayisi = takipci_sayisi;
		
	} 
	
	 
		
	


}
