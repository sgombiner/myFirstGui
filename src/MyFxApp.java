
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;



public class MyFxApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Construct controls
        Label label1 = new Label("Sam Gombiner's ");
        Label label2 = new Label("2022 ");
        Label label3 = new Label("Portfolio!");
        Label label4 = new Label("");
        Button button1 = new Button("Update Year!");
        Button pressMe = new Button("Press Me To Reveal Text!");
        Slider slider = new Slider(0, 100, 0);
        ToggleButton toggleButton1 = new ToggleButton("Toggle?");
        label1.setFont(new Font("Arial", 24));

        pressMe.setOnAction(actionEvent -> {
            label4.setText("Nice Job! Type in the Text Field to edit what this says!");
        });

        TextField typeHere = new TextField("Please type here!");
        typeHere.setOnAction(actionEvent ->  {
            label4.setText(typeHere.getText());
        });

        button1.setOnAction(actionEvent -> {
            label2.setText("2023");
        });


        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setOnAction(actionEvent -> {
            Color value = colorPicker.getValue();
            label2.setTextFill(value);
        });

        // Layout controls in a scene
        HBox hboxSlider = new HBox(slider);
        VBox vboxToggleButton = new VBox(toggleButton1);
        VBox vbox1 = new VBox(label1, label2);
        VBox vbox2 = new VBox(vbox1, label3, button1, colorPicker);
        HBox update3 = new HBox(vbox2,hboxSlider);
        VBox update4 = new VBox(update3,vboxToggleButton);
        VBox update5 = new VBox(update4,label4,pressMe,typeHere);
        Scene scene = new Scene(update5, 1440, 1080);

        // Put layout on stage and open the curtains
        primaryStage.setScene(scene);
        primaryStage.setTitle("My First JavaFX App");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}