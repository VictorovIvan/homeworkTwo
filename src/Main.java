import java.util.Arrays;

import static java.lang.System.currentTimeMillis;

public class
Main {
    public static void main(String[] args) {
        TaskOne modelError = new TaskOne();
        TaskTwo random = new TaskTwo();
        TaskThree.Person sort[];
        long reamainTime;


        sort = TaskThree.Person.generateSomethingObjects(1000);

//        modelError.modelNullPointerException();
//        modelError.modelArrayIndexOutOfBoundsException();
//        modelError.modelThrowMyException();

//        random.genRandomNumb(5);


        System.out.println("Время сортировки: " +
                           TaskThree.Person.sortComparatorWithCalcTime(sort, TaskThree.Person.CompareToAgeToSexToName)
                           + " MiliSecunds");
        System.out.println("Cортировка:\n" + Arrays.toString(sort));

    }


}
