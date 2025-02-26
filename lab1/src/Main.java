import java.util.Scanner;
import java.math.BigInteger;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main
{
    public static int valid_input(String s)
    {
        int digit = 0;
        boolean valid_input = false;

        while (!valid_input)
        {
            System.out.print(s);
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt())
            {
                digit = input.nextInt();
                valid_input = true;
            }
            else
            {
                System.out.println("Invalid input. Please enter an integer.");
                input.next();
            }
        }
        return digit;
    }

    public static void task1()
    {
        int digit = valid_input("Input number: ");

        String binary = Integer.toBinaryString(digit);
        System.out.println("Binary: " + binary);

        String octal = Integer.toOctalString(digit);
        System.out.println("Octal: " + octal);

        String hex = Integer.toHexString(digit);
        System.out.println("Hex: " + hex);
    }

    public static void task2()
    {
        int degree = valid_input("Input degree: ");
        if(Math.abs(degree) > 360)
        {
            System.out.print("U lose degree, u should input -360 <= degree <= 360\n");
            return;
        }
        int normal = (degree < 0) ? 360 + (degree % 360) : degree % 360;
        System.out.println("Normal with %: " + normal);

        System.out.println("Normal with floorMod: " + Math.floorMod(degree, 360));
    }

    public static void task3()
    {
        System.out.print("Input three numbers:\n");
        int a = valid_input("Input first: ");
        int b = valid_input("Input second: ");
        int c = valid_input("Input third: ");

        if (a >= b && a >= c)
            System.out.println("The largest number(if): " + a);
        else if (b >= a && b >= c)
            System.out.println("The largest number (if): " + b);
        else
            System.out.println("The largest number (if): " + c);

        System.out.println("The largest number (Math.max()): " + Math.max(Math.max(a, b), c));
    }

    public static void task4()
    {
        System.out.println("Double.MIN  = " + Double.MIN_VALUE);
        System.out.println("Double.MAX  = " + Double.MAX_VALUE);
    }

    public static void task5()
    {
        double max_double = Double.MAX_VALUE;
        int max_int = (int)max_double;
        System.out.println("Max double: " + max_double);
        System.out.println("Min int: " + max_int);
    }

    public static void task6(int n)
    {
        BigInteger number = BigInteger.valueOf(1);
        for(BigInteger i = BigInteger.valueOf(1); i.compareTo(BigInteger.valueOf(n + 1)) != 0; i = i.add(BigInteger.valueOf(1)))
        {
            number = number.multiply(i);
        }
        System.out.println(number);
    }

    public static void task7()
    {
        int number1 = valid_input("Input first number:");
        if(number1 < 0 || number1 > 65635)
        {
            System.out.println("Error code number");
            return;
        }
        int number2 = valid_input("Input second number1:");
        if(number2 < 0 || number2 > 65635)
        {
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

    public static void task8()
    {
        String string;
        Scanner in = new Scanner(System.in);
        System.out.print("Input string: ");
        string = in.nextLine();
        String[] new_str = string.split("\\s+");
        for(String s : new_str)
            System.out.println(s);
    }

    public static void task9()
    {
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

    public static void task10()
    {
        Random random = new Random();
        long random_number = random.nextLong();
        String str = Long.toString(random_number, 36);
        System.out.println("Result string: " + str);
    }

    public static void task11()
    {
        System.out.println("Input str:");
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        for(int i = 0; i < string.length(); ++i)
        {
            char symbol = string.charAt(i);
            if (symbol > 127)
                System.out.println("Symbol: " + symbol + ", Unicode: U+" +
                        Integer.toHexString(symbol).toUpperCase());
        }
    }

    public static void task13()
    {
        ArrayList<Integer> array = IntStream.rangeClosed(1, 49).boxed()
                .collect(Collectors.toCollection(ArrayList::new)),
                lottery = new ArrayList<>();
        for (int i = 1; i <= 49; ++i)
            array.add(i);
        Random random = new Random();
        for (int i = 0; i < 6; i++)
        {
            int index = random.nextInt(array.size());
            lottery.add(array.remove(index));
        }
        Collections.sort(lottery);
        System.out.println("Lotery combination: " + lottery);
    }

    public static void main(String[] args)
    {
        int number = 1;

        while(number != 0)
        {
            number = valid_input("Input number 1 - 18 (0 - for exit): ");
            switch (number)
            {
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
                default:
                    System.out.println("Incorrect!");
            }
        }
    }
}
