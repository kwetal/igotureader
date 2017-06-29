/*
 * This file by in568bax - 2017 is in the Public Domain.
 * Do whatever you like with it.
 */
package igotu.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author in568bax
 */
public class UtilTest
{

    public UtilTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInt2Bytes() {
	int2bytesTest(0x12_34_56_78_9a_bc_de_f0L, 1, 0xf0);
	int2bytesTest(0x12_34_56_78_9a_bc_de_f0L, 2, 0xde, 0xf0);
	int2bytesTest(0x12_34_56_78_9a_bc_de_f0L, 3, 0xbc, 0xde, 0xf0);
	int2bytesTest(0x12_34_56_78_9a_bc_de_f0L, 4, 0x9a, 0xbc, 0xde, 0xf0);
	int2bytesTest(0x12_34_56_78_9a_bc_de_f0L, 5, 0x78, 0x9a, 0xbc, 0xde, 0xf0);
	int2bytesTest(0x12_34_56_78_9a_bc_de_f0L, 6, 0x56, 0x78, 0x9a, 0xbc, 0xde, 0xf0);
	int2bytesTest(0x12_34_56_78_9a_bc_de_f0L, 7, 0x34, 0x56, 0x78, 0x9a, 0xbc, 0xde, 0xf0);
	int2bytesTest(0x12_34_56_78_9a_bc_de_f0L, 8, 0x12, 0x34, 0x56, 0x78, 0x9a, 0xbc, 0xde, 0xf0);
    }

    private void int2bytesTest(long val, int sz, int... bytes) {
	byte[] result = Util.int2bytes(val, sz);
	assert result.length == sz;
	for (int i = 0; i < sz; i++) {
	    int j = sz-1-i;
	    assert result[i] == (byte)bytes[j] : String.format("int2bytes(%d, %d): mismatch at byte %d: %d != %d", val, sz, i, result[i], bytes[j]);
	}
    }

}
