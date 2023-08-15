package org.example;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //List implementation
        var dependenciesList = List.of(
                "ABC",
                "BCE",
                "CG",
                "DAF",
                "EF",
                "FH");
        Character[] startingPoints = {'A', 'B', 'C', 'D', 'E', 'F'};

        TransitiveDependencies td = new TransitiveDependencies(dependenciesList);
        TransitiveDependenciesUI ui = new TransitiveDependenciesUI(System.out::println);

        System.out.println("\nList:");
        for (var startingPoint : startingPoints) {
            ui.showFormattedResult(startingPoint, td.listDependencies(startingPoint));
        }

        //Map implementation
        var dependenciesMap = Map.of(
                'A', "BC",
                'B', "CE",
                'C', "G",
                'D', "AF",
                'E', "F",
                'F', "H");
        TransitiveDependenciesMapImpl tdMap = new TransitiveDependenciesMapImpl(dependenciesMap);

        System.out.println("\nMap:");
        for (var startingPoint : startingPoints) {
            ui.showFormattedResult(startingPoint, tdMap.listDependencies(startingPoint));
        }
    }
}