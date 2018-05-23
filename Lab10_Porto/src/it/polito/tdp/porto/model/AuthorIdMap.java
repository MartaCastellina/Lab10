package it.polito.tdp.porto.model;

import java.util.HashMap;
import java.util.Map;

public class AuthorIdMap {

	private Map <Integer, Author> map;
	
	public AuthorIdMap() {
		map=new HashMap<>();
	}
	public Author get(int code) {
	return map.get(code);
	}
	public Author get (Author autore) {
		Author old=map.get(autore.getId());
		if(old==null) {
			map.put(autore.getId(), autore);
			return autore;
		}
		return old;
		
	}
	public void put (Author autore, int id) {
		map.put(id,autore);
	}
}

