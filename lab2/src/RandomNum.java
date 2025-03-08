import java.util.List;
import java.util.LinkedList;
import java.util.Random;

public class RandomNum {
    static final Random random = new Random();

    public static int randomElement(List<Integer> arr) {
        if (arr.size() > 0)
            return arr.get(random.nextInt(Integer.MAX_VALUE) % arr.size());
        return 0;
    }

    public static int randomElement(int[] arr) {
        if (arr.length > 0)
            return arr[random.nextInt(Integer.MAX_VALUE) % arr.length];
        return 0;
    }

    //Мы можем расширить ArrayList, но модифицировать его нельзя(SOLID)
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 7, 8};

        List<Integer> list = new LinkedList<>();
        for (Integer num : arr)
            list.add(num);

        System.out.println("[] = " + RandomNum.randomElement(arr) +
                "\nlist = " + RandomNum.randomElement(list));
    }
}