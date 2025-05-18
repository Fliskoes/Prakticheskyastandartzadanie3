import org.example.BonusService;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
public class BonusServiceTest {
    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 50;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        // производим проверку (сравниваем ожидаемый и

    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 1000;
        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        // производим проверку (сравниваем ожидаемый и
    }
}