import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SnakeTests {
    @Test
    void getSnakeLength() {
        Snake snake = new Snake();
        snake.setLength(10);
        Assertions.assertEquals(10,snake.getLength());
    }

}
