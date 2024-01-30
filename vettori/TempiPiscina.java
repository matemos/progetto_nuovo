package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Insets;

public class TempiPiscina extends Application {

	int tempi[];
	int c = 0;
	int x = 0;
	
	double media = 0.0;
	
	TextField tNum = new TextField();
	TextField tTempo = new TextField();
	
	Label lTempi = new Label("tempi");
	Label lMedia = new Label("media");
	
	Label lMag = new Label("maggiori");
	Label lMin = new Label("minori");
	
	Button pAlloca = new Button("Alloca");
	
	public void start(Stage stage) {
		
		GridPane grid = new GridPane();
		
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		pAlloca.setOnAction(e -> alloca());
		
		Button pInserisci = new Button("Inserisci");
		pInserisci.setOnAction(e -> inserisci());
		
		Button pStampa = new Button("Stampa");
		pStampa.setOnAction(e -> stampa());
		
		Button pCalcola = new Button("Calcola");
		pCalcola.setOnAction(e -> calcola());
		
		grid.add(tNum, 0, 0, 3, 1);
		grid.add(new Label("n. tempi"), 3, 0);
		
		grid.add(tTempo, 0, 1, 3, 1);
		grid.add(new Label("tempo"), 3, 1);
		
		grid.add(pAlloca, 0, 2);
		grid.add(pInserisci, 1, 2);
		grid.add(pStampa, 2, 2);
		
		grid.add(lTempi, 0, 3, 3, 1);
		
		grid.add(lMedia, 0, 4, 3, 1);
		
		grid.add(pCalcola, 0, 5);
		grid.add(lMag, 0, 6);
		grid.add(lMin, 1, 6);
		
		Scene scene = new Scene(grid);
		
		stage.setScene(scene);
		stage.setTitle("Tempi piscina");
		stage.show();
	}
	
	private void alloca() {
		tempi = new int[Integer.parseInt(tNum.getText())];
		x = tempi.length;
		pAlloca.setText("" + x);
	}
	
	private void inserisci() {
		if (c < tempi.length) {
			tempi[c] = Integer.parseInt(tTempo.getText());
		
			tTempo.setText("");
			x--;
			pAlloca.setText("" + x);
			c++;
		}
	}
	
	private void stampa() {
		String s = "";
		int sum = 0;
		
		for (int i = 0; i < tempi.length; i++) {
			int t = tempi[i];
			
			String sp = "";
			
			if (i < tempi.length-1) {
				sp = "-";
			}
			s += t+sp;
			sum += tempi[i];
		}
		
		media = sum/tempi.length;
		
		lTempi.setText(s);
		lMedia.setText("media: " + media);
	}
	
	private void calcola() {
		for (int i = 0; i < tempi.length; i++) {
			int n = tempi[i];
			if (n > media) {
				lMag.setText(lMag.getText() + " " + n);
			} else {
				lMin.setText(lMin.getText() + " " + n);
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
