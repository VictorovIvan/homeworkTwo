import java.util.Arrays;

import one.TaskOne;
import two.TaskTwo;
import three.*;

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

        System.out.println("\nЗадание №1:");
        modelError.modelNullPointerException();
        modelError.modelArrayIndexOutOfBoundsException();
        modelError.modelThrowMyException();

        System.out.println("\nЗадание №2:");
        random.genRandomNumb(5);

        System.out.println("\nЗадание №3:");
        sortObj = Person.generateSomethingObjects(1000);
        System.out.println("Без сортировки:\n" + Arrays.toString(sortObj));
        System.out.println("Время сортировки Arrays.sort : " +
                SortWithComp.sortComparatorWithCalcTime(sortObj, Person.ToAgeToSexToName)
                + " MiliSecunds");
        System.out.println("Cортировка Arrays.sort:\n" + Arrays.toString(sortObj));
        System.out.println("Время сортировки пузырьком: " +
                BubbleSort.sortBubbleWithCalcTime(sortObj, Person.ToAgeToSexToName)
                + " MiliSecunds");
        System.out.println("Cортировка пузырьком:\n" + Arrays.toString(sortObj));
    }
}
