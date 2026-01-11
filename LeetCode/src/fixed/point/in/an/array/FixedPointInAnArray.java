package fixed.point.in.an.array;

public class FixedPointInAnArray {
    public static void main(String[] args) {
        int[] arr = {-10, -5, 0, 3, 7};
        System.out.println(fixedPoint(arr));
    }

    public static int fixedPoint(int[] arr) {
    for(int i=0; i<arr.length; i++) {
        if(arr[i] == i) {
            return i;
        }
    }
    return -1;
    };
}
