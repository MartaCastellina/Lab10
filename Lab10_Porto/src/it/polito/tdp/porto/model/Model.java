package it.polito.tdp.porto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.alg.NeighborIndex;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;

import org.jgrapht.graph.Multigraph;

import it.polito.tdp.porto.db.PortoDAO;



public class Model {
	Graph<Author, DefaultEdge> grafo;
	PortoDAO dao;
	List <Author> autori;
	AuthorIdMap mappaAutori ;
	
	public Model() {
		dao=new PortoDAO();
		mappaAutori=new AuthorIdMap();
		autori=dao.getAllAutori(mappaAutori);
		this.grafo=new Multigraph<>(DefaultEdge.class);
	}
	public List <Author> getCoautori(Author a){
		List <Author> listAutori=dao.getAllAutori(mappaAutori);
		Graphs.addAllVertices(grafo, autori);
		List <Collaborazione> collaborazioni=dao.getCollaborazioni();
		for (Collaborazione c:collaborazioni) {
			Author a1=mappaAutori.get(c.getAutore1());
			Author a2=mappaAutori.get(c.getAutore2());
			grafo.addEdge(a1,a2);
		}
		List <Author> coautori=new ArrayList<Author>();
		
		for(Author co:Graphs.neighborListOf(grafo, a)) {
			if (!coautori.contains(a.getId())) {
				coautori.add(co);
			}
		}
		
		return coautori;
	}
	

	public List <Author> getAutori(){
		List <Author> autori= dao.getAllAutori(mappaAutori);
		return autori;
	}
	public List<Paper> getPapers(Author a, Author a2) {
		List<Author> camminoMinimo;

		return null;
	}
	
public List<Author> getShortestPath(int id1, int id2) {
		
	Author source=mappaAutori.get(id1);
	Author destination =mappaAutori.get(id2);
	
		
		System.out.println(source);
		System.out.println(destination);
		
		if (source == null || destination == null) {
			throw new RuntimeException("Gli areoporti selezionati non sono presenti in memoria");
		}
		
		ShortestPathAlgorithm<Author,DefaultEdge> spa = new DijkstraShortestPath<Author, DefaultEdge>(grafo);
		double weight = spa.getPathWeight(source, destination);
		System.out.println(weight);
		
		GraphPath<Author,DefaultEdge> gp = spa.getPath(source, destination);
		
		return gp.getVertexList();
	}
}
