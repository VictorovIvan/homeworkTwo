import java.util.Arrays;
import TaskThree.*;

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
        Person sortObj[];

        sortObj = Person.generateSomethingObjects(1000);

        modelError.modelNullPointerException();
        modelError.modelArrayIndexOutOfBoundsException();
        modelError.modelThrowMyException();

        random.genRandomNumb(5);

        System.out.println("Время сортировки: " +
                SortWithComp.sortComparatorWithCalcTime(sortObj, SortWithComp.CompareToAgeToSexToName)
                + " MiliSecunds");
        System.out.println("Cортировка:\n" + Arrays.toString(sortObj));
    }
}
