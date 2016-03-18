package com.dmitry;

public class JokeTeller {
    public String tellJokes(){

        String str = "";
        int random = (int)(Math.random() * 3 + 1);

        String joke1 = "This is a very funny joke";
        String joke2 = "This joke is sarcastic";
        String joke3 = "This joke is super nice";

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
