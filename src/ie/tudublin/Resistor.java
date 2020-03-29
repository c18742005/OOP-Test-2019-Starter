package ie.tudublin;

public class Resistor {
    public int value;
    public int ones;
    public int tens;
    public int hundreds;

    public void setValue(int v){
        this.value = v;
    }

    public int getValue(){
        return value;
    }

    public void setOnes(int o){
        this.ones = o;
    }

    public int getOnes(){
        return ones;
    }

    public void setTens(int t){
        this.tens = t;
    }

    public int getTens(){
        return tens;
    }

    public void setHundreds(int h){
        this.hundreds = h;
    }

    public int getHundreds(){
        return hundreds;
    }

    public String toString(){
        return value + " " + hundreds + " " + tens + " " + ones;
    }

    public Resistor(int value){
        this.value = value;
        this.hundreds = (value / 100);
        this.tens = (value - (hundreds * 100)) / 10;
        this.ones = value - ((hundreds * 100)  + (tens * 10));
        
    }

    public Resistor(){
        this(0);
    }

}