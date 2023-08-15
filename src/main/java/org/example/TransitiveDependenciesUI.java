package org.example;

import java.util.function.Consumer;
import java.util.function.Function;

public class TransitiveDependenciesUI {

    Display display;

    public TransitiveDependenciesUI(Display display) {
        this.display = display;
    }

    public void showFormattedResult(char startingPoint, String result) {
        display.print(startingPoint + "->" + result);
    }
}
