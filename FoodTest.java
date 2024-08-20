/**
* @author  Zainab Spall
* @version Java 11 / VSCode
* @since   2024-04-29
*/
import java.util.Scanner;
public class FoodTest{
    //main method
    public static void main(String[] args){
        Food[] groceryCart = new Food[50];
        groceryCart[0] = new Vegetable("Romaine", 1.09, "Green");
        groceryCart[1] = new Fruit("Mango", 3.79, true);
        groceryCart[2] = new Vegetable("Brussel Sprouts", 4.56, "Green");
        groceryCart[3] = new Fruit("Blueberry", 0.89, false); 
        groceryCart[4] = new Vegetable("Purple Carrots", 1.56, "Purple"); 
        groceryCart[5] = new Vegetable("Spinach", 2.32, "Green");
        groceryCart[6] = new Vegetable("Carrots", 1.45, "Orange");
        groceryCart[7] = new Vegetable("Potatoes", 3.99, "Red");
        groceryCart[8] = new Vegetable("Broccoli", 5.21, "Green");
        groceryCart[9] = new Vegetable("Turnips", .99, "White");
        groceryCart[10] = new Vegetable("Onions", 1.99, "Yellow");
        groceryCart[11] = new Fruit("Apples", 5.79, true);
        groceryCart[12] = new Fruit("Banana", .78, false);
        groceryCart[13] = new Fruit("Kiwi", 2.65, true);
        groceryCart[14] = new Fruit("Strawberry", 4.79, true);
        groceryCart[15] = new Fruit("Watermelon", 6.32, false);

        displayCart(groceryCart);

        //searching
        Scanner scan = new Scanner(System.in);
        System.out.print("How many items would you like to search for? ");
        int numSearches = 0;
        while(true){
            if(scan.hasNextInt()){
                numSearches = scan.nextInt();
                scan.nextLine();
                if(numSearches > 0){
                    break;
                } else{
                    System.out.print("Invalid, integer must be greater than 0: ");
                }
            } else{
                System.out.print("Invalid, not an integer: ");
                scan.next();
            }
        }

        for(int i = 0; i < numSearches; i++){
            System.out.print("What item would you like to search for? (Enter a name): ");
            String itemName = scan.nextLine();
            searchCart(groceryCart, itemName);
        }

        //displaying sorted cart
        sortByPrice(groceryCart);
        System.out.println("Your cart sorted by price: ");
        for(Food f: groceryCart){
            if(f != null){
                System.out.println(f);
            }
        }

        checkOut(groceryCart);
    }

    /**
    * This method is used to display the cart
    * of Foods with their corresponding attributes
    * @param list This is the first parameter 
    * @return void This returns nothing
    */
    public static void displayCart(Food[] list){
        for(Food f: list){
            if(f != null){
                System.out.println(f);
            }
        }
    }

    /**
    * This method is used to search the cart
    * for a user inputted key and then display
    * its information
    * @param list This is the first parameter 
    * @param foodName  This is the second parameter
    * @return void  This returns nothing
    */
    public static void searchCart(Food[] list, String foodName){
        boolean found = false;
        for(Food f: list){
            if(f != null && f.getName().equals(foodName)){
                System.out.println("Item found in your cart: ");
                System.out.println(f.toString());
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Item not found in your cart.");
        }
    }


    /**
    * This method is used to sort the cart in descending
    * order utilizing insertion sort
    * @param cart This is the first parameter 
    * @return void This returns nothing
    */
    public static void sortByPrice(Food[] cart){
        for(int i = 1; i < cart.length; i++){
            if(cart[i] != null){
                Food current = cart[i];
                int j = i - 1;
                for(; j >= 0 && cart[j].getPrice() > current.getPrice(); j--){
                    cart[j + 1] = cart[j];
                }
                cart[j + 1] = current;
            }
        }     
    }

    /**
    * This method is used to find the total number of items
    * and add each value held by the items in the cart, it then
    * uses this information to display the total cost and the
    * average cost of each item
    * @param cart This is the first parameter 
    * @return void This returns nothing
    */
    public static void checkOut(Food[] cart){
        double totalCost = 0.0;
        int numItems = 0;
        for(Food f: cart){
            if(f != null){
                totalCost += f.getPrice();
                numItems++;
            } 
        }

        double avgPrice = totalCost / numItems;
        System.out.printf("Total cost: $%.2f", totalCost);
        System.out.println();
        System.out.printf("Average cost per item: $%.2f", avgPrice);
    }
}
