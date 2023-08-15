import org.example.TransitiveDependencies;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTransitiveDependencies {

    private String getResult(List<String> dependencies, char startingPoint) {
        TransitiveDependencies td = new TransitiveDependencies(dependencies);
        return td.listDependencies(startingPoint);
    }

    @Test
    void test_should_return_first_direct_dependency() {
        var dependencies = List.of("AB");
        var startingPoint = 'A';
        var result = getResult(dependencies, startingPoint);
        assertEquals("B", result);
    }

    @Test
    void test_should_return_all_direct_dependencies() {
        var dependencies = List.of("ABC");
        var startingPoint = 'A';
        var result = getResult(dependencies, startingPoint);
        assertEquals("BC", result);
    }

    @Test
    void test_should_return_one_level_deep_transitive_dependencies() {
        var dependencies = List.of(
                "AB",
                "BC");
        var startingPoint = 'A';
        var result = getResult(dependencies, startingPoint);
        assertEquals("BC", result);
    }

    @Test
    void test_should_return_two_level_deep_transitive_dependencies() {
        var dependencies = List.of(
                "AB",
                "BC",
                "CD");
        var startingPoint = 'A';
        var result = getResult(dependencies, startingPoint);
        assertEquals("BCD", result);
    }

    @Test
    void test_should_return_unique_dependencies_when_duplicates_in_direct_and_transitive() {
        var dependencies = List.of(
                "ABCCD",
                "BDCC");
        var startingPoint = 'A';
        var result = getResult(dependencies, startingPoint);
        assertEquals("BCD", result);
    }

    @Test
    void test_should_return_sorted_dependencies() {
        var dependencies = List.of(
                "AZYX");
        var startingPoint = 'A';
        var result = getResult(dependencies, startingPoint);
        assertEquals("XYZ", result);
    }
}
