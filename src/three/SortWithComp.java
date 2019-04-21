package three;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.System.currentTimeMillis;

/**
 * Class SortWithComp
 */
public class SortWithComp extends Person  implements Comparable<SortWithComp> {
    /**
     * @param age  byte value from 0 to 100
     * @param sex  enum MAN or WOMAN
     * @param name type String
     */
    public SortWithComp(byte age, Person.Sex sex, String name) {
        super(age, sex, name);
    }

    /**
     * Compares this enum with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *x
     *      * @param sortWithComp object extend Person
     * @return (this.agetAge - pers.getAge) for compare
     */
    @Override
    public int compareTo(SortWithComp sortWithComp) {
        return (this.getAge() - sortWithComp.getAge());
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
    public static <T> long sortComparatorWithCalcTime(T[] array, Comparator<? super T> cmp) {
        long remainTime;
        remainTime = currentTimeMillis();
        Arrays.sort(array, cmp);
        remainTime = currentTimeMillis() - remainTime;
        return remainTime;
    }
}
