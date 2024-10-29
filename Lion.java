package dennis.zoo.com;

public class Lion extends dennis.zoo.com.Animal {
    // Create a static int that keep track of the number of Lions created.
    static int numOfLions = 0;

    // Create a constructor.
    public Lion(){
        super();
        numOfLions++;
    }

    // Create a constructor that will have all the fields I want.
    public Lion(String sex, int age, int weight, String animalName,
                 String animalID, String animalBirthDate, String animalColor,
                 String animalOrigin){
        super(sex, age, weight, animalName, animalID, animalBirthDate, animalColor, animalOrigin);
        numOfLions++;
    }



}
