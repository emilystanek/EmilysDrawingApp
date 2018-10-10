package Assignment8;

import javafx.scene.canvas.GraphicsContext;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * Implements the GUI of the drawing app which uses Circle objects to allow drawing
 * 
 * @author emily stanek
 */
public class MainAlternate extends Application {
    Circle c1;
    GraphicsContext gc;
    Canvas canvas;
    double x, y;
    int brushSize = 15;
    Color drawColor = Color.BLACK;
    Label header, locationLabel, xLabel, yLabel, colorLabel, redLabel, greenLabel, blueLabel, sizeLabel, colorButtonLabel;
    TextField xLocation, yLocation, red, green, blue;
    Button drawButton, small, medium, large, color1, color2, color3, color4, color5, color6;
    
    Label errorReporting = new Label();
    // TODO: Instance Variables for View Components and Model
    // TODO: Private Event Handlers and Helper Methods
    
    /**
     * 
     * @param press  when the canvas is clicked, a circle is generated
     */
     private void pressHandler(MouseEvent press) {
        c1 = new Circle(brushSize, drawColor, press.getX(), press.getY());
        c1.draw(gc);
    }
    /**
     * 
     * @param drag after a size and colour is chosen, the user can drag and 
     * draw on the canvas
     */
    private void dragHandler(MouseEvent drag) {
        c1 = new Circle(brushSize, drawColor, drag.getX(), drag.getY());
        c1.draw(gc);
    }

    /**
     * 
     * @param s changes the brush size to a small circle when clicked
     */
    private void smallHandler(ActionEvent s){
        brushSize = 8;
        c1.setRadius(brushSize);
    }
    /**
     * 
     * @param m changes the brush size to medium
     */
    private void medHandler(ActionEvent m){
        brushSize = 15;
        c1.setRadius(brushSize);
    }
    /**
     * 
     * @param l changes the brush size to large
     */
    private void largeHandler(ActionEvent l){
        brushSize = 30;
        c1.setRadius(brushSize);
    }
    /**
     * changes color to selected button
     * @param color 
     */
    private void color1Handler(ActionEvent color){
        drawColor = Color.rgb(0, 0, 255);
    }
    private void color2Handler(ActionEvent color){
        drawColor = Color.rgb(110, 50, 255);
    }
    private void color3Handler(ActionEvent color){
        drawColor = Color.rgb(255, 50, 255);
    }
    private void color4Handler(ActionEvent color){
        drawColor = Color.rgb(255, 0, 71);
    }
    private void color5Handler(ActionEvent color){
        drawColor = Color.rgb(0, 200, 0);
    }
    private void color6Handler(ActionEvent color){
        drawColor = Color.rgb(2, 255, 255);
    }
    /**
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 1000, 670); // set the size here
        stage.setTitle("Emily's Drawing App"); // set the window title here
        stage.setScene(scene);
        canvas = new Canvas(800, 500);
        gc = canvas.getGraphicsContext2D();
        // TODO: Add your GUI-building code here

        // 1. Create the model
        
        // 2. Create the GUI components
        
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 675, 1000, 30);
        
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 800, 500);
        
        /** "Emily's Drawing App" logo **/
        Label logo = new Label();
        Image image = new Image(getClass().getResourceAsStream("logo.png"));
        logo.setGraphic(new ImageView(image));
        /** Label to show where sizes are in toolbar **/
        sizeLabel = new Label("Choose a size:");
        /** small brush size icon **/
        small = new Button();
        Image smallCircleImage = new Image(getClass().getResourceAsStream("circleSM.png"));
        small.setGraphic(new ImageView(smallCircleImage));
        /** medium brush size icon **/
        medium = new Button();
        Image mediumCircleImage = new Image(getClass().getResourceAsStream("circleMD.png"));
        medium.setGraphic(new ImageView(mediumCircleImage));
        /** large brush size icon **/
        large = new Button();
        Image largeCircleImage = new Image(getClass().getResourceAsStream("circleLG.png"));
        large.setGraphic(new ImageView(largeCircleImage));
        /** colour buttons **/
        colorButtonLabel = new Label("Choose a color:");
        /** Image for Colour1 **/
        color1 = new Button();
        Image color1Image = new Image(getClass().getResourceAsStream("darkblue.png"));
        color1.setGraphic(new ImageView(color1Image));
        /** Image for Colour2 **/
        color2 = new Button();
        Image color2Image = new Image(getClass().getResourceAsStream("purple.png"));
        color2.setGraphic(new ImageView(color2Image));
        /** Image for Colour3 **/
        color3 = new Button();
        Image color3Image = new Image(getClass().getResourceAsStream("pink.png"));
        color3.setGraphic(new ImageView(color3Image));
        /** Image for Colour4 **/
        color4 = new Button();
        Image color4Image = new Image(getClass().getResourceAsStream("cranberry.png"));
        color4.setGraphic(new ImageView(color4Image));
        /** Image for Colour5 **/
        color5 = new Button();
        Image color5Image = new Image(getClass().getResourceAsStream("green.png"));
        color5.setGraphic(new ImageView(color5Image));
        /** Image for Colour6 **/
        color6 = new Button();
        Image color6Image = new Image(getClass().getResourceAsStream("cyan.png"));
        color6.setGraphic(new ImageView(color6Image));
        
