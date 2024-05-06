import java.util.Scanner;

public class DogApplication {
    public static void main(String[] args) {
        int select;
        Scanner input = new Scanner(System.in);

        // Display welcome message and instructions
        displayInstructions();

        // Prompting the user to enter the pet's name
        System.out.println("Who is the goodest boy ever? (Enter your virtual dog's name)");
        String dogName = input.nextLine();

        //Creating a new virtual pet object
        Dog dog = new Dog(dogName);

        int feedCount = 0;


        //loops until the pet is fully fed
        while (feedCount < 3) {
            System.out.println("\nDog's current health: " + dog.getHealth());
            System.out.println("What do you want to do to improve " + dogName + "'s health?");
            System.out.println(">> [0] Feed " + dogName + ".");
            System.out.println(">> [1] Play with " + dogName + ".");
            System.out.println(">> [2] Give " + dogName + " a bath.");
            System.out.println(">> [3] Take " + dogName + " for a walk.");
            System.out.println(">> [4] Let " + dogName + " take a nap.");
            System.out.println(">> [5] Quit.");

            select = input.nextInt();
            
            //Performs the actions based on what the user inputs
            switch (select) {
                case 0:
                    dog.feed();
                    feedCount++;
                    break;
                case 1:
                    dog.play();
                    break;
                case 2:
                    dog.giveBath();
                    break;
                case 3:
                    dog.walk();
                    break;
                case 4:
                    dog.nap();
                    break;
                case 5:
                    System.out.println("Exiting game. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }


            // this stimulates the time passing for the pet
            dog.tick();


            //this checks if all the activities are maxed out
            if (dog.allActivitiesMaxed()) {
                System.out.println("Come back tomorrow to take care of me, please.");
                System.exit(0);
            }
        }


        //once the pet is fully  fed it displays this message.
        System.out.println(dogName + " is now fully fed and ready to enjoy all activities!");
        input.close();

        // ASCII art of a happy dog
        System.out.println("Happy Dog:");
        System.out.println("  __      _");
        System.out.println("o'')}____//");
        System.out.println(" `_/      )");
        System.out.println(" (_(_/-(_/");
    }

    // Method to display welcome message and instructions
    public static void displayInstructions() {
        // ASCII art of a dog
        System.out.println("  / \\__");
        System.out.println(" (    @\\___");
        System.out.println(" /         O");
        System.out.println("/   (_____/");
        System.out.println("/_____/ U");


        // This is just a welcome messsage and instructions for the user
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println(">> Welcome to parenthood! You are now the proud new owner of a virtual dog!");
        System.out.println(">> Being a pet owner is a lot of work. Your virtual dog requires your care and attention!");
        System.out.println(">> You need to feed your virtual dog three times to fully nourish it. Then it is ready for all the activities.");
        System.out.println(">> After the dog is satisfied it will say Bye and you'd have to come back and provide food and attention tomorrow. Good luck!");
        System.out.println("-----------------------------------------------------------------------------------------------");

        
    }
}

class Dog {
    private String name;
    private int health;


    //To initialize the pet's name and health
    public Dog(String name) {
        this.name = name;
        this.health = 0;
    }


    //this is the getter method to see pet's health
    public int getHealth() {
        return health;
    }


    //Method to feed the pet
    public void feed() {
        System.out.println("You feed " + name + ". Health +5");
        health += 5;
    }

    //method to play with the pet
    public void play() {
        System.out.println("You play with " + name + ". Health +10");
        health += 10;
    }


    //method to give a bath to the pet
    public void giveBath() {
        System.out.println("You give " + name + " a bath. Health +3");
        health += 3;
    }


    //method to walk the pet
    public void walk() {
        System.out.println("You take " + name + " for a walk. Health +7");
        health += 7;
    }


    //method to let the pet take a nap
    public void nap() {
        System.out.println("You let " + name + " take a nap. Health +25");
        health += 25;
    }


    //method to stimulate the time passing for the pet
    public void tick() {
    }


    //method to check if all the activities are maxed out or not. 
    public boolean allActivitiesMaxed() {
        return health >= 50;
    }
}