package com.udacity.gradle.jokesource;

import java.util.ArrayList;
import java.util.Collections;

public class JokeSource {
    public static String getJoke() {

        ArrayList<String> jokes = new ArrayList<>();
        jokes.add("Two peanuts walk into a bar...one was a salted");
        jokes.add("What type of computer sings?...A Dell");
        jokes.add("Which U.S. state has the smallest soft drinks?...Minisoda");
        jokes.add("I told a chemistry joke...there was no reaction");
        jokes.add("Where did the cat go after losing its tail?...To the retail store");
        jokes.add("What does a clock do when it's hungry?...It goes back four seconds");
        jokes.add("How do you make a tissue dance?...Put a little boogie in it");
        jokes.add("Why should you never use a dull pencil?...Because it's pointless");
        jokes.add("What does a painter do when he's cold?...He puts on another coat");
        jokes.add("What do you call a bear without any teeth?....A gummy bear");
        jokes.add("What kind of shorts do clouds wear?...Thunderwear");
        jokes.add("Why should you never fart in an Apple store?...Because they don't have Windows");
        jokes.add("A sheep, a drum, and a snake fall down a cliff...BA-DUMM-TSS");

        //Source: http://stackoverflow.com/questions/13213924/android-java-how-to-have-it-select-a-random-string-from-a-predetermined-list-of

        Collections.shuffle(jokes);
        return jokes.get(0);
    }
}
