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
		loadColours();
		loadResistors();
		printColours();
		printResistors();
		
		//separate(381);
		//separate(1);
		//separate(92);
	}

	public void setup() {
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
	public Colour findColour(int num){
		for(Colour c:colours)
		{
			if (c.num == num)
			{
				return c;
			}			
		}
		return null;
	}

	// prints the resistors to console
	public void printResistors(){
		for(Resistor r:resistors)
		{
			int i = r.value;
			int hundreds = (i / 100);
			int tens = (i - (hundreds * 100)) / 10;
			int ones = i - ((hundreds * 100)  + (tens * 10));
			print(hundreds + ",");
			print(tens + ",");
			println(ones);			
		}
	}
	
	public void draw()
	{	
		background(200);
		stroke(255);
		
		for(int i = 0 ; i < resistors.size() ; i ++)
		{
			float y = map(i, 0, resistors.size(), 100, height - 100);
			resistors.get(i).render(width / 2, y);
		}
	}
}
