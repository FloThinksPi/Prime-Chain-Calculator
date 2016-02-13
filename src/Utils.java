import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by flo on 11.02.16.
 */
public class Utils {

    public static byte[] longToBytes(long l) {
        char[] myLong = Long.toString(l).toCharArray();
        byte[] result = new byte[myLong.length];
        for (int i = 0;i<myLong.length;i++) {
            result[i]=Byte.parseByte(Character.toString(myLong[i]));
        }
        return result;
    }

    public static long bytesToLong(byte[] b) {

        //System.out.println(Arrays.toString(b));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            result.append(Byte.toString(b[i]));
        }
        //System.out.println(result);
        return Long.parseLong(result.toString());

    }

    public static long[] toPrimitives(Long[] objects) {

        long[] primitives = new long[objects.length];
        for (int i = 0; i < objects.length; i++)
            primitives[i] = objects[i];

        return primitives;
    }

    public static int getLongNumDigits(long n) {

        //TODO Divide and Conqer Algorythm to calculate digits of Long -> Speed up by 20Times!
        return String.valueOf(n).length();

    }

}
