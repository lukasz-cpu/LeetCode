import java.util.Stack;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {


        Stack<Integer> result = new Stack<>();
        result.push(1);
        result.push(2);
        result.push(3);
        result.push(4);

        Integer peek = result.peek();

        Integer pop = result.pop();

        System.out.println(pop);

        Integer pop2 = result.pop();

        System.out.println(pop2);



    }
}