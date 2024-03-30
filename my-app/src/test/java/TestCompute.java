import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestCompute {
  Compute c;

  @Test
  public void testMessageQueueEmpty() {
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(0);
    
    c = new Compute(mq);
    assertEquals(-1, c.countNumberOfOccurrences("utku"));
  }

  @Test
  public void testMessageNotFound() {
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(1);
    when(mq.contains("utku")).thenReturn(false);
    
    c = new Compute(mq);
    assertEquals(0, c.countNumberOfOccurrences("utku"));
  }

  @Test
  public void testMessageFound() {
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(5);
    when(mq.contains("utku")).thenReturn(true);
    when(mq.getAt(0)).thenReturn("utku");
    when(mq.getAt(1)).thenReturn("emre");
    when(mq.getAt(2)).thenReturn("mehmet");
    when(mq.getAt(3)).thenReturn("mücahit");
    when(mq.getAt(4)).thenReturn("ibrahim");
    
    c = new Compute(mq);
    assertEquals(1, c.countNumberOfOccurrences("utku"));
  }
}