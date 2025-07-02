import java.time.LocalDateTime;

public class ConsoleLogger implements Logger {
    @Override
    public void info(String message) {
        System.out.println(LocalDateTime.now() + "  " + message);
    }
}
