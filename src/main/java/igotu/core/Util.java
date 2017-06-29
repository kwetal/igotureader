package igotu.core;

/**
 *
 * @author in568bax
 */
public class Util
{
    public static byte[] int2bytes(long value, int size) {
	byte[] result = new byte[size];
	for (int i = 0; i<size; i++) {
	    result[i] = (byte)(value & 0xFF);
	    value >>= 8;
	}
	return result;
    }

}
