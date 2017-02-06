package com.example;

import java.util.Random;

public class JokesLibrary {

    private static String jokes[] = {
            "What's the definition of bravery?\nA man with diarrhea chancing a fart!",
            "A : I'am sick, \nB : You will walk with a stick",
            "A banana peel and a banana are robbing a store\nDon't worry,says the peel. I've got you covered!",
            "You beat me, I will put you on a boat",
            "I asked my grandma if she had ever tried 69. She said No! but I have done 53 -- that's all the sailors I could screw in one night."
    };

    public static String getJoke() {
        return jokes[new Random().nextInt(jokes.length)];
    }
}