        /**instructions at top of screen **/
        header = new Label("Click and drag!");
        
        
        // 3. Add components to the root
        root.getChildren().add(canvas);
        root.getChildren().add(header);
        root.getChildren().add(logo);
        root.getChildren().add(sizeLabel);
        root.getChildren().add(small);
        root.getChildren().add(medium);
        root.getChildren().add(large);
        root.getChildren().add(color1);
        root.getChildren().add(color2);
        root.getChildren().add(color3);
        root.getChildren().add(color4);
        root.getChildren().add(color5);
        root.getChildren().add(color6);
        root.getChildren().add(colorButtonLabel);
        /** sets backgorund colour to lavender **/
        root.setStyle("-fx-background-color: lavender;");
        /** sets layout of white canvas in window **/
        canvas.setLayoutX(100);
        canvas.setLayoutY(75);
        /** sets location of the logo **/
        logo.setStyle("-fx-image: url('/images/logo.png')");
        logo.setLayoutX(100);
        logo.setLayoutY(10);
        /** sets location and style of header/ instruction text **/
        header.setLayoutX(760);
        header.setLayoutY(42);
        header.setFont(new Font("Arial Narrow Bold", 22));
        header.setStyle("-fx-text-fill: indigo; -fx-alignment: center-right;");
        /** sets location and style of colour label **/
        colorButtonLabel.setLayoutX(100);
        colorButtonLabel.setLayoutY(595);
        colorButtonLabel.setFont(new Font("Arial", 18));
        colorButtonLabel.setStyle("-fx-text-fill: indigo");
        /** sets the location of color1 button **/
        color1.setLayoutX(230);
        color1.setLayoutY(595);
        color1.setStyle("-fx-background-color: lavender;");
        /** sets the location of color2 button **/
        color2.setLayoutX(260);
        color2.setLayoutY(595);
        color2.setStyle("-fx-background-color: lavender;");
        /** sets the location of color3 button **/
        color3.setLayoutX(290);
        color3.setLayoutY(595);
        color3.setStyle("-fx-background-color: lavender;");
        /** sets the location of color4 button **/
        color4.setLayoutX(320);
        color4.setLayoutY(595);
        color4.setStyle("-fx-background-color: lavender;");
        /** sets the location of color5 button **/
        color5.setLayoutX(350);
        color5.setLayoutY(595);
        color5.setStyle("-fx-background-color: lavender;");
        /** sets the location of color6 button **/
        color6.setLayoutX(380);
        color6.setLayoutY(595);
        color6.setStyle("-fx-background-color: lavender;");
        /** sets location and style of the size label **/
        sizeLabel.setLayoutX(660);
        sizeLabel.setLayoutY(595);
        sizeLabel.setFont(new Font("Arial", 18));
        sizeLabel.setStyle("-fx-text-fill: indigo");
        /** sets the location and style of the small brush size button **/
        small.setLayoutX(790);
        small.setLayoutY(595);
        small.setStyle("-fx-background-color: lavender;");
        /** sets the location and style of the medium brush size button **/
        medium.setLayoutX(820);
        medium.setLayoutY(590);
        medium.setStyle("-fx-background-color: lavender;");
        /** sets the location and style of the large brush size button **/
        large.setLayoutX(860);
        large.setLayoutY(585);
        large.setStyle("-fx-background-color: lavender;");
        
        // 5. Add Event Handlers and do final setup
        /** event handler for when the canvas is pressed **/
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler);
        /** event handler for when mouse is dragged on the canvas **/
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::dragHandler);
        /** event handler for when small brush size button is clicked **/
        small.setOnAction(this::smallHandler);
        /** event handler for when medium brush size button is clicked **/
        medium.setOnAction(this::medHandler);
        /** event handler for when large brush size button is clicked **/
        large.setOnAction(this::largeHandler);
        /** event handler for when lcolour 1 is clicked **/
        color1.setOnAction(this::color1Handler);
        /** event handler for when colour 2 is clicked **/
        color2.setOnAction(this::color2Handler);
        /** event handler for when colour 3 is clicked **/
        color3.setOnAction(this::color3Handler);
        /** event handler for when colour 4 is clicked **/
        color4.setOnAction(this::color4Handler);
        /** event handler for when colour 5 is clicked **/
        color5.setOnAction(this::color5Handler);
        /** event handler for when colour 6 is clicked **/
        color6.setOnAction(this::color6Handler);
        
        // 6. Show the stage
        stage.show();
    }   

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
