package gradle.udacity.com;

import java.util.Random;

public class JokeTeller {

    String jokes[] = new String[10];
    Random random = new Random();


    public String tellJoke(){

        jokes[0]="There are only 10 types of people in the world: those that understand binary and those that don’t.";
        jokes[1]="Computers make very fast, very accurate mistakes.";
        jokes[2]="Artificial intelligence usually beats real stupidity.";
        jokes[3] = "Computers are like air conditioners: they stop working when you open Windows.";
        jokes[4]="If at first you don’t succeed; call it version 1.0.";
        jokes[5]="Programmers are tools for converting caffeine into code.";
        jokes[6]="Evolution is God’s way of issuing upgrades.";
        jokes[7]="Hacking is like sex. You get in, you get out, and hope that you didn’t leave something that can be traced back to you.";
        jokes[8]="Programming today is a race between software engineers striving to build bigger and better idiot-proof programs, and the Universe trying to produce bigger and better idiots. So far, the Universe is winning.";
        jokes[9]="The code that is the hardest to debug is the code that you know cannot possibly be wrong.";

        return jokes[random.nextInt(9)];

    }



}
