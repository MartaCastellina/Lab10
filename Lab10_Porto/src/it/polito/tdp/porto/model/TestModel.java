package it.polito.tdp.porto.model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		List <Author> autori=new ArrayList<Author>();
		autori=model.getAutori();
		System.out.println(autori);
		
	}

}
