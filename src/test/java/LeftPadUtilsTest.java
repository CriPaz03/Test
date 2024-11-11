import Capitolo3.LeftPadUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

public class LeftPadUtilsTest {

    @ParameterizedTest
    @MethodSource("generator")
    @DisplayName("str Test")
    void strTest(String originalStr, int size, String padString, String expectedStr) {
        Assertions.assertEquals(LeftPadUtils.leftPad(originalStr, size, padString), expectedStr);
    }

    static Stream<Arguments> generator() {
        return Stream.of(
                of("", 2, "a", "aa"),
                of(null, 2, "a", null),
                of("a", -1, "a", "a"),
                of("", 1, "a", "a"),
                of("aaa", 4, "aa", "aaaa"),
                of("a", 3, "", "  a"),
                of("a", 3, null, "  a"),
                of("a", 3, "c", "cca"),
                of("a", 1, "asd", "a"),
                of("a", 0, "dasfas", "a"),
                of("aasdsad", 3, "dasd", "aasdsad")
        );
    }

}