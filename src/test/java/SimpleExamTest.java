import Esame.MaskAndRepeatUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleExamTest {
    @Test
    public void simpleTest() {
        Assertions.assertEquals(MaskAndRepeatUtils.maskAndFillToLength("abc", '*', 2, 6), "a*ca*c");
    }
    @Test
    public void simpleTest2() {
        Assertions.assertEquals(MaskAndRepeatUtils.maskAndFillToLength("abc", '*', 2, 4), "a*ca");
    }
}
