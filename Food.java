/**
* The Food class constructs an object representing a food with a name
* and a price, while it also increments the amount of food objects created
*
* @author  Zainab Spall
* @version Java 11 / VSCode
* @since   2024-04-29
*/
public abstract class Food{

    //private data fields
    private String name;
    private double price;
    private static int numFood = 0;

    //constructor
    protected Food(String name, double price){
        this.name = name;
        this.price = price;
        numFood++;
    }

    //getters and setters
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public static int getNumFoods(){
        return numFood;
    }

    /**
    * This abstract method gets the type of food
    * @return String This returns the type as a String 
    */ 
    public abstract String getType();

    /**
    * This method is used to return the name of a food as a String
    * @return String This returns the String containing the name
    */ 
    @Override
    public String toString(){
        return name;
    }

    /**
    * This method is used to check if the object o is a food
    * @return boolean This returns true or false based on the class of the object
    */ 
    @Override
    public boolean equals(Object o){
        if(o instanceof Food){
            Food f = (Food) o;
            return this.name.equals(f.name) && this.getType().equals(f.getType());
        }
        return false;
    }
}
