import java.util.Arrays;

/**
 * Main class
 */
public class Main {
    /**
     * Main for testing
     */
    public static void main(String[] args) {
        TaskOne modelError = new TaskOne();
        TaskTwo random = new TaskTwo();
        TaskThree.Person sortObj[];
        long reamainTime;

        sortObj = TaskThree.Person.generateSomethingObjects(1000);

        modelError.modelNullPointerException();
        modelError.modelArrayIndexOutOfBoundsException();
        modelError.modelThrowMyException();

        random.genRandomNumb(5);

        System.out.println("Время сортировки: " +
                TaskThree.Person.sortComparatorWithCalcTime(sortObj, TaskThree.Person.CompareToAgeToSexToName)
                + " MiliSecunds");
        System.out.println("Cортировка:\n" + Arrays.toString(sortObj));
    }
}
