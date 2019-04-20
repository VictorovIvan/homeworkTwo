package TaskThree;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.System.currentTimeMillis;

public class SortWithComp extends Person {
    /**
     * @param age  byte value from 0 to 100
     * @param sex  enum MAN or WOMAN
     * @param name type String
     */
    public SortWithComp(byte age, Person.Sex sex, String name) {
        super(age, sex, name);
    }

    /**
     * Sort array of person Age to Sex to Name
     *
     * @return flag condition of compare
     * @exception IllegalArgumentException() if Name equals Age
     */
    public static Comparator<Person> CompareToAgeToSexToName = new Comparator<Person>() {
        @Override
        public int compare(Person pers1, Person pers2) {
            int flag = pers1.getAge() - pers2.getAge();
            if (flag == 0) {
                flag = pers1.getSex().compareTo(pers2.getSex());
                try {
                    if (pers1.getName().compareTo(pers2.getName()) == 0) {
                        throw new IllegalArgumentException();
                    }
                } catch (Exception ex) {
                    System.out.println(ex.toString() + " Имя человека: " + pers1.getName() + " и возраст: "
                            + pers1.getAge() + " совпадают");
                }
                if (flag == 0) {
                    flag = pers1.getName().compareTo(pers2.getName());
                }
            }
            return (flag);
        }
    };

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
