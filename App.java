package ru.func.graph;
 
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
 
/**
 * @author func 10.04.2020
 * @project Graph
 */
public class App extends Application {
    private int HEIGHT = 720;
    private int WIDTH = 1080;
 
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
 
        group.getChildren().addAll(
            new Line(0, HEIGHT/2, WIDTH, HEIGHT/2),
            new Line(WIDTH/2, 0, WIDTH/2, HEIGHT)
        );
 
        Operation operation = x -> x[0]*2;
 
        for(int i = -WIDTH/2; i < WIDTH/2 - 1; i++) {
            group.getChildren().add(
                  new Line(
                          i + WIDTH/2,
                          -operation.execute(i) + HEIGHT/2,
                          i+1 +WIDTH/2,
                          -operation.execute(i+1)+ HEIGHT/2
                  )
            );
        }
 
        Scene scene = new Scene(group, WIDTH, HEIGHT);
 
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    @FunctionalInterface
    public interface Operation {
        double execute(double... nums);
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }
}
