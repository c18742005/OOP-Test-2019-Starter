package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Colour {
    public int r;
    public int g;
    public int b;
    public int value;
    private String colour;

    public void setR(int r){
        this.r = r;
    }

    public int getR(){
        return r;
    }

    public void setG(int g){
        this.g = g;
    }

    public int getG(){
        return g;
    }

    public void setB(int b){
        this.b = b;
    }

    public int getB(){
        return b;
    }

    public void setValue(int v){
        this.value = v;
    }

    public int getValue(){
        return value;
    }

    public void setColour(String c){
        this.colour = c;
    }

    public String getColour(){
        return colour;
    }

    public String toString(){
        return colour + "\t" + r + " " + g + " " + b + " " + value;
    }

    public Colour(String colour, int r, int g, int b, int v){
        this.colour = colour;
        this.r = r;
        this.g = g;
        this.b = b;
        this.value = v;
    }

    public Colour(){
        this("", 0, 0, 0, 0);
    }

    public Colour(TableRow tr){
        this(
            tr.getString("colour"),
            tr.getInt("r"),
            tr.getInt("g"),
            tr.getInt("b"),
            tr.getInt("value")
        );
    }
}