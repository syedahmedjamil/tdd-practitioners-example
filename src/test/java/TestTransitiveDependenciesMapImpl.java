import org.example.Main;
import org.example.TransitiveDependencies;
import org.example.TransitiveDependenciesMapImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTransitiveDependenciesMapImpl {

    private String getResult(Map<Character, String> dependencies, char startingPoint) {
        TransitiveDependenciesMapImpl td = new TransitiveDependenciesMapImpl(dependencies);
        return td.listDependencies(startingPoint);
    }

    @Test
    void test_should_return_first_direct_dependency() {
        var dependencies = Map.of('A', "B");
        var startingPoint = 'A';
        var result = getResult(dependencies, startingPoint);
        assertEquals("B", result);
    }

    @Test
    void test_should_return_all_direct_dependencies() {
        var dependencies = Map.of('A', "BC");
        var startingPoint = 'A';
        var result = getResult(dependencies, startingPoint);
        assertEquals("BC", result);
    }

    @Test
    void test_should_return_one_level_deep_transitive_dependencies() {
        var dependencies = Map.of(
                'A', "B",
                'B', "C");
        var startingPoint = 'A';
        var result = getResult(dependencies, startingPoint);
        assertEquals("BC", result);
    }

    @Test
    void test_should_return_two_level_deep_transitive_dependencies() {
        var dependencies = Map.of(
                'A', "B",
                'B', "C",
                'C', "D");
        var startingPoint = 'A';
        var result = getResult(dependencies, startingPoint);
        assertEquals("BCD", result);
    }

    @Test
    void test_should_return_unique_dependencies_when_duplicates_in_direct_and_transitive() {
        var dependencies = Map.of(
                'A', "BCCD",
                'B', "DCC");
        var startingPoint = 'A';
        var result = getResult(dependencies, startingPoint);
        assertEquals("BCD", result);
    }

    @Test
    void test_should_return_sorted_dependencies() {
        var dependencies = Map.of(
                'A', "ZYX");
        var startingPoint = 'A';
        var result = getResult(dependencies, startingPoint);
        assertEquals("XYZ", result);
    }
}
