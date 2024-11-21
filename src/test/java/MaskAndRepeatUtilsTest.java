import Esame.MaskAndRepeatUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

public class MaskAndRepeatUtilsTest {

    @ParameterizedTest
    @MethodSource("generator")
    public void testMaskAndRepeat(final String str, final char maskChar, final int interval, final int maxLength, String expected) {
        Assertions.assertEquals(MaskAndRepeatUtils.maskAndFillToLength(str, maskChar, interval, maxLength), expected);
    }

    static Stream<Arguments> generator() {
        return Stream.of(
                of(null, "*", 1, 3, null),
                of("", "*", 1, 3, ""),
                of("", "*", -1, 3, null),
                of("", "*", 1, -3, null),
                of("Ciao", "X", 2, 11, "CXaXCXaXCXa"),
                of("Ciao", "X", 2, 12, "CXaXCXaXCXaX"),
                of("Ciao", "X", 2, 3, "CXa"),
                of("Ciao", "X", 5, 3, "Cia")

        );
    }

}
