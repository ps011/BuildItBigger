package gradle.udacity.com;

import java.util.Random;

public class JokeTeller {

    String jokes[] = new String[3];
    Random random = new Random();


    public String tellJoke(){

        jokes[0]="India";
        jokes[1]="Pakistan";
        jokes[2]="China";

        return jokes[random.nextInt(2)];

    }



}
