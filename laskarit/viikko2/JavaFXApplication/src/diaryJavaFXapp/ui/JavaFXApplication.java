/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diaryJavaFXapp.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author svsv
 */
public class JavaFXApplication extends Application {
    
    @Override
    public void start(Stage ikkuna) {
  Henkilovarasto henkilovarasto = new Henkilovarasto();  
  
//    Label nimiTeksti = new Label("Username: ");
//    TextField nimiKentta = new TextField();
//    Label PasswordText = new Label("Password: ");
//    TextField PasswordField = new TextField();
//    
//    Button lisaaNappi = new Button("Create!");
//     lisaaNappi.setOnAction((event) -> {
//            Henkilo lisattava = new Henkilo(nimiTeksti.getText(), PasswordText.getText());
//            henkilovarasto.talleta(new Henkilo(lisattava));
//        });
//    
//
//    GridPane komponenttiryhma = new GridPane();
//    komponenttiryhma.add(nimiTeksti, 0, 0);
//    komponenttiryhma.add(nimiKentta, 1, 0);
//    komponenttiryhma.add(PasswordText, 0, 1);
//    komponenttiryhma.add(PasswordField, 1, 1);
//    komponenttiryhma.add(lisaaNappi, 1, 2);
//
//    // tyylittelyä: lisätään tyhjää tilaa reunoille ym
//    komponenttiryhma.setHgap(10);
//    komponenttiryhma.setVgap(10);
//    komponenttiryhma.setPadding(new Insets(10, 10, 10, 10));
//
//    Scene nakyma = new Scene(komponenttiryhma);
//
//    ikkuna.setScene(nakyma);
//    ikkuna.show();
//
//      
//}  
// 
    /**
     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(JavaFXApplication.class);
//    
}   

      
     
}     
    
    
    
    
    
    
    
    
    
    
    
    
//    @Override
//    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
//    
//}
