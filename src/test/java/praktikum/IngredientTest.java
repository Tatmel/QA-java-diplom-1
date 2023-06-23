package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Получение типа, наименования и цены ингредиента. Тестовые данные: {0}, {1}, {2}")
    public static Object[][] getData() {
        return new Object[][] {
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "", 50},
                {IngredientType.FILLING, "тест", 50},
                {IngredientType.SAUCE, "sour cream", 0},
                {IngredientType.FILLING, "sausage", -1}
        };
    }

    @Before
    public void init() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void checkGetName() {
        String actual = ingredient.getName();
        Assert.assertEquals("Ошибка: наименование булки НЕ совпадает с ожидаемым значением",name, actual);
    }

    @Test
    public void checkGetPrice() {
        float actual = ingredient.getPrice();
        Assert.assertEquals("Ошибка: цена булки НЕ совпадает с ожидаемым значением",price, actual, 0.001);
    }

    @Test
    public void checkGetType() {
        IngredientType actual = ingredient.getType();
        Assert.assertEquals("Ошибка: тип булки НЕ совпадает с ожидаемым значением",type, actual);
    }
}

