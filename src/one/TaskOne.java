package one;

import java.io.IOException;

/**
 * <p>Задание 1.</p>
 * <p>Написать программу ”Hello, World!”. В ходе выполнения программы она должна
 * выбросить исключение и завершиться с ошибкой.
 * Смоделировав ошибку «NullPointerException»
 * Смоделировав ошибку «ArrayIndexOutOfBoundsException»
 * Вызвав свой вариант ошибки через оператор throw</p>
 */

/**
 * Class task 1
 */
public class TaskOne {

    /**
     * <p>Modeling the NullPointerException error</p>
     *
     * @throws NullPointerException
     */
    public void modelNullPointerException() {
        String str = null;
        try {
            System.out.println(str.length());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    /**
     * <p>Modeling the ArrayIndexOutOfBoundsException error</p>
     *
     * @throws ArrayIndexOutOfBoundsException
     */
    public void modelArrayIndexOutOfBoundsException() {
        int indx = 0;
        int[] nArray = new int[5];

        while (true) {
            try {
                nArray[indx] = indx;
            } catch (Exception ex) {
                System.out.println(ex.toString());
                break;
            }
            indx++;
        }
    }

    /**
     * <p>Modeling my exception with throw </p>
     *
     * @throws NullPointerException
     */
    public void modelThrowMyException() {
        try {
            throw new IOException("Something exception");
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

}
