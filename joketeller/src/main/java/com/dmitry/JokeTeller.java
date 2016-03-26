package com.dmitry;

public class JokeTeller {
    public String tellJokes(){

        String str = null;
        int random = (int)(Math.random() * 3 + 1);

        String joke1 = "Girl: You would be a good dancer except for two things. \n" +
                "Boy: What are the two things? \n" +
                "Girl: Your feet. ";
        String joke2 = "Teacher: Do you have trouble making decisions? \n" +
                "Student: Well...yes and no.";
        String joke3 = "In a restaurant:\n" +
                "Customer: Waiter, waiter! There is a frog in my soup!!! \n" +
                "Waiter: Sorry, sir. The fly is on vacation. ";

        switch (random){
            case 1: str = joke1;
                break;
            case 2: str = joke2;
                break;
            case 3: str = joke3;
                break;
        }
        return str;
    }
}
