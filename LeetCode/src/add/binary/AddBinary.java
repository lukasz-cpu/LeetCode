package add.binary;

public class AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";


        System.out.println(addBinary(a, b));

    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aLength = a.length() - 1;
        int bLength = b.length() - 1;
        int carry = 0;

        while (aLength >= 0 || bLength >= 0) {
            int sum = carry;
            if (aLength >= 0) {
                sum += a.charAt(aLength) - '0';
                aLength--;
            }
            if (bLength >= 0) {
                sum += b.charAt(bLength) - '0';
                bLength--;
            }

            sb.insert(0, sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            sb.insert(0, 1);
        }

        return sb.toString();
    }

}
