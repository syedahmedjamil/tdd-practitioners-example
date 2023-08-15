package org.example;

import java.util.*;

public class TransitiveDependencies {

    List<String> dependencies;

    public TransitiveDependencies(List<String> dependencies) {
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
        var directDependencies = "";
        for (var value : dependencies) {
            if (value.charAt(0) == startingPoint) {
                directDependencies = value.substring(1);
            }
        }
        return directDependencies;
    }

    private String getUniqueDependencies(String value) {
        Set<String> uniqueDependencies = new TreeSet<>();
        Collections.addAll(uniqueDependencies, value.split(""));
        return String.join("", uniqueDependencies);
    }
}