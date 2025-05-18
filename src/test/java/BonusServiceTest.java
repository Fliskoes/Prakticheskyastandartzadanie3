import org.example.BonusService;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals(expected, actual);
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
        assertEquals(expected, actual);
    }
    @Test
    void shouldReturnMaxBonusWhenRegisteredAndLargeAmount() {
        BonusService service = new BonusService();
        long amount = 50_000; // 5% от 50_000 = 2500, но лимит 1000
        boolean registered = true;

        long expected = 1000;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    // Тест 2: Проверка 1% бонуса для незарегистрированного при малой сумме
    @Test
    void shouldReturnOnePercentForUnregisteredAndSmallAmount() {
        BonusService service = new BonusService();
        long amount = 500; // 1% от 500 = 5
        boolean registered = false;

        long expected = 5;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}