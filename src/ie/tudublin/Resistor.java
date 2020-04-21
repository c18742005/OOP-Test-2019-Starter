package ie.tudublin;

import processing.core.PApplet;

public class Resistor {
    UI ui;
    public int value;

    Colour hc;
    Colour tc;
    Colour oc;


    // method to render resistors to applet
    public void render(float x, float y){

        ui.pushMatrix();
        ui.translate(x, y);
        ui.stroke(0);
        
        // draw the resistor shape
        ui.line(-100, 0, -50, 0);
        ui.line(-50, 0, -50, -50);
        ui.line(-50, -50, 50, -50);
        ui.line(50, -50, 50, 0);
        ui.line(50, 0, 100, 0);
        ui.line(50, 0, 50, 50);
        ui.line(50, 50, -50, 50);
        ui.line(-50, 50, -50, 0);

        ui.noStroke(); // no outline of shapes

        // Draw the color bars
        ui.fill(hc.r, hc.g, hc.b);
        ui.rect(-40, -49, 10, 99);
        
        ui.fill(tc.r, tc.g, tc.b);
        ui.rect(-20, -49, 10, 99);
        
        ui.fill(oc.r, oc.g, oc.b);
        ui.rect(0, -49, 10, 99);

        // draw the value of the resistor to screen
        ui.fill(0);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.textSize(30);
        ui.text(value, 200, 0);

        ui.popMatrix();
    }

    // resistor constructor 
    public Resistor(UI ui, int resistance){

        this.ui = ui;
        this.value = resistance;
        int hundreds = (resistance / 100);
        int tens = (resistance - (hundreds * 100)) / 10;
        int ones = resistance - ((hundreds * 100)  + (tens * 10));
        hc = ui.findColour(hundreds);
        tc = ui.findColour(tens);
        oc = ui.findColour(ones);
    }
}