package ie.tudublin;

public class Resistor {
    UI ui;
    public int value;
    public int ones;
    public int tens;
    public int hundreds;

    // method to allow printing of resistors to console
    public String toString(){
        return value + " " + hundreds + " " + tens + " " + ones;
    }

    // method to render resistors to applet
    public void render(){

        ui.strokeWeight(2);
        ui.stroke(0, 0, 0);

        // draw the resistor outline
        ui.line(-100, 0, -50, 0);
        ui.line(-50, 0, -50, -50);
        ui.line(-50, -50, 50, -50);
        
        ui.line(50, -50, 50, 0);
        ui.line(50, 0, 100, 0);
        ui.line(50, 0, 50, 50);
        ui.line(50, 50, -50, 50);
        ui.line(-50, 50, -50, 0);

        // get the colours of the resistor bands
        Colour c1 = ui.findColour(this.hundreds);
        Colour c2 = ui.findColour(this.tens);
        Colour c3 = ui.findColour(this.ones);

        ui.strokeWeight(5);

        // make the coloured bands
        ui.stroke(c1.getR(), c1.getG(), c1.getB());
        ui.line(-40, 50, -40, -50);
        ui.stroke(c2.getR(), c2.getG(), c2.getB());
        ui.line(-30, 50, -30, -50);
        ui.stroke(c3.getR(), c3.getG(), c3.getB());
        ui.line(-20, 50, -20, -50);
    }

    // resistor constructor 
    public Resistor(UI ui, int value){

        this.ui = ui;
        this.value = value;
        this.hundreds = (value / 100);
        this.tens = (value - (hundreds * 100)) / 10;
        this.ones = value - ((hundreds * 100)  + (tens * 10));
    }
}