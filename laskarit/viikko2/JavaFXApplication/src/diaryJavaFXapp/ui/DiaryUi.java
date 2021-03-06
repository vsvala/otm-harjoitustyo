/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diaryJavaFXapp.ui;

/**
 *
 * @author svsv
 */
import java.io.FileInputStream;
import java.util.Properties;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene; //ikkunan näkymä
import javafx.scene.control.Label;
import javafx.scene.control.Button;//nappi
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;//komponenttien asettelu
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;//ikkuna

public class DiaryUi extends Application {

//      private TodoService todoService;
    private Scene diaryScene;
    private Scene newUserScene;
    private Scene loginScene;

    private VBox todoNodes;
    private Label menuLabel = new Label();
//    
//    @Override
//    public void init() throws Exception {
//        Properties properties = new Properties();
//
//        properties.load(new FileInputStream("config.properties"));
//        
//        String userFile = properties.getProperty("userFile");
//        String todoFile = properties.getProperty("todoFile");
//            
////        FileUserDao userDao = new FileUserDao(userFile);
////        FileTodoDao todoDao = new FileTodoDao(todoFile, userDao);
////        todoService = new TodoService(todoDao, userDao);
//    }

//    public Node createTodoNode(Todo todo) {
//        HBox box = new HBox(10);
//        Label label  = new Label(todo.getContent());
//        label.setMinHeight(28);
//        Button button = new Button("done");
//        button.setOnAction(e->{
//            todoService.markDone(todo.getId());
//            redrawTodolist();
//        });
//                
//        Region spacer = new Region();
//        HBox.setHgrow(spacer, Priority.ALWAYS);
//        box.setPadding(new Insets(0,5,0,5));
//        
//        box.getChildren().addAll(label, spacer, button);
//        return box;
//    }
//    public void redrawTodolist() {
//        todoNodes.getChildren().clear();     
//
//        List<Todo> undoneTodos = todoService.getUndone();
//        undoneTodos.forEach(todo->{
//            todoNodes.getChildren().add(createTodoNode(todo));
//        });     
//    }
    @Override
    public void start(Stage primaryStage) {
        // login scene

        VBox loginPane = new VBox(10);//arrange nodes in a singe column sarake
        HBox inputPane = new HBox(10);//arrange nodes in a singe row rivi
        loginPane.setPadding(new Insets(10));
        Label loginLabel = new Label("username");
        TextField usernameInput = new TextField();

        inputPane.getChildren().addAll(loginLabel, usernameInput);//asetetaan username teksti ja input peräkkäin

        Label loginMessage = new Label();//loggaustekstikenttä

        //luodaan login ja create buttonit
        Button loginButton = new Button("login");
        Button createButton = new Button("create new user");
        loginButton.setOnAction(e -> {
            String username = usernameInput.getText();
            menuLabel.setText(username + " logged in...");

//            if ( todoService.login(username) ){
            loginMessage.setText("");
////                redrawTodolist();
            primaryStage.setScene(diaryScene);
//                usernameInput.setText("");
//            } else {
//                loginMessage.setText("user does not exist");
//                loginMessage.setTextFill(Color.RED);
//            }      
        });

        //create user nappia painamalla siirrytään uuteen käyttäjänluomisikkunaan
        createButton.setOnAction(e -> {
            usernameInput.setText("");
            primaryStage.setScene(newUserScene);
        });
        // Add Header
        Label headerLabel = new Label("Sign in");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        loginPane.getChildren().addAll(headerLabel, loginMessage, inputPane, loginButton, createButton);    //asetetaan kaikki samaan sarakkeeseen   

        //luodaan login scene
        loginScene = new Scene(loginPane, 300, 250);

        // new getLoggedUserscene
        VBox newUserPane = new VBox(10);

        HBox newUsernamePane = new HBox(10);
        newUserPane.setPadding(new Insets(10));
        TextField newUsernameInput = new TextField();
        Label newUsernameLabel = new Label("username");
        newUsernameLabel.setPrefWidth(100);
        newUsernamePane.getChildren().addAll(newUsernameLabel, newUsernameInput);

        HBox newNamePane = new HBox(10);
        newNamePane.setPadding(new Insets(10));
        TextField newNameInput = new TextField();
        Label newNameLabel = new Label("name");
        newNameLabel.setPrefWidth(100);
        newNamePane.getChildren().addAll(newNameLabel, newNameInput);

        Label userCreationMessage = new Label();

        Button createNewUserButton = new Button("create");
        createNewUserButton.setPadding(new Insets(10));

        createNewUserButton.setOnAction(e -> {
            String username = newUsernameInput.getText();
            String name = newNameInput.getText();

            if (username.length() == 2 || name.length() < 2) {
                userCreationMessage.setText("username or name too short");
                userCreationMessage.setTextFill(Color.RED);
//            } else if ( todoService.createUser(username, name) ){
//                userCreationMessage.setText("");                
//                loginMessage.setText("new user created");
//                loginMessage.setTextFill(Color.GREEN);
//                primaryStage.setScene(loginScene);      
            } else {
                primaryStage.setScene(loginScene);
//                userCreationMessage.setText("username has to be unique");
//                userCreationMessage.setTextFill(Color.RED);        
            }

        });

        // Add Header
        Label createHeaderLabel = new Label("Create username");
        createHeaderLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        newUserPane.getChildren().addAll(createHeaderLabel, userCreationMessage, newUsernamePane, newNamePane, createNewUserButton);

        newUserScene = new Scene(newUserPane, 300, 250);

        // main diaryscene
        ScrollPane mainSrcollbar = new ScrollPane();  //scrollattava paneeli     
        BorderPane mainPane = new BorderPane(mainSrcollbar);
        diaryScene = new Scene(mainPane, 800, 700); //säädetäänkoko

        VBox diaryPane = new VBox(10);//arrange nodes in a singe column sarake
        HBox menuPane = new HBox(10);
        menuPane.setPadding(new Insets(10));
        Region menuSpacer = new Region();
        HBox.setHgrow(menuSpacer, Priority.ALWAYS);
        Button logoutButton = new Button("logout");

        //header
        Label diaryHeaderLabel = new Label("My Food Diary");
        diaryHeaderLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        menuPane.getChildren().addAll(menuLabel, diaryHeaderLabel, menuSpacer, logoutButton);
        diaryPane.getChildren().addAll(menuPane);

        //logout palauttaa login näkymään
        logoutButton.setOnAction(e -> {
//            todoService.logout();
            primaryStage.setScene(loginScene);
        });

        //breakfast 
        HBox createForm = new HBox(10);      //riviasettelu
        createForm.setPadding(new Insets(10));
        Label breakfastLabel = new Label("Breakfast:");
        Button createBreakfast = new Button("create");
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        TextField breakfastInput = new TextField();
        breakfastInput.setPrefWidth(300);
        createForm.getChildren().addAll(breakfastLabel, breakfastInput, spacer, createBreakfast);

        todoNodes = new VBox(10);
        todoNodes.setMaxWidth(280);
        todoNodes.setMinWidth(280);
//        redrawTodolist();

        mainSrcollbar.setContent(todoNodes);
        mainPane.setBottom(createForm);

        mainPane.setTop(menuPane);

        createBreakfast.setOnAction(e -> {
//            todoService.createTodo(newTodoInput.getText());
            breakfastInput.setText("");
//            redrawTodolist();
        });

        //luch 
        HBox createLunchForm = new HBox(10);      //riviasettelu
        createLunchForm.setPadding(new Insets(10));
        Label lunchLabel = new Label("Lunch:");
        Button createLunch = new Button("create");
        Region lunchspacer = new Region();
        HBox.setHgrow(lunchspacer, Priority.ALWAYS);
        TextField lunchInput = new TextField();
        lunchInput.setPrefWidth(300);
        createLunchForm.getChildren().addAll(lunchLabel, lunchInput, lunchspacer, createLunch);

        mainPane.setCenter(createLunchForm);

        //  seutup primary stage       
        primaryStage.setTitle("FitMe");
        primaryStage.setScene(loginScene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            System.out.println("klose");
//            System.out.println(todoService.getLoggedUser());
//            if (todoService.getLoggedUser()!=null) {
//                e.consume();   
//            }

        });
    }

    @Override
    public void stop() {
        // tee lopetustoimenpiteet täällä
        System.out.println("sovellus sulkeutuu");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
