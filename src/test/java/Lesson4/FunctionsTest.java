package Lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FunctionsTest {
    AreaOfTriangle areaOfTriangle = new AreaOfTriangle();
    @Test
    void testWithNegativeNumber (){
        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            areaOfTriangle.area(3, 2, -1);
        });
        assertEquals(exception.getMessage(), "Отрицательные значения сторон недопустимы");
    }

    @Test
    void testWithZero (){
        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            areaOfTriangle.area(0, 3,2);
        });
        assertEquals(exception.getMessage(), "Сторона треугольника не может иметь значение 0");
    }

    @Test
    void testWithPositiveNumber () {
        double result = areaOfTriangle.area(2, 2, 2);
        Assertions.assertEquals(result, 1.7320508075688772);
    }
}
