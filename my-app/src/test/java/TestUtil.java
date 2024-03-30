import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void testOneArgument() {
    assertFalse(c.compute(38));
  }

  @Test
  public void testEvenNumberOfArguments() {
    assertFalse(c.compute(38, 39));
  }

  @Test
  public void testWithZero() {
    assertThrows(RuntimeException.class, () -> c.compute(0, 38, 39));
  }

  @Test
  public void testSumDivisibleByAnArgument() {
    assertTrue(c.compute(38, 39, 40));
  }

  @Test
  public void testSumNotDivisibleByAnyArgument() {
    assertFalse(c.compute(38, 17, 50));
  }
}