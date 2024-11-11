import Capitolo3.Clumps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Array;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;


public class ClumpsTest {
    @ParameterizedTest
    @MethodSource("generator")
    @DisplayName("test Clumps")
    void testClumps(int[] n, int result) {
        Assertions.assertEquals(Clumps.countClumps(n), result);

    }

    static Stream<Arguments> generator() {
        return Stream.of(
                of(null, 0),
                of(new int[]{}, 0),
                of(new int[]{1,4,4,4}, 1)
        );
    }

}
