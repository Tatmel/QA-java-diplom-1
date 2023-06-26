package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;
    private String name;
    private float price;
    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Получение наименования и цены булки. Тестовые данные: {0}, {1}")
    public static Object[][] getData() {
        return new Object[][] {
                {"black bun", 100},
                {"t", 200},
                {"white bun", 0},
                {"", 100},
                {"red bun", -1},
                {null, 150},
                {"ОченьДлиннаяСтрокаОченьДлиннаяСтрокаОченьДлиннаяСтрокаОченьДлиннаяСтрока", 100},
                {"'_спец.символы&?", 50},
                {" ", 150},
                {"black bun", +Float.MIN_VALUE},
                {"white bun", Integer.MAX_VALUE}
        };
    }

    @Before
    public void init() {
        bun = new Bun(name, price);
    }

    @Test
    public void checkGetName() {
        String actual = bun.getName();
        Assert.assertEquals("Ошибка: наименования НЕ совпадают",name, actual);
    }

    @Test
    public void checkGetPrice() {
        float actual = bun.getPrice();
        Assert.assertEquals("Ошибка: цены НЕ совпадают",price, actual, 0.001);
    }
}