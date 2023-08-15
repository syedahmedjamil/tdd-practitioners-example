package org.example;

import java.util.*;

public class TransitiveDependenciesMapImpl {

    Map<Character, String> dependencies;

    public TransitiveDependenciesMapImpl(Map<Character, String> dependencies) {
        this.dependencies = dependencies;
    }

    public String listDependencies(char startingPoint) {

        var result = getDirectDependencies(startingPoint);

        for (int index = 0; index < result.length(); index++) {
            result += getDirectDependencies(result.charAt(index));
        }

        result = getUniqueDependencies(result);

        return result;
    }

    private String getDirectDependencies(char startingPoint) {
        return dependencies.getOrDefault(startingPoint, "");
    }

    private String getUniqueDependencies(String value) {
        Set<String> uniqueDependencies = new TreeSet<>();
        Collections.addAll(uniqueDependencies, value.split(""));
        return String.join("", uniqueDependencies);
    }
}