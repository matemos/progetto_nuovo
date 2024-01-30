package it.edu.iisgubbio.vettori;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;

public class StringSplit extends Application {

	TextField tStringa = new TextField();
	
	Label lRis = new Label();
	
	public void start(Stage stage) {
		
		GridPane grid = new GridPane();
		
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		Button pEsegui = new Button("Esegui");
		pEsegui.setOnAction(e -> esegui());
		
		grid.add(tStringa, 0, 0);
		
		grid.add(pEsegui, 0, 1);
		
		grid.add(lRis, 0, 2);
		
		Scene scene = new Scene(grid);
		
		stage.setScene(scene);
		stage.setTitle("String split");
		stage.show();
	}

	
	
	private void esegui() {
		String s=tStringa.getText();
		String votiStr[] = s.split(",");
		int[] voti = new int[votiStr.length];
		int somma=0;
		for (int i = 0; i < voti.length; i++) {
			voti[i] = Integer.parseInt(votiStr[i]);
			lRis.setText(lRis.getText()+ votiStr[i]);
			somma=somma+voti[i];
		}
		lRis.setText(lRis.getText()+" la somma è "+ somma);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
