package Lesson4;

public class AreaOfTriangle {

    public double area(int a, int b, int c) {
        double s;

        if (a < 0 || b < 0 || c < 0){
            throw new UnsupportedOperationException("Отрицательные значения сторон недопустимы");
        } if (a == 0 || b == 0 || c == 0) {
            throw new UnsupportedOperationException("Сторона треугольника не может иметь значение 0");
        } if ( a + b < c && b + c < a && c + a < b) {
            throw new UnsupportedOperationException("У треугольника сумма двух сторон должна быть больше третьей");
        }

        double p = (double) (a + b + c) / 2;
        s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }
}
