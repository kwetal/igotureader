package igotu.core;

import gnu.trove.list.TByteList;
import gnu.trove.list.array.TByteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author in568bax
 */
public class Util
{

    public static byte[] int2bytes(long value, int size) {
	byte[] result = new byte[size];
	for (int i = size - 1; i >= 0; i--) {
	    result[i] = (byte)(value & 0xFF);
	    value >>= 8;
	}
	return result;
    }

    private static final int COMMAND_LENGTH = 15;
    private static final Pattern MACRO_PATTERN = Pattern.compile("<(\\d+)>");

    public static byte[] mkCommandBytes(String hexTmpl, int... args) {
	TByteList result = new TByteArrayList();
	String[] words = hexTmpl.split("\\s+");

	int argc = 0;
	for (String w: words) {
	    Matcher matcher = MACRO_PATTERN.matcher(w);
	    if (matcher.matches()) {
		int nbytes = Integer.parseInt(matcher.group(1));
		result.add(int2bytes(args[argc++], nbytes));
	    } else {
		result.add((byte)Integer.parseInt(w, 16));
	    }

	    if (result.size() >= COMMAND_LENGTH)
		break;
	}
	if (result.size() > COMMAND_LENGTH) {
	    result.remove(COMMAND_LENGTH, result.size()-COMMAND_LENGTH);
	} else {
	    // fill with 0 until COMMAND_LENGTH
	    while (result.size() < COMMAND_LENGTH) {
		result.add((byte)0);
	    }
	}
	// compute checksum
	result.add((byte)-result.sum());
	return result.toArray();
    }
}
