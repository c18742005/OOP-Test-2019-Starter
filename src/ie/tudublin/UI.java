package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet {
	// ArrayLists to store colours and resistors
	private ArrayList<Colour> colours = new ArrayList<Colour>();
	private ArrayList<Resistor> resistors = new ArrayList<Resistor>();

	public void separate(int value) {
		int hundreds = (value / 100);
		int tens = (value - (hundreds * 100)) / 10;
		int ones = value - ((hundreds * 100) + (tens * 10));
		print(hundreds + ",");
		print(tens + ",");
		println(ones);
	}

	public void settings() {
		size(500, 800);
		
		//separate(381);
		//separate(1);
		//separate(92);
	}

	public void setup() {
		background(220);	// gray background
		loadColours();
		loadResistors();
		printColours();
		printResistors();
	}

	// method to load colours from the csv file with headers
	public void loadColours() {
		// create table and load file to table
		Table table = loadTable("colours.csv", "header");

		// iterate through each row of table and add to colours arraylist
		for (TableRow tr : table.rows()) {
			Colour colour = new Colour(tr);
			colours.add(colour);
		}
	}

	// method to load resistors from csv file without headers
	public void loadResistors() {
		// create table and load file to table
		Table table = loadTable("resistors.csv");

		// iterate through rows of table and add each to resistors array list
		for (TableRow tr : table.rows()) {
			resistors.add(new Resistor(this, tr.getInt(0)));
		}
	}

	// method to print colours to console
	public void printColours(){
		for(Colour colour : colours){
			System.out.println(colour);
		}
	}

	// method to find the colour given a value
	public Colour findColour(int value){
		for(Colour colour : colours){
			if(colour.value == value){
				return colour;
			}
		}

		return null;
	}

	// prints the resistors to console
	public void printResistors(){
		for(Resistor resistor : resistors){
			System.out.println(resistor);
		}
	}
	
	public void draw()
	{			
		for(int i = 0; i < resistors.size(); i++){
			Resistor r = resistors.get(i);

			pushMatrix();
			translate(100, map(i, 0, resistors.size(), 50, 600));
			r.render();
			popMatrix();
		}
	}
}
