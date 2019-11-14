package company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Histogram extends Application{

    @Override public void start(Stage primaryStage) {
        //Read file and arranging the data
        Scanner scanner = null;
        try{scanner = new Scanner(new File("C:\\Users\\davba\\Documents\\David\\CSC-221\\CSC221_Project\\src\\program\\Histogram\\Emma.txt"));}
        catch(FileNotFoundException error){error.printStackTrace();}

        char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] buffer;
        double[] letterFrequency = new double[26];
        String fileLine;
        int total = 0;
        while(scanner.hasNextLine()) {
            fileLine = scanner.nextLine();
            buffer = fileLine.toCharArray();
            for(int i = 0; i < buffer.length; i++) {
                for(int j = 0; j < 26; j++) {
                    if (buffer[i] == letters[j]) {
                        letterFrequency[j]++;
                        total++;
                        break;
                    }
                }
            }
        }

        //Fixing frequency
        for(int k = 0; k <26; k++){
            letterFrequency[k] = letterFrequency[k]/total;
        }

        //Sorting the letters and its respective frequencies by size(Bigger to smaller)
        for (int i = 0; i < letterFrequency.length; i++) {
            int m = i;
            for (int j = i; j < letterFrequency.length; j++) {
                if (letterFrequency[j] > letterFrequency[m]) {
                    m = j;
                }
            }
            double tempDouble;
            tempDouble = letterFrequency[i];
            letterFrequency[i] = letterFrequency[m];
            letterFrequency[m] = tempDouble;

            char tempChar;
            tempChar = letters[i];
            letters[i] = letters[m];
            letters[m] = tempChar;
        }

        // Setting Stages and User Input
        Scene inputScene, chartScene;
        primaryStage.setTitle("CSC221 - Project 3; David Balaban");
        TextField input = new TextField ();
        input.setPromptText("Enter a number between 0 and 26");
        Label inputMessage = new Label();

        StackPane chartPane = new StackPane();
        chartScene = new Scene(chartPane, 800, 500);
        Canvas canvas = new Canvas(800, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        chartPane.getChildren().add(canvas);

        Button button = new Button("Go!");

        VBox inputBox = new VBox(20);
        inputBox.setPadding(new Insets(20,15,0,15));
        inputBox.getChildren().addAll( input, button, inputMessage);
        inputScene = new Scene(inputBox, 300, 166.67);

        primaryStage.setScene(inputScene);
        primaryStage.show();

        //Determining what happens when the user clicks on the button
        button.setOnAction(e -> {
            if(!intCheck(input.getText())) {
                inputMessage.setText("Error. Please Enter an Integer");
            }
            else {
                int num = Integer.parseInt(input.getText());
                if (num > 26 || num < 0) {
                    inputMessage.setText("N cannot be more than 26 or less than 0");
                } else {
                    inputMessage.setText("Loading Chart...");
                    PieChart pc = new PieChart(400,250, num, letterFrequency, letters);
                    primaryStage.setScene(chartScene);
                    pc.draw(gc);
                }}
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Boolean intCheck(String input){
        boolean isInt = true;
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            isInt = false;
        } catch(NullPointerException e) {
            isInt = false;
        }
        return isInt;
    }





}
