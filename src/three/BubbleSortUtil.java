package three;

import java.util.Comparator;

public class BubbleSortUtil {

    /**
     * @throw AssertionError()
     */
    private BubbleSortUtil() {
        throw new AssertionError();
    }

    /**
     * Sort Array objects with bubble sort. For standard cal
     * @param array the array to be sorted
     * @param <T> the class of the objects to be sorted
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        bubbleSortInAscOrder(array);
    }

    /**
     * Sort Array objects with bubble sort and comparator. For standard cal
     * @param array the array to be sorted
     * @param comparator the comparator to determine the order of the array
     * @param <T> the class of the objects to be sorted
     */
    public static <T> void sort(T[] array, Comparator<? super T> comparator) {
        bubbleSortInAscOrder(array, comparator);
    }

    /**
     * Sort Array objects with bubble sort.
     * @param array the array to be sorted
     * @param <T> the class of the objects to be sorted
     */
    private static <T extends Comparable<T>> void bubbleSortInAscOrder(T[] array) {
        int left = 0;
        int right = array.length - 1;
        for (int indxOne = right; indxOne > 1; indxOne--) {
            for (int indxTwo = left; indxTwo < indxOne; indxTwo++) {
                if (((Comparable<T>) array[indxTwo]).compareTo(array[indxTwo + 1]) > 0) {
                    swap(array, indxTwo, indxTwo + 1);
                }
            }
        }
    }

    /**
     * Sort Array objects with bubble sort and comparator.
     * @param array the array to be sorted
     * @param comparator the comparator to determine the order of the array
     * @param <T> the class of the objects to be sorted
     */
    private static <T> void bubbleSortInAscOrder(T[] array, Comparator<? super T> comparator) {
        int left = 0;
        int right = array.length - 1;
        for (int indxOne = right; indxOne > 1; indxOne--) {
            for (int indTwo = left; indTwo < indxOne; indTwo++) {
                if (comparator.compare(array[indTwo], array[indTwo + 1]) > 0) {
                    swap(array, indTwo, indTwo + 1);
                }
            }
        }
    }

    /**
     * This method is used to swap the values between the two given index
     * @param obj input object
     * @param left left index
     * @param right right index
     */
    private static void swap(Object[] obj, int left, int right) {
        Object temp = obj[left];
        obj[left] = obj[right];
        obj[right] = temp;
    }
}
