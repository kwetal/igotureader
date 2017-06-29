/*
 * This file by in568bax - 2017 is in the Public Domain.
 * Do whatever you like with it.
 */
package igotu.core;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertArrayEquals;
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
    public void testInt2bytes() {
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
	byte[] expResult = new byte[bytes.length];
	for (int i = 0; i < bytes.length; i++) {
	    expResult[i] = (byte)bytes[i];
	}
	byte[] result = Util.int2bytes(val, sz);
	assertArrayEquals(expResult, result);
    }

    /**
     * Test of mkCommandBytes method, of class Util.
     */
    @Test
    public void testMkCommandBytes() {
	System.out.println("mkCommandBytes");
	String hexTmpl = "93 0A";
	byte[] expResult = new byte[]{ (byte)0x93, 0x0A, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x63 };
	byte[] result = Util.mkCommandBytes(hexTmpl);
	assertArrayEquals(expResult, result);
    }

    /**
     * Test of mkCommandBytes method, of class Util.
     */
    @Test
    public void testMkCommandBytesMacro1() {
	byte[] expResult = new byte[]{ (byte)0x93, 0x01, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x6b };
	byte[] result = Util.mkCommandBytes("93 01 01 <1>", 0);
	assertArrayEquals(expResult, result);
    }

    @Test
    public void testMkCommandBytesMacro2() {
	byte[] expResult = new byte[]{ (byte)0x93, 0x01, 0x01, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x6a };
	byte[] result = Util.mkCommandBytes("93 01 01 <1>", 1);
	assertArrayEquals(expResult, result);
    }

    @Test
    public void testMkCommandBytesMacro3() {
	byte[] expResult = new byte[]{ (byte)0x93, 0x01, 0x01, 0x03, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x68 };
	byte[] result = Util.mkCommandBytes("93 01 01 <1>", 3);
	assertArrayEquals(expResult, result);
    }

    @Test
    public void testMkCommandBytesMacro4() {
	byte[] expResult = new byte[]{ (byte)0x93, 0x0b, 0x01, 0x12, 0x34, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x1b };
	byte[] result = Util.mkCommandBytes("93 0B <1> <2> 00 00 00", 1, 0x1234);
	assertArrayEquals(expResult, result);
    }
}
