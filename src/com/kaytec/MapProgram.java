package com.kaytec;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();

        languages.put("java", "a compiled, object oriented platform independent language");
        languages.put("python", "interpreted obj oriented, high level programming language with dynamic semantics");
        languages.put("algol", "algorithmic language");
        languages.put("BASIC", "Beginners all purpose symbolic instruction code");
        languages.put("LISP", "high level programming language originally created for mathematical notation for computer" +
                " programs");
        // retrieve from map
        System.out.println(languages.get("java"));
        // override prev value for key
        languages.put("java", "A new description");
        System.out.println(languages.get("java"));

        // put returns prev value for that key (null if setting for first time)
        System.out.println(languages.put(
                "thing", "interesting description"
        ));
        System.out.println(languages.put(
                "thing", "exciting description"
        ));

        // check if key already exists in map using containsKey method
        String languageToAdd = "java";
        if (languages.containsKey(languageToAdd)){
            System.out.println(String.format("%s already exists in map", languageToAdd));
        } else {
            System.out.println(String.format("%s not found in map", languageToAdd));
        }
        languageToAdd = "c++";
        if (languages.containsKey(languageToAdd)) {
            System.out.println(String.format("%s was also found in the map", languageToAdd));
        } else {
            System.out.println(String.format("%s was not found in the map", languageToAdd));
        }

        // removing entries w/ remove method
        languages.remove("java");
        System.out.println(languages.containsKey("java"));

        // removing a key-val match
        if (languages.remove("thing", "fdjlsjf")) {
            System.out.println("Removed the entry");
        } else {
            System.out.println("Entry not removed, could not find key/val pair");
        }

        System.out.println("=======================- SEE MAP BELOW -============");
        // retrieve a set of keys existing in the map w/ keySet method
        for(String key: languages.keySet()) {
            System.out.print(key);
            System.out.print("-----> " + languages.get(key) + "\n");
        }


    }
}
