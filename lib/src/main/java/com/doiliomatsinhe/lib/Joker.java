package com.doiliomatsinhe.lib;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Joker {

    private List<String> jokesList = Arrays.asList("A lion would never cheat on his wife\nBut a Tiger Wood", "Why can't bicycles stand up on their own?\nAns: They are two tired.",
            "Did you hear about the constipated mathematician?\nHe worked his problem out with a pencil.\nIt was a number 2 pencil",
            "Did you hear about the kidnapping at school?\nIt's ok, he woke up.",
            "Did you hear about the two radio antennas that got married?\nWell they said the wedding was okay, but the reception was awesome!",
            "How do you make a dog drink?\nPut it in the blender",
            "Last night in bed, I was gazing up at the stars and thinking to myself...\n Where the hell is my roof?",
            "Two potatoes are standing on the corner. How do you know which one of them is a prostitute?\nThe one with the label 'Idaho'",
            "What did the doctor say to the midget waiting in the lobby?\n You're just going to have to be a litte patient",
            "I once farted in an elevator...\nIt was wrong on so many levels");

    public String getJoke() {
        Random random = new Random();

        return jokesList.get(random.nextInt(jokesList.size()));
    }
}
