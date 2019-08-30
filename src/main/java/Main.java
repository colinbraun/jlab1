import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {

    private File openedFile;
    private int openedWidth;
    private int openedHeight;
    ImageView theImage;

    public static void main(String[] args) {
        //GuiCalc b = new GuiCalc();
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        //runLab1b(primaryStage);
        runPaintProgram(primaryStage);
    }

    private void runPaintProgram(Stage primaryStage) {
        primaryStage.setTitle("Paint Program");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        //grid.setVgap(10);
        //grid.setPadding(new Insets(25, 25, 25, 25));
        HBox menuBar = new HBox();
        Button openButton = new Button("Open file");
        Button saveAsButton = new Button("Save as");
        menuBar.getChildren().add(openButton);
        menuBar.getChildren().add(saveAsButton);
        saveAsButton.setOnAction((event) -> {
            WritableImage image = new WritableImage(openedWidth, openedHeight);
            theImage.snapshot(null, image);
        });
        openButton.setOnAction((event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                openedFile = file;
                try {
                    ImageView image = new ImageView(new Image(new FileInputStream(openedFile.getAbsoluteFile())));
                    theImage = image;
                    openedWidth = (int)image.getImage().getWidth();
                    openedHeight = (int)image.getImage().getHeight();
                    grid.add(image, 0, 1);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }));
        //grid.add(openButton, 0, 0);
        //grid.add(saveAsButton, 1, 0);
        grid.add(menuBar, 0, 0);
        /*FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("C:\\Users\\User\\Desktop\\img\\primalDialga.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView(new Image(inputStream));
        grid.add(imageView, 0, 1);*/
        Scene scene = new Scene(grid, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
        //System.out.println(imageView.getViewport().getWidth());
    }

    private void runLab1b(Stage primaryStage) {
        primaryStage.setTitle("Lab 1b");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Label xText = new Label("x:");
        Label yText = new Label("y:");
        Label resultLabel = new Label("x*y=");
        TextField xField = new TextField();
        TextField yField = new TextField();
        Button button = new Button("Compute");
        button.setOnAction((e) -> {
            try {
                resultLabel.setText("x*y= " + (Integer.parseInt(xField.getText()) * Integer.parseInt(yField.getText())));
            } catch(NumberFormatException ex) {
                resultLabel.setText("Invalid Input");
            }
        });
        HBox hbButton = new HBox();
        hbButton.getChildren().add(button);
        grid.add(xText, 0, 0);
        grid.add(xField, 1, 0);
        grid.add(yText, 0, 1);
        grid.add(yField, 1, 1);
        grid.add(resultLabel, 1, 2);
        //grid.add(button, 0, 2);
        grid.add(hbButton, 1, 3);
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
