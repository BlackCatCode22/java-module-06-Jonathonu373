package Jonathon.zoo.com;

public class Hyena extends Jonathon.zoo.com.Animal {
    // Create a static int that keep track of the number of hyenas created.
    static int numOfHyenas = 0;

    // Create a constructor.
    public Hyena(){
        super();
        numOfHyenas++;
    }
}