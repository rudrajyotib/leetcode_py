package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateIpAddressTest {

    @Test
    public void testCase1(){
        assertTrue(new ValidateIpAddress().isValid("192.168.1.1"));
        assertTrue(new ValidateIpAddress().isValid("192.168.1.12"));
        assertTrue(new ValidateIpAddress().isValid("192.168.1.123"));
        assertTrue(new ValidateIpAddress().isValid("192.168.255.123"));
        assertTrue(new ValidateIpAddress().isValid("192.1.255.123"));
        assertTrue(new ValidateIpAddress().isValid("1.1.255.123"));
        assertTrue(new ValidateIpAddress().isValid("255.1.255.123"));
        assertTrue(new ValidateIpAddress().isValid("255.255.255.123"));
        assertTrue(new ValidateIpAddress().isValid("255.255.255.255"));
        assertFalse(new ValidateIpAddress().isValid("256.255.255.255"));
        assertFalse(new ValidateIpAddress().isValid("01.255.255.255"));
        assertFalse(new ValidateIpAddress().isValid("01.255.255.255"));
        assertFalse(new ValidateIpAddress().isValid("01.255.255.2552"));
        assertFalse(new ValidateIpAddress().isValid("1.255.255.1.2552"));
        assertFalse(new ValidateIpAddress().isValid("1.255.255"));
        assertFalse(new ValidateIpAddress().isValid("0001.255.255"));
        assertFalse(new ValidateIpAddress().isValid("1..1.255"));
        assertFalse(new ValidateIpAddress().isValid("..."));
        assertFalse(new ValidateIpAddress().isValid("10000"));
        assertFalse(new ValidateIpAddress().isValid("192.168.1.1."));
    }

}