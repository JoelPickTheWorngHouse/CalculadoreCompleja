package dad.CalculadoraCompleja;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App  extends Application{

	TextField aReal;
	TextField bImaginaria;
	TextField cReal;
	TextField dImaginaria;
	
	ComboBox selector;
	Button igual;
	
	TextField resultado1;
	TextField resultado2;
	
	Separator s2;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 1º HBox 
		aReal=new TextField();
		aReal.setPrefColumnCount(4);
		aReal.setText("0");
		
		
		bImaginaria=new TextField();
		bImaginaria.setPrefColumnCount(4);
		bImaginaria.setText("0");
		
		HBox h1=new HBox(5,aReal,new Label(" + "),bImaginaria,new Label("i"));
		
		// 2º HBox
		cReal=new TextField();
		cReal.setPrefColumnCount(4);
		cReal.setText("0");
		
		dImaginaria=new TextField();
		dImaginaria.setPrefColumnCount(4);
		dImaginaria.setText("0");
		
		HBox h2=new HBox(5,cReal,new Label(" + "),dImaginaria,new Label("i"));
		
		s2=new Separator();
		
		// 3º HBox
		resultado1=new TextField();
		resultado1.setPrefColumnCount(4);
		resultado1.setText("0");
		resultado1.setEditable(false);
		
		resultado2=new TextField();
		resultado2.setPrefColumnCount(4);
		resultado2.setText("0");
		resultado2.setEditable(false);
		
		HBox h3=new HBox(5,resultado1,new Label(" + "),resultado2,new Label("i"));
		
		VBox sectorCentro=new VBox(h1,h2,s2,h3);
		sectorCentro.setAlignment(Pos.CENTER);
		sectorCentro.setSpacing(7);
		
		// Otros
		selector=new ComboBox();
		selector.getItems().addAll("+","-","*","/");
		selector.getSelectionModel().selectFirst();
		
		VBox sectorIzq=new VBox(selector);
		sectorIzq.setAlignment(Pos.CENTER);
		
		
		igual=new Button("=");
		igual.setOnAction(e ->Calculo(e));
		
		VBox sectorDerc=new VBox(igual);
		sectorDerc.setAlignment(Pos.CENTER);
		
		
		HBox finalChampio= new HBox(sectorIzq,sectorCentro,sectorDerc);
		finalChampio.setAlignment(Pos.CENTER);
		
		Scene scene=new Scene(finalChampio,320,200);
		primaryStage.setTitle("Calculadora Compleja");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private void  Calculo(ActionEvent e) {
		switch (selector.getValue().toString()) {
		case "+":
			try {
			double a=Double.parseDouble(aReal.getText())+Double.parseDouble(cReal.getText());
			double b=Double.parseDouble(bImaginaria.getText())+Double.parseDouble(dImaginaria.getText());
			
			String cad1=Double.toString(a);
			resultado1.setText(cad1);
			String cad2=Double.toString(b);
			resultado2.setText(cad2);
			
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
			break;
		case "-":
			try {
				double a=Double.parseDouble(aReal.getText())-Double.parseDouble(cReal.getText());
				double b=Double.parseDouble(bImaginaria.getText())-Double.parseDouble(dImaginaria.getText());
				
				String cad1=Double.toString(a);
				resultado1.setText(cad1);
				String cad2=Double.toString(b);
				resultado2.setText(cad2);
				
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			break;
		case "*":					
			try {
									//(a*c)-(b*c)
			
			double a=(Double.parseDouble(aReal.getText())*Double.parseDouble(cReal.getText())-(Double.parseDouble(bImaginaria.getText())*Double.parseDouble(dImaginaria.getText())));
									
									//(a*d)+(b*c)
			double b=(Double.parseDouble(aReal.getText())*Double.parseDouble(dImaginaria.getText())+(Double.parseDouble(bImaginaria.getText())*Double.parseDouble(cReal.getText())));
			
			String cad1=Double.toString(a);
			resultado1.setText(cad1);
			String cad2=Double.toString(b);
			resultado2.setText(cad2);
			
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/":
			try {
			double a=(Double.parseDouble(aReal.getText())*Double.parseDouble(cReal.getText())+(Double.parseDouble(bImaginaria.getText())*Double.parseDouble(dImaginaria.getText())))/((Double.parseDouble(cReal.getText())*Double.parseDouble(cReal.getText()))+(Double.parseDouble(dImaginaria.getText())*Double.parseDouble(dImaginaria.getText())));
			
			double b=(Double.parseDouble(bImaginaria.getText())*Double.parseDouble(cReal.getText())-(Double.parseDouble(aReal.getText())*Double.parseDouble(dImaginaria.getText())))/((Double.parseDouble(cReal.getText())*Double.parseDouble(cReal.getText()))+(Double.parseDouble(dImaginaria.getText())*Double.parseDouble(dImaginaria.getText())));;
			
			String cad1=Double.toString(a);
			resultado1.setText(cad1);
			String cad2=Double.toString(b);
			resultado2.setText(cad2);
			
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			break;
		}
		
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
