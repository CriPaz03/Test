import Esame.MaskAndRepeatUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

public class MaskAndRepeatUtilsTest {

    @ParameterizedTest
    @MethodSource("generator")
    @DisplayName("I test the maskAndFillToLength method of the MaskAndRepeatUtils class")
    public void testMaskAndRepeat(final String str, final char maskChar, final int interval, final int maxLength, String expected) {
        Assertions.assertEquals(MaskAndRepeatUtils.maskAndFillToLength(str, maskChar, interval, maxLength), expected);
    }

    static Stream<Arguments> generator() {
        return Stream.of(
                of("", "*", 1, 3, ""),
                of(null, "*", 1, 3, null),

                of("pippo", "*", 2, 5, "p*p*o"),
                of("pippo", " ", 2, 5, "p p o"),

                of("", "*", -1, 3, null),

                of("", "*", 1, -3, null),

                of("Ciao", "X", 2, 3, "CXa"),
                of("Ciao", "X", 5, 2, "Ci"),
                of("Ciao", "X", 5, 6, "CiaoCi"),

                of("Ciao", "§", 2, 8, "C§a§C§a§"),
                of("Ciao", "*", Integer.MAX_VALUE, 4, "Ciao"),
                of("Ciao", "*", Integer.MIN_VALUE, 4, null),
                of("Ciao", "*", 3, Integer.MIN_VALUE, null),
                of("Ciao", "*", Integer.MIN_VALUE, Integer.MAX_VALUE, null),
                of("Ciao", "*", Integer.MAX_VALUE, Integer.MIN_VALUE, null)

        );
    }

}
