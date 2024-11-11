import Capitolo3.LeftPadUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;
import java.util.List;

public class Example {

    @Test
    @DisplayName("str Test")
    void strTest() {
        Assertions.assertEquals(LeftPadUtils.leftPad("", 2, "a"), "aa");
        Assertions.assertEquals(LeftPadUtils.leftPad(null, 2, "a"), null);

        Assertions.assertEquals(LeftPadUtils.leftPad("a", -1, "a"), "a");

        Assertions.assertEquals(LeftPadUtils.leftPad("a", 3, ""), "  a");
        Assertions.assertEquals(LeftPadUtils.leftPad("a", 3, null), "  a");
        Assertions.assertEquals(LeftPadUtils.leftPad("a", 3, "c"), "cca");

        Assertions.assertEquals(LeftPadUtils.leftPad("a", 1, "asd"), "a");
        Assertions.assertEquals(LeftPadUtils.leftPad("a", 0, "dasfas"), "a");
        Assertions.assertEquals(LeftPadUtils.leftPad("aasdsad", 3, "dasd"), "aasdsad");


    }

    @Test
    @Disabled("Test disabilitato")
    @DisplayName("Test disabilitato")
    public void test() {
        Assertions.assertEquals(true, true);
    }

    @Test
    @DisplayName("Sono il test2")
    public void test2() {
        Assertions.assertEquals(true, true);
    }

    @Test
    @DisplayName("Multi assertion")
    void multiAssertion() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, numbers.get(0)),
                () -> Assertions.assertEquals(2, numbers.get(1)),
                () -> Assertions.assertEquals(6, numbers.get(5))
        );
    }



    @Test
    @DisplayName("Test api version")
    void testApiVersion() {
        Assumptions.assumeTrue(10 > 10);
        Assertions.assertEquals(11, 11);
    }

    @ParameterizedTest(name = "{0}")
    @DisplayName("Test paramettici")
    @ValueSource(ints = {1, 2})
    void testParamettici(int n) {
        Assertions.assertEquals(n , n);
    }
}
