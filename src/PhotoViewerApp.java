
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import java.io.FileInputStream;
import java.util.ArrayList;


public class PhotoViewerApp extends Application {
    ArrayList<Image> images = new ArrayList();
    int index;
// images ArrayList starts empty

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Construct controls
        Label label1 = new Label("Sam Gombiner's Photo Viewer App");
        Button startButton = new Button("Start Browsing Images?");
        Button left = new Button("<");
        Button right = new Button(">");
        Image fog = new Image(new FileInputStream("fogForest.jpg"));
        images.add(fog); // index: 0
// 1st image gets added at images ArrayList index 0

        Image lavender = new Image(new FileInputStream("lavenderField.jpeg"));
        images.add(lavender);
// 2nd image gets added at images ArrayList index 1

        Image owl = new Image(new FileInputStream("owl.jpg"));
        images.add(owl);

        Image winton = new Image(new FileInputStream("winton.jpeg"));
        images.add(winton);

        Image bumps = new Image(new FileInputStream("bumps.jpeg"));
        images.add(bumps);
        index = 4;

        ImageView imageView = new ImageView(bumps);
        imageView.setFitHeight(300);
        imageView.setFitWidth(400);
        imageView.setVisible(false);
        startButton.setOnAction(action -> {
            imageView.setVisible(true);
            startButton.setVisible(false);
        });

        right.setOnAction(actionEvent -> {
            if (index == 0) {
                index = 4;
            } else {
                index--;
            }
            Image nextImage = images.get(index);
            imageView.setImage(nextImage);

        });

        left.setOnAction(actionEvent -> {
            if (index == 4) {
                index = 0;
            } else {
                index++;
            }
            Image nextImage = images.get(index);
            imageView.setImage(nextImage);

        } );


// 3rd image gets added at images ArrayList index 2
        // Layout controls in a scene
        VBox Label1 = new VBox(label1);
        VBox VboxStartButton = new VBox(Label1,startButton);
        HBox LeftRightControls = new HBox(left,right);
        VBox VboxBumps = new VBox(VboxStartButton,imageView, LeftRightControls);
        Scene scene = new Scene(VboxBumps, 1440, 1080);

        // Put layout on stage and open the curtains
        primaryStage.setScene(scene);
        primaryStage.setTitle("Photo Viewer App");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}