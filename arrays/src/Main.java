//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //1
//        int[] array = {1, 2, 3, 4, 5};
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }



        //2
//        int[] array = {10, 20, 30, 50, 40};
//        int sum = 0;
//        for (int i = 0; i < array.length; i++) {
//            sum += array[i];
//        }
//        System.out.println(sum);



        //3
//        int[] array = {2, 5, 4, 3, 1, 23, -10};
//        int max = array[0];
//        int min = array[0];
//
//        for (int i = 0; i < array.length; i++) {
//            max = Math.max(max, array[i]);
//            min = Math.min(min, array[i]);
//        }
//        System.out.println(max);
//        System.out.println(min);



        //4
//        int[] array = {1, 2, 3, 4, 5, 6};
//        int i = 0;
//        int j = array.length - 1;
//        while (i < j) {
//            int temp = array[i];
//            array[i] = array[j];
//            array[j] = temp;
//            i++;
//            j--;
//        }
//
//        for (int z = 0; z < array.length; z++) {
//            System.out.print(array[z] + " ");
//        }


        //5
//        int[] array = {10, 15, 20, 25, 30};
//        int evenNumber = 0;
//        int oddNumber = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] % 2 == 0) {
//                evenNumber++;
//            } else {
//                oddNumber++;
//            }
//        }
//        System.out.println(evenNumber);
//        System.out.println(oddNumber);


        //6
//        int[] array = {1, 2, 3, 4, 5};
//        boolean inOrder = true;
//
//        for (int i = 0; i < array.length - 1; i++) {
//            int j = i + 1;
//            if (array[i] >= array[j]) {
//                inOrder = false;
//                break;
//            }
//        }
//        System.out.println(inOrder);


        //7
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6, -4};
        int[] mergedArray = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            mergedArray[i] = arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            mergedArray[i + arr1.length] = arr2[i];
        }

        for (int i = 1; i < mergedArray.length; i++) {
            int temp = mergedArray[i];
            int j = i - 1;
            while(j >= 0 && mergedArray[j] > temp) {
                mergedArray[j + 1] = mergedArray[j];
                j--;
            }
            mergedArray[j + 1] = temp;
        }

        for (int i = 0; i < mergedArray.length; i++) {
            System.out.print(mergedArray[i] + " ");
        }
    }
}