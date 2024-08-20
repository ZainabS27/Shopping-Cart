/**
* The Fruit class extends the Food class and it 
* constructs an object within food with an additional parameter that
* tells you whether or not it is seedless
*
* @author  Zainab Spall
* @version Java 11 / VSCode
* @since   2024-04-29
*/
public class Fruit extends Food{
    //private data fields
    private boolean seeds;
    private static int numFruit = 0;

    //constructors
    public Fruit(boolean seeds){
        super("", 0.0);
        this.seeds = seeds;
        numFruit++;
    }

    public Fruit(String name, double price, boolean seeds){
        super(name, price);
        this.seeds = seeds;
        numFruit++;
    }

    //getters and setters
    public boolean getSeeds(){
        return seeds;
    }

    public void setSeeds(boolean seeds){
        this.seeds = seeds;
    }

    public static int getNumFruit(){
        return numFruit;
    }

    /**
    * This method overrides the abstract method to return
    * the type of food
    * @return String This returns "Fruit"
    */ 
    @Override
    public String getType(){
        return "Fruit";
    }

    /**
    * This method overrides toString to print 
    * the type, whether or not its seedless, and its price 
    * @return String This returns the output as a String 
    */ 
    @Override 
    public String toString(){
        return "Name: " + super.toString() + ", Type: " + getType() + ", Price: "  + getPrice() + ", Seeds: " + seeds;
    }
}
