package it.edu.iisgubbio.vettori;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;

public class NumeroMax extends Application {

	TextField tStringa = new TextField();
	
	Label lVoti = new Label();
	Label lRis = new Label();
	
	
	public void start(Stage stage) {
		
		GridPane grid = new GridPane();
		
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		
		Button pEsegui = new Button("Esegui");
		pEsegui.setOnAction(e -> esegui());
		
		Button pReset = new Button("Reset");
		pReset.setOnAction(e -> reset());
		
		grid.add(new Label("Separatore: ,"), 0, 0);
		
		grid.add(tStringa, 0, 1, 2, 1);
		
		grid.add(pEsegui, 0, 2);
		grid.add(pReset, 1, 2);
		
		grid.add(lVoti, 0, 3, 2, 1);
		
		grid.add(lRis, 0, 4, 2 ,1);
		
		Scene scene = new Scene(grid);
		
		stage.setScene(scene);
		stage.setTitle("Indice massimo");
		stage.show();
	}

	private void reset() {
		tStringa.setText("");
		lVoti.setText("");
		lRis.setText("");
	}
	
	private void esegui() {
		String votiStr[] = tStringa.getText().split(",");
		int[] voti = new int[votiStr.length];
		int max = 0;
		int idx = 0;
		
		for (int i = 0; i < voti.length; i++) {
			voti[i] = Integer.parseInt(votiStr[i]);
			lVoti.setText(lVoti.getText() + " " + voti[i]);
			if (voti[i] > max) { max = voti[i]; idx = i; }
			
		}
		lRis.setText(lRis.getText()+" Il massimo è "+ max + " indice: " + idx);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
