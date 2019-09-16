package sample;

        import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.scene.control.Button;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.scene.layout.StackPane;
        import javafx.scene.layout.VBox;
        import javafx.stage.Stage;

public class Main extends Application{
    //"extends Application" provides functionality for the javafx to work
    //"implements EventHandler<ActionEvent>" allows the program to allow Events
    //<ActionEvent> is the event for a button click

    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args); //method inside of application class that sets up the javafx application (which calls method start)
    }

    @Override
    public void start(Stage primaryStage) throws Exception { // overridden bc inheriting from application class
        // primary stage is the main window
        primaryStage.setTitle("Title of the Window");

        //creating a label
        Label label1 = new Label("Welcome to the first scene!");

        // Button 1
        Button button1 = new Button();
        button1.setText("Take me to scene 2!");
        button1.setOnAction(e->primaryStage.setScene(scene2)); //what happens when the button is clicked
            // when the button is clicked, the code to handle it is in "this" class for handle method
            //button.setOnAction(this);
            /*
            Here is a more compact way to handle the button click
            button.setOnAction(new EventHandler<ActionEvent>(){
             @Override
                 public void handle(ActionEvent event) {
                 System.out.println("this is an anonymous inner class")
                    }
                    }
               };
             You can also use multiple lines of code with a lambda
             button.setOnAction(e -> {
             System.out.println("Handling the button using a lambda");
             System.out.println("Also handling the button using a lambda");
              });
            */

        // Layout 1
        VBox layout1 = new VBox(); //VBox-children will be laid out in a vertical column
        layout1.getChildren().addAll(label1, button1); //add() does one thing and addAll does multiple
        scene1 = new Scene(layout1, 400, 200); //creates the scene

        // Button 2
        Button button2 = new Button("Go back to scene 1");
        button2.setOnAction(e-> primaryStage.setScene(scene1));

        // Layout 2
        StackPane layout2 = new StackPane(); // StackPane will set the button in the middle
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600,300); //creates the scene

        // Setting the first scene
        primaryStage.setScene(scene1); // sets the scene
        primaryStage.setTitle("Made this Window!");
        primaryStage.show(); // Shows the scene
    }

     //[alt][insert][implement methods] opens the window to add in the event handler


}
