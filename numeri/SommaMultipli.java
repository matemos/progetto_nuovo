package it.edu.iisgubbio.vettori;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;

public class SommaMultipli extends Application {

	TextField tNum = new TextField();
	TextField tNMax = new TextField();
	
	Label lNums = new Label("");
	Label lRis = new Label("ris");
	
	int[] numeri;
	
	public void start(Stage stage) {
		
		GridPane grid = new GridPane();
		
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		tNum.setMaxWidth(65);
		tNMax.setMaxWidth(65);
		
		Button pGenera = new Button("Genera");
		pGenera.setOnAction(e -> genera());
		
		Button pCalcola = new Button("calcola");
		pCalcola.setOnAction(e -> calcola());
		
		
		
		grid.add(tNum, 0, 0);
		grid.add(new Label("n. elementi"), 1, 0);
		
		grid.add(tNMax, 0, 1);
		grid.add(new Label("n. max"), 1, 1);
		
		grid.add(pGenera, 0, 2);
		grid.add(pCalcola, 1, 2);
		
		grid.add(lNums, 0, 3, 2, 1);
		
		grid.add(lRis, 0, 4);
		
		
		
		Scene scene = new Scene(grid);
		
		stage.setScene(scene);
		stage.setTitle("Somma Multipli");
		stage.show();
		
	}
	
	private void genera() {
		int n, nMax;
		n = Integer.parseInt(tNum.getText());
		nMax = Integer.parseInt(tNMax.getText());
	
		numeri = new int[n];
		
		for (int i = 0; i < n; i++) {
			int num = (int) (Math.random()*nMax);
			if (num > 0) {
				numeri[i] = num;
				lNums.setText(lNums.getText() + " " + num);
			} else { i--; }
			
		}
		
	}
	
	private void calcola() {
		
		int ris = 0;
		
		for (int i = 0; i < numeri.length; i++) {
			if (numeri[i]%3 == 0) {
				ris+=numeri[i];
			}
			
		}
		lRis.setText("risultato: " + ris);
		
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
