package two;

import java.security.SecureRandom;

/**
 * <p>Задание 2</p>
 * <p>Составить программу, генерирующую N случайных чисел.
 * Для каждого числа k вычислить квадратный корень q.
 * Если квадрат целой части q числа равен k, то вывести это число на экран.
 * Предусмотреть что первоначальные числа могут быть отрицательные,
 * в этом случае генерировать исключение.</p>
 */

/**
 * Class task 2
 */
public class TaskTwo {
    private SecureRandom random = new SecureRandom();

    /**
     * <p>Generator N random number. For each number k calculates square root q.</p>
     * <p>If square root integer root q = k print this number on the display.
     * If k less 0 then generates exception ArithmeticException.</p>
     *
     * @param sizeRandomNumb size random numbers
     */
    public void genRandomNumb(int sizeRandomNumb) {
        double sqrtQ[] = new double[sizeRandomNumb];
        byte bytes[] = new byte[sizeRandomNumb];
        this.random.nextBytes(bytes);
        int cntEntrCmp = 0;
        for (int curRandomNumb = 0; curRandomNumb < bytes.length; curRandomNumb++) {
            try {
                if (bytes[curRandomNumb] < 0) {
                    throw new ArithmeticException();
                }
            } catch (Exception ex) {
                System.out.println("Сгенерировано отрицательное число");
                continue;
            }
            if (curRandomNumb == (int) Math.sqrt(bytes[curRandomNumb])) {
                System.out.println("Число " + Math.sqrt(bytes[curRandomNumb]) + " удовлетворяет условию : " +
                        "квадрат целой части q числа равен k");
                cntEntrCmp++;
            }
        }
        if (cntEntrCmp == 0) {
            System.out.println("Cгенерированные числа не удовлетворяют условию: квадрат целой части q числа равен k");
        }
    }
}
