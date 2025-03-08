import java.util.Scanner;
import java.math.BigInteger;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.HashMap;

public class Main
{
    public static int validInput(String s) {
        int digit = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print(s);
            Scanner input = new Scanner(System.in);

            if (input.hasNextInt()) {
                digit = input.nextInt();
                valid = true;
            }
            else {
                System.out.println("Invalid input. Please enter an integer.");
                input.next();
            }
        }

        return digit;
    }

    public static void task1() {
        int digit = validInput("Input number: ");

        String binary = Integer.toBinaryString(digit);
        System.out.println("Binary: " + binary);

        String octal = Integer.toOctalString(digit);
        System.out.println("Octal: " + octal);

        String hex = Integer.toHexString(digit);
        System.out.println("Hex: " + hex);
    }

    public static void task2() {
        int degree = validInput("Input degree: ");
        if(Math.abs(degree) > 360) {
            System.out.print("U lose degree, u should input -360 <= degree <= 360\n");
            return;
        }
        int normal = (degree < 0) ? 360 + (degree % 360) : degree % 360;
        System.out.println("Normal with %: " + normal);

        System.out.println("Normal with floorMod: " + Math.floorMod(degree, 360));
    }

    public static void task3() {
        System.out.print("Input three numbers:\n");
        int a = validInput("Input first: ");
        int b = validInput("Input second: ");
        int c = validInput("Input third: ");

        if (a >= b && a >= c)
            System.out.println("The largest number(if): " + a);
        else if (b >= a && b >= c)
            System.out.println("The largest number (if): " + b);
        else
            System.out.println("The largest number (if): " + c);

        System.out.println("The largest number (Math.max()): " + Math.max(Math.max(a, b), c));
    }

    public static void task4() {
        System.out.println("Min double: " + Math.nextUp(0.0));

        System.out.println("Max double: " + Double.MAX_VALUE);
    }

    public static void task5() {
        double maxDouble = Double.MAX_VALUE;
        int maxInt = (int)maxDouble;
        System.out.println("Max double: " + maxDouble);
        System.out.println("Min int: " + maxInt);
    }

    public static void task6(int n) {
        BigInteger number = BigInteger.valueOf(1);
        for (int i = 1; i < n;++i)
            number = number.multiply(BigInteger.valueOf(i));

        System.out.println(number);
    }

    public static void task7() {
        int number1 = validInput("Input first number:");
        if(number1 < 0 || number1 > 65635) {
            System.out.println("Error code number");
            return;
        }
        int number2 = validInput("Input second number1:");
        if(number2 < 0 || number2 > 65635) {
            System.out.println("Error code number2");
            return;
        }
        short sh1 = (short)number1, sh2 = (short)number2;
        System.out.println("Summ = " + ((sh1 & 0xFFFF) + (sh2 & 0xFFFF)));
        System.out.println("Diff = " + ((sh1 & 0xFFFF) - (sh2 & 0xFFFF)));
        System.out.println("Mul = " + ((long)(sh1 & 0xFFFF) * (long)(sh2 & 0xFFFF)));
        System.out.println("Div = " + ((sh1 & 0xFFFF) / (sh2 & 0xFFFF)));
        System.out.println("Rem = " + ((sh1 & 0xFFFF) % (sh2 & 0xFFFF)));
    }

    public static void task8() {
        String string;
        Scanner in = new Scanner(System.in);
        System.out.print("Input string: ");
        string = in.nextLine();
        String[] newStr = string.split("\\s+");
        for(String s : newStr)
            System.out.println(s);
    }

    public static void task9() {
        String string1, string2;
        Scanner in = new Scanner(System.in);
        System.out.print("Input first string: ");
        string1 = in.nextLine();
        System.out.print("Input second string: ");
        string2 = in.nextLine();

        int result = string1.compareTo(string2);
        if (result == 0)
            System.out.println("The strings is equal!");
        else
            System.out.println("The strings is not equal!");
    }

    public static void task10() {
        Random random = new Random();
        long randomNumber = random.nextLong();
        String str = Long.toString(randomNumber, 36);
        System.out.println("Result string: " + str);
    }

    public static void task11()
    {
        System.out.println("Input str:");
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        for(int i = 0; i < string.length(); ++i) {
            char symbol = string.charAt(i);
            if (symbol > 127)
                System.out.println("Symbol: " + symbol + ", Unicode: U+" +
                        Integer.toHexString(symbol).toUpperCase());
        }
    }

    public static void task13() {
        ArrayList<Integer> array = IntStream.rangeClosed(1, 49).boxed()
                .collect(Collectors.toCollection(ArrayList::new)),
                lottery = new ArrayList<>();
        for (int i = 1; i <= 49; ++i)
            array.add(i);
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(array.size());
            lottery.add(array.remove(index));
        }
        Collections.sort(lottery);
        System.out.println("Lotery combination: " + lottery);
    }

    public static boolean isMagic(int[][] matrix) {
        int summ = 0;
        for(int number : matrix[0])
            summ += number;
        for(int i = 1; i < matrix.length; ++i) {
            int summa = 0;
            for(int number : matrix[i])
                summa += number;
            if(summa != summ)
                return false;
        }
        for (int j = 0; j < matrix.length; ++j) {
            int summa = 0;
            for (int i = 0; i < matrix.length; ++i)
                summa += matrix[i][j];
            if (summa != summ)
                return false;
        }
        int sum1 = 0;
        for (int i = 0; i < matrix.length; ++i)
            sum1 += matrix[i][i];
        if (sum1 != summ)
            return false;

        int diagSum2 = 0;
        for (int i = 0; i < matrix.length; ++i)
            diagSum2 += matrix[i][matrix.length - 1 - i];
        if (diagSum2 != summ)
            return false;
        return true;
    }

    public static void task14() {
        ArrayList<int[]> arrayRows = new ArrayList<>();
        System.out.println("Input matrix:");
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            String str = scanner.nextLine().trim();
            if(str.isEmpty())
                break;
            String[] parts = str.split("\\s+");
            int[] row = new int[parts.length];
            try {
                for (int i = 0; i < parts.length; ++i)
                    row[i] = Integer.parseInt(parts[i]);
                arrayRows.add(row);
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter only numbers separated by spaces.");
                continue;
            }
        }
        if (arrayRows.isEmpty()) {
            System.out.println("Matrix is empty.");
            return;
        }
        int size = arrayRows.size();
        int[][] matrix = new int[size][];
        for (int i = 0; i < size; ++i)
            matrix[i] = arrayRows.get(i);
        if (isMagic(matrix))
            System.out.println("Matrix is magic square");
        else
            System.out.println("Matrix is magic square");
    }

    public static void task15(int n) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
            }
            triangle.add(row);
        }
        int maxLength = 0;
        for (ArrayList<Integer> row : triangle) {
            for (Integer num : row)
                maxLength = Math.max(maxLength, String.valueOf(num).length());
        }

        int triangleWidth = triangle.size() * (maxLength + 1);

        for (int i = 0; i < triangle.size(); ++i) {
            ArrayList<Integer> row = triangle.get(i);
            int rowWidth = row.size() * (maxLength + 1);
            int padding = (triangleWidth - rowWidth) / 2;

            for (int k = 0; k < padding; ++k)
                System.out.print(" ");

            for (int j = 0; j < row.size(); ++j) {
                String formattedNumber = String.format("%" + maxLength + "d", row.get(j));
                System.out.print(formattedNumber + " ");
            }
            System.out.println();
        }
    }

    public static void task16(double genNumber, double... arrayValue) {
        double summ = genNumber;
        for(double value : arrayValue)
            summ += value;
        System.out.println("Average = " +
                (arrayValue.length == 0 ? summ : summ / (arrayValue.length + 1)));
    }

    public static <T extends Number> double additionalTask(T ... args)
    {
        double summ = 0.0;
        for(T value : args) {
            summ += value.doubleValue();
        }
        return summ;
    }

    public static void inputChineFirst() {
        HashMap<Integer, String> chineseSymbols = new HashMap<>();
        chineseSymbols.put(1, "你");
        chineseSymbols.put(2, "好");
        chineseSymbols.put(3, "世");
        chineseSymbols.put(4, "界");
        chineseSymbols.put(5, "爱");
        chineseSymbols.put(6, "和");
        chineseSymbols.put(7, "平");

        System.out.println("Symbols:");
        for (Integer key : chineseSymbols.keySet())
            System.out.println(key + " -> " + chineseSymbols.get(key));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input numbers:");
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");

        System.out.println("Result:");
        for (String numberStr : numbers) {
            try {
                int number = Integer.parseInt(numberStr);
                if (chineseSymbols.containsKey(number))
                    System.out.print(chineseSymbols.get(number) + " ");
                else
                    System.out.print("[unknown symbol] ");
            }
            catch (NumberFormatException e) {
                System.out.print("[invalid input] ");
            }
        }
    }

    public static void inputChineSecond() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();

        System.out.println("Chinize symbols: ");
        for (char c : input.toCharArray()) {
            if (c >= '\u4E00' && c <= '\u9FFF')
                System.out.print(c + " ");
        }
        System.out.print('\n');
    }

    public static void main(String[] args) {
        int number = 1;
        //a % b = a - (a / b) * b
        System.out.println(7 % -5);
        System.out.println(7 % 5);
        System.out.println(-7 % 5);
        System.out.println(-7 % -5);
        while(number != 0) {
            number = validInput("Input number 1 - 19 (0 - for exit): ");
            switch (number) {
                case 0:
                    break;
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 6:
                    task6(1000);
                    break;
                case 7:
                    task7();
                    break;
                case 8:
                    task8();
                    break;
                case 9:
                    task9();
                    break;
                case 10:
                    task10();
                    break;
                case 11:
                    task11();
                    break;
                case 13:
                    task13();
                    break;
                case 14:
                    task14();
                    break;
                case 15:
                    int n = validInput("Input n: ");
                    task15(n);
                    break;
                case 16:
                    task16(1, 2, 3, 4, 5, 6, 7, 8);
                    break;
                case 17:
                    double value = additionalTask(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                    System.out.println("Summ = " + value);
                    break;
                case 18:
                    inputChineFirst();
                    break;
                case 19:
                    inputChineSecond();
                    break;
                default:
                    System.out.println("Incorrect!");
            }
        }
    }
}
