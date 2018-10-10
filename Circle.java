/*
 * Creates a circle object for the main class
 */
package Assignment8;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * 
 * @author emilystanek
 */
public class Circle {
    private int radius; 
    private double x, y;
    private Color fillColor;
    /**
     * 
     * @param radius sets the radius of the circle object
     * @param fillColor sets the colour the circle will be
     * @param x sets the x location on the canvas
     * @param y sets the y location on the canvas
     */
    public Circle(int radius, Color fillColor, double x, double y){
        this.radius = radius;
        this.fillColor = fillColor;
        this.x = x;
        this.y = y;
        
    }
    /**
     * 
     * @return radius
     */
    public int getRadius() {
        return radius;
    }
    /**
     * sets the radius of the circle object to a new value
     * @param radius 
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }
    /**
     * 
     * @return circle's fill color
     */
    public Color getFillColor() {
        return fillColor;
    }
    /**
     * sets the fill color of the circle object
     * @param fillColor 
     */
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
    /**
     * 
     * @return x location
     */
    public double getX() {
        return x;
    }
    /**
     * 
     * @return y location
     */
    public double getY() {
        return y;
    }
    /**
     * sets the x location of the circle object
     * @param x 
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * sets the y location of the circle object
     * @param y 
     */
    public void setY(double y) {
        
        this.y = y;
    }
    /**
     * draws the circle object
     * @param gc 
     */
    public void draw(GraphicsContext gc){
        gc.setFill(getFillColor());
        gc.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

}
