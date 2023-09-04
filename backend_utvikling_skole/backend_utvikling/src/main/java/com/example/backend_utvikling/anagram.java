package com.example.backend_utvikling;


import java.util.ArrayList;
import java.util.Arrays;

public class anagram {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("race");
        words.add("acer");
        words.add("lars");
        words.add("sral");
        words.add("adecimalpoint");
        words.add("imadotinplace");
        words.add("restaurant");
        words.add("runsatreat");
        words.add("runastreat");
        anagrams(words);
    }
    public static String sortWord(String word){
        char[] list = word.toCharArray();
        Arrays.sort(list);
        word = Arrays.toString(list);


        return word;
    }

    public static ArrayList<String> anagrams(ArrayList<String> words){

        ArrayList<String> wordsAlphabetic = new ArrayList<>(words);

        for (int i = 0; i < words.size(); i++) {
            wordsAlphabetic.set(i, sortWord(words.get(i)));
        }

        ArrayList<String> anagrams = new ArrayList<>();
        for (int i = 0; i < words.size()-1;) {
            for (int j = 1; j < words.size(); j++) {
                if (wordsAlphabetic.get(i).equals(wordsAlphabetic.get(j))){
                    anagrams.add(words.get(i) + " = " + words.get(j));
                }
            }
            wordsAlphabetic.remove(i);
            words.remove(i);

        }
        for (int i = 0; i < anagrams.size(); i++) {
            System.out.println(anagrams.get(i));
        }
        return anagrams;
    }

}
