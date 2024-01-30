package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;

public class MaggioreK extends Application {

	TextField tNum = new TextField();
	TextField tK = new TextField();
	
	Label lRis = new Label("ris");
	
	public void start(Stage stage) {
		
		GridPane grid = new GridPane();
		
		grid.setHgap(7);
		grid.setVgap(7);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		Button pEsegui = new Button("esegui");
		pEsegui.setOnAction(e -> esegui());
		
		grid.add(tNum, 0, 0);
		grid.add(tK, 0, 1);
		grid.add(pEsegui, 0, 2);
		grid.add(lRis, 0, 3);
		
		Scene scene = new Scene(grid);
		stage.setScene(scene);
		stage.setTitle("K Maggiore");
		stage.show();
		
	}
	
	private void esegui() {
		String numStr[] = tNum.getText().split(",");
		int k = Integer.parseInt(tK.getText());
		
		String ris = new String("");
		
		for (int i = 0; i < numStr.length; i++) {
			if (Integer.parseInt(numStr[i]) > k) {
				ris+=" "+numStr[i];
			}
		}
		
		lRis.setText(ris);

	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
