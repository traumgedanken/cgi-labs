import javafx.application.Application;
import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CGI LAB1");

        Group root = new Group();
        Scene scene = new Scene(root, 800, 500);
        scene.setFill(Color.rgb(100, 100, 100));

        // Pillar
        Rectangle pillar = new Rectangle(385,260,30,200);
        pillar.setFill(Color.BLACK);

        // Sign board
        Polygon redBoard = new Polygon(
                285.0, 260.0,
                515.0, 260.0,
                400.0, 40.0);

        redBoard.setFill(Color.RED);
        Polygon whiteBoard = new Polygon(
                315.0, 240.0,
                485.0, 240.0,
                400.0, 75.0);

        whiteBoard.setFill(Color.WHITE);

        // Red light
        Circle redLight = new Circle(400,125,20);
        redLight.setFill(Color.RED);
        Circle yellowLight = new Circle(400,170,20);
        yellowLight.setFill(Color.YELLOW);
        Circle greenLight = new Circle(400,215,20);
        greenLight.setFill(Color.GREEN);

        root.getChildren().addAll(
                pillar, redBoard, whiteBoard,
                redLight, yellowLight, greenLight);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
