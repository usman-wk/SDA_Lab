
import java.time.LocalDateTime;

public interface Logger {
    void info(String message);
    class Console implements Logger {
        @Override
        public void info(String message) {
            System.out.println(LocalDateTime.now() + "  " + message);
        }
    }
}
