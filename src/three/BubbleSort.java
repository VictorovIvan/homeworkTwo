package three;

import java.util.Comparator;

import static java.lang.System.currentTimeMillis;

public class BubbleSort extends Person implements Comparable<BubbleSort> {

    /**
     * @param age  byte value from 0 to 100
     * @param sex  enum MAN or WOMAN
     * @param name type String
     */
    public BubbleSort(byte age, Sex sex, String name) {
        super(age, sex, name);
    }

    private byte age;
    private Sex sex;
    private String name;

    /**
     * Compares this enum with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param  objOne extend Person
     *
     * @return (this.agetAge - pers.getAge) for compare
     */
    @Override
    public int compareTo(BubbleSort objOne) {
        BubbleSort objTwo = (BubbleSort) objOne;
        if (this.age > objTwo.getAge())
            return 1;
        if (this.age < objTwo.getAge())
            return -1;
        if (this.age == objTwo.getAge())
            if (this.sex.compareTo(objTwo.getSex()) > 0) {
                return 1;
            } else if (this.sex.compareTo(objTwo.getSex()) < 0) {
                return -1;
            } else {
                if (this.name.compareTo(objTwo.getName()) > 0) {
                    return 1;
                } else if (this.name.compareTo(objTwo.getName()) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        return 0;
    }

    /**
     * Sort Array objects with calculation duration time in milisec
     *
     * @param array the array to be sorted
     * @param cmp   the comparator to determine the order of the array.  A
     *              {@code null} value indicates that the elements'
     *              {@linkplain Comparable natural ordering} should be used.
     * @param <T>   the class of the objects to be sorted
     * @return remainTime duration time of sort with comparator
     */
    public static <T> long sortBubbleWithCalcTime(T[] array, Comparator<? super T> cmp) {
        long remainTime;
        remainTime = currentTimeMillis();
        BubbleSortUtil.sort(array, cmp);
        remainTime = currentTimeMillis() - remainTime;
        return remainTime;
    }
}
