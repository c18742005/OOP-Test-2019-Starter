package ie.tudublin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet {
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

		separate(381);
		separate(1);
		separate(92);
	}

	public void setup() {
		loadColours();
		printColours();
		try {
			loadResistors();
		} catch (IOException e) {
			e.printStackTrace();
		}
		printResistors();
	}

	public void loadColours() {
		Table table = loadTable("colours.csv", "header");

		for (TableRow tr : table.rows()) {
			Colour colour = new Colour(tr);
			colours.add(colour);
		}
	}

	public void loadResistors() throws IOException {
		BufferedReader csvReader = new BufferedReader(new FileReader("data/resistors.csv"));
		String line = null;
		int res = 0;

        while((line = csvReader.readLine()) != null){
			res = Integer.parseInt(line);
			Resistor resistor = new Resistor(res);
			resistors.add(resistor);
		}

		csvReader.close();
	}

	public void printColours(){
		for(Colour colour : colours){
			System.out.println(colour);
		}
	}

	public Colour findColour(int value){
		for(Colour colour : colours){
			if(colour.value == value){
				return colour;
			}
		}

		return null;
	}

	public void printResistors(){
		for(Resistor resistor : resistors){
			System.out.println(resistor);
		}
	}
	
	public void draw()
	{			
	}
}
