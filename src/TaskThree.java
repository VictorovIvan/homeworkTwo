import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static java.lang.System.currentTimeMillis;

/**
 * <p>Задание 3.</p>
 * <p>Дан массив объектов Person. Класс Person характеризуется полями age (возраст, целое число 0-100),
 * sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN),
 * name (имя - строка).</p>
 * <p>Создать два класса, методы которых будут реализовывать сортировку объектов.
 * Предусмотреть единый интерфейс для классов сортировки.
 * Реализовать два различных метода сортировки этого массива по правилам:</p>
 * <p>первые идут мужчины
 * выше в списке тот, кто более старший
 * имена сортируются по алфавиту
 * </p>
 * <p>Программа должна вывести на экран отсортированный список и время работы каждого алгоритма сортировки.
 * Предусмотреть генерацию исходного массива (10000 элементов и более).
 * Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение.</p>
 */

/**
 * Class task 3
 */
public class TaskThree {
    /**
     *  <p>Sex that can be used</p>
     *  <li>{@link #MAN}</li>
     *  <li>{@link #WOMAN}</li>
     */
    private enum Sex {
        MAN {
            public static final String MAN = "MAN";
        },
        WOMAN {
            public static final String MAN = "WOMAN";
        };

        /**
         * <p>Return random enum string MAN or WOMAN</p>
         * @return values()[random.nextInt(values().length)] Return String MAN or WOMAN
         */
        public static Sex getRandomSex() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    /**
     * Class Person
     */
    public static class Person implements Comparable<Person> {
        private byte age;
        private Sex sex;
        private String name;

        /**
         * Get age value
         * @return age byte value from 0 to 100
         */
        public byte getAge() {
            return age;
        }

        /**
         * Get sex value
         * @return sex enum MAN or WOMAN
         */
        public Sex getSex() {
            return sex;
        }

        /**
         * Get name value
         * @return name in type String
         */
        public String getName() {
            return name;
        }

        /**
         * @param age byte value from 0 to 100
         * @param sex enum MAN or WOMAN
         * @param name type String
         */
        public Person(byte age, Sex sex, String name) {
            this.age = age;
            this.sex = sex;
            this.name = name;
        }

        /**
         * Compares this enum with the specified object for order.  Returns a
         * negative integer, zero, or a positive integer as this object is less
         * than, equal to, or greater than the specified object.
         * @param pers Class Person
         * @return (this.age - pers.age) for compare
         */
        @Override
        public int compareTo(Person pers) {
            return (this.age - pers.age);
        }

        @Override
        /**
         *  Returns a string representation of the contents of the specified array.
         *  @return [age=" + this.age + ", sex=" + this.sex + ", name=" + this.name + "] for best reading
         */
        public String toString() {
            return "[age=" + this.age + ", sex=" + this.sex + ", name=" + this.name + "]";
        }

        /**
         * Sort array of person Age to Sex to Name
         * @return flag condition of compare
         * @exception IllegalArgumentException() if Name equals Age
         */
        public static Comparator<Person> CompareToAgeToSexToName = new Comparator<Person>() {
            @Override
            public int compare(Person pers1, Person pers2) {
                int flag = pers1.age - pers2.age;
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
         * @param array the array to be sorted
         * @param cmp the comparator to determine the order of the array.  A
         *           {@code null} value indicates that the elements'
         *           {@linkplain Comparable natural ordering} should be used.
         * @param <T> the class of the objects to be sorted
         * @return remainTime duration time of sort with comparator
         */
        public static <T> long sortComparatorWithCalcTime(T[] array, Comparator<? super T> cmp) {
            long remainTime;
            remainTime = currentTimeMillis();
            Arrays.sort(array, cmp);
            remainTime = currentTimeMillis() - remainTime;
            return remainTime;
        }

        /**
         * Generating something array of Objects(age, sex, name)
         * @param sizeArr the size of the array objects
         * @return genObj generated array of objects
         */
        public static Person[] generateSomethingObjects(int sizeArr) {

            Person genObj[] = new Person[sizeArr];
            SecureRandom random = new SecureRandom();
            int agePerson = 0;

            for (int i = 0; i < sizeArr; i++) {
                byte[] array = new byte[7];
                new Random().nextBytes(array);
                String generatedString = new String(array, Charset.forName("WINDOWS-1251"));
                agePerson = random.nextInt(101);
                genObj[i] = new Person((byte) agePerson, Sex.getRandomSex(), generatedString);
            }
            return genObj;
        }
    }
}

