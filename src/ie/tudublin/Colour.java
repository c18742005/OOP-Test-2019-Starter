package ie.tudublin;

import processing.data.TableRow;

public class Colour {
    public int r;
    public int g;
    public int b;
    public int num;

    // method to print colours to standard output
    public String toString(){
        return this.r + " " + this.g + " " + this.b + " " + this.num;
    }

    public Colour(TableRow tr)
    {
        this(
            tr.getInt("r"), 
            tr.getInt("g"), 
            tr.getInt("b"), 
            tr.getInt("value"));
    }

    // accessor method
    public Colour(int r, int g, int b, int num){
        this.r = r;
        this.g = g;
        this.b = b;
        this.num = num;
    }
}