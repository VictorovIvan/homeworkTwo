package three;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Random;

import three.usrexc.*;
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
 * Class Person
 */
public class Person {
    /**
     * <p>Sex that can be used</p>
     * <li>{@link #MAN}</li>
     * <li>{@link #WOMAN}</li>
     */
    public enum Sex {
        MAN {
            public static final String MAN = "MAN";
        },
        WOMAN {
            public static final String MAN = "WOMAN";
        };

        /**
         * <p>Return random enum string MAN or WOMAN</p>
         *
         * @return values()[random.nextInt(values ().length)] Return String MAN or WOMAN
         */
        public static Sex getRandomSex() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    private byte age;
    private Sex sex;
    private String name;

    @Override
    /**
     *  Returns a string representation of the contents of the specified array.
     *  @return [age=" + this.age + ", sex=" + this.sex + ", name=" + this.name + "] for best reading
     */
    public String toString() {
        return "\n[age=" + this.age + ", sex=" + this.sex + ", name=" + this.name + "]";
    }

    /**
     * Get age value
     *
     * @return age byte value from 0 to 100
     */
    public byte getAge() {
        return age;
    }

    /**
     * Get sex value
     *
     * @return sex enum MAN or WOMAN
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Get name value
     *
     * @return name in type String
     */
    public String getName() {
        return name;
    }

    /**
     * @param age  byte value from 0 to 100
     * @param sex  enum MAN or WOMAN
     * @param name type String
     */
    public Person(byte age, Sex sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    /**
     * Sort array of person Age to Sex to Name
     *
     * @return flag condition of compare
     * @exception IllegalArgumentException() if Name equals Age
     */
    public static Comparator<Person> ToAgeToSexToName = new Comparator<Person>() {
        @Override
        public int compare(Person pers1, Person pers2) {
            int flag = pers1.getAge() - pers2.getAge();
            if (flag == 0) {
                flag = pers1.getSex().compareTo(pers2.getSex());
                try {
                    if (pers1.getName().compareTo(pers2.getName()) == 0) {
                        throw new UserException();
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
     * Generating something array of Objects(age, sex, name)
     *
     * @param sizeArr the size of the array objects
     * @return genObj generated array of objects
     */
    public static Person[] generateSomethingObjects(int sizeArr) {

        Person genObj[] = new Person[sizeArr];
        SecureRandom random = new SecureRandom();
        SecureRandom randomLengthWord = new SecureRandom();
        int agePerson;

        for (int nmbGen = 0; nmbGen < sizeArr; nmbGen++) {
            int lengthword;
            lengthword = randomLengthWord.nextInt(10);

            byte[] array = new byte[lengthword + 3];
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("WINDOWS-1251"));
            agePerson = random.nextInt(101);
            genObj[nmbGen] = new Person((byte) agePerson, Sex.getRandomSex(), generatedString);
        }
        return genObj;
    }
}
