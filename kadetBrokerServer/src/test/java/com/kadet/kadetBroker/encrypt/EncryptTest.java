package com.kadet.kadetBroker.encrypt;


import com.kadet.kadetBroker.security.Decrypter;
import junit.framework.Assert;
import org.junit.Test;

import javax.xml.bind.DatatypeConverter;

public class EncryptTest {

    public static String toHexString(byte[] array) {
        return DatatypeConverter.printHexBinary(array);
    }

    @Test
    public void encryptTest() {

        String text = "public";
        String hexString = toHexString(text.getBytes());

        String answer = Decrypter.decryptToString(hexString);
        Assert.assertEquals(text, answer);

    }
}