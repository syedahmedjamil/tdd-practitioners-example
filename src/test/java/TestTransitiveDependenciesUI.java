import org.example.Display;
import org.example.TransitiveDependenciesUI;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestTransitiveDependenciesUI {

    @Test
    void test_should_display_formatted_result() {
        Display fakeDisplay = mock();
        TransitiveDependenciesUI ui = new TransitiveDependenciesUI(fakeDisplay);
        ui.showFormattedResult('X', "Y");
        verify(fakeDisplay).print("X->Y");
    }
}
