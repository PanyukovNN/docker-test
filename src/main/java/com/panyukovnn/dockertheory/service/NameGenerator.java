package com.panyukovnn.dockertheory.service;

import java.util.Calendar;
import java.util.Random;

public class NameGenerator {

    private static final int diffBetweenAtoZ = 25;
    private static final int charValueOfa = 97;
    private String lastGeneratedName = "";
    int length;

    char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public NameGenerator(int lengthOfName) {
        if (lengthOfName < 5 || lengthOfName > 10) {
            System.out.println("Setting default length to 7");
            lengthOfName = 7;
        }

        this.length = lengthOfName;
    }

    public String getName() {
        while (true) {
            Random randomNumberGenerator = new Random(Calendar.getInstance()
                    .getTimeInMillis());

            char[] nameInCharArray = new char[length];

            for (int i = 0; i < length; i++) {
                if (positionIsOdd(i)) {
                    nameInCharArray[i] = getVowel(randomNumberGenerator);
                } else {
                    nameInCharArray[i] = getConsonant(randomNumberGenerator);
                }
            }
            nameInCharArray[0] = Character.toUpperCase(nameInCharArray[0]);

            String currentGeneratedName = new String(nameInCharArray);

            if (!currentGeneratedName.equals(lastGeneratedName)) {
                lastGeneratedName = currentGeneratedName;
                return currentGeneratedName;
            }
        }
    }

    private boolean positionIsOdd(int i) {
        return i % 2 == 0;
    }

    private char getConsonant(Random randomNumberGenerator) {
        while (true) {
            char currentCharacter = (char) (randomNumberGenerator
                    .nextInt(diffBetweenAtoZ) + charValueOfa);

            boolean correctCharacter = currentCharacter == 'a' || currentCharacter == 'e'
                    || currentCharacter == 'i' || currentCharacter == 'o'
                    || currentCharacter == 'u';

            if (!correctCharacter) {
                return currentCharacter;
            }
        }

    }

    private char getVowel(Random randomNumberGenerator) {
        return vowels[randomNumberGenerator.nextInt(vowels.length)];
    }
}
