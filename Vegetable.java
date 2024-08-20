/**
* The Vegetable class extends the Food class and it 
* constructs an object within food with an additional parameter of color
* while also incrementing the number of Vegetables
*
* @author  Zainab Spall
* @version Java 11 / VSCode
* @since   2024-04-29
*/
public class Vegetable extends Food{
     //private data fields
     private String color;
     private static int numVeg = 0;

     //constructors
     public Vegetable(String color){
        super("", 0.0);
        this.color = color;
        numVeg++;
     }

     public Vegetable(String name, double price, String color){
        super(name, price);
        this.color = color;
        numVeg++;
     }

     //getters and setters
     public String getColor(){
        return color;
     }

     public void setColor(String color){
        this.color = color;
     }

     public static int getNumVeg(){
        return numVeg;
     }

    /**
    * This method overrides the abstract method to return
    * the type of food
    * @return String This returns "Vegetable"
    */ 
    @Override
    public String getType(){
        return "Vegetable";
    }

    /**
    * This method overrides toString to print 
    * the type, color, and price of the object
    * @return String This returns the output as a String 
    */ 
    @Override 
    public String toString(){
        return "Name: " + super.toString() + ", Type: " + getType() + ", Price: "  + getPrice() + ", Color: " + color;
    }
}
