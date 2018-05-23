package it.polito.tdp.porto;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.porto.model.Author;
import it.polito.tdp.porto.model.Model;
import it.polito.tdp.porto.model.Paper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class PortoController {
	private Model model;
	boolean parte1=false;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Author> boxPrimo;

    @FXML
    private ComboBox<Author> boxSecondo;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleCoautori(ActionEvent event) {
    	Author a=boxPrimo.getValue();
    	List <Author> coautori=model.getCoautori(a);
    	List <Author> autoriTot=model.getAutori();
    	if(a==null) {
    		txtResult.setText("Selezionare un autore");
    	}
    	autoriTot.remove(a);
    	for (Author aut:coautori) {
    		
    			autoriTot.remove(aut);
    	}
    	
    	parte1=true;
    	
    }

    @FXML
    void handleSequenza(ActionEvent event) {
    	txtResult.clear();
    	Author a=boxPrimo.getValue();
    	/*List <Author> coautori=model.getCoautori(a);
    	List <Author> autoriTot=model.getAutori();
    	if(a==null) {
    		txtResult.setText("Selezionare un autore");
    	}
    	autoriTot.remove(a);
    	for (Author aut:coautori) {
    		
    			autoriTot.remove(aut);
    	}
    	*/
    	if(parte1==false) {
    		txtResult.setText("Completa la prima parte");;
    		return;
    	}
    	Author a2=boxSecondo.getValue();
    	if(a2==null) {
    		txtResult.setText("Selezionare un autore");
    	}
    	txtResult.appendText("Sequenza di paper che collega "+a+"a "+a2);
    	List <Paper> paper=model.getPapers(a,a2);
    	for (Paper p:paper) {
    		txtResult.appendText(p.toString()+"\n");
    	}
    	
    }

    @FXML
    void initialize() {
        assert boxPrimo != null : "fx:id=\"boxPrimo\" was not injected: check your FXML file 'Porto.fxml'.";
        assert boxSecondo != null : "fx:id=\"boxSecondo\" was not injected: check your FXML file 'Porto.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Porto.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
		boxPrimo.getItems().addAll(model.getAutori());
		boxSecondo.getItems().addAll(model.getAutori());
		
	}
}
