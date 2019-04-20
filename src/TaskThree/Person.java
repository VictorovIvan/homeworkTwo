package TaskThree;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Class Person
 */
public class Person implements Comparable<Person> {
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
     * Compares this enum with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
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
     * Generating something array of Objects(age, sex, name)
     *
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
