
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PalindromeDetector extends Application
{
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage)
    {
        Label startLabel = new Label("Enter a word/phrase");
        TextField input = new TextField();
        Button detectPalindrome = new Button("Detect palindrome");
        Label result = new Label();
        result.setWrapText(true);
        result.setTextAlignment(TextAlignment.CENTER);
        detectPalindrome.setOnAction(event -> {
           String inputFormatted =  input.getText()
                                   .replaceAll("\\W+", "")
                                   .toLowerCase();
           char[] textArray = inputFormatted.toCharArray();
           if(evalInput(textArray, 0, (textArray.length - 1))) {
               result.setText("\"" + input.getText() 
               + "\" is a palindrome.");
           }
           else {
               result.setText("\"" + input.getText() 
               + "\" is not a palindrome.");
           }
        });
        
        VBox vbox = new VBox(10, startLabel, input, detectPalindrome, result);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
    
    private static boolean evalInput(char[] array, int start, int end) {
        if (start >= end) {
            return true;
        }
        else if(array[start] == array[end]) {
           return evalInput(array, (start + 1), (end - 1));
        }
        else {
           return false;
        }
    }
}
