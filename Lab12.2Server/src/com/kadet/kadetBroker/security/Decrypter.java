package com.kadet.kadetBroker.security;

import javax.xml.bind.DatatypeConverter;

/**
 * Date: 01.06.14
 * Time: 22:26
 *
 * @author SarokaA
 */
public final class Decrypter {

    public static byte[] decryptToByte (String text) {
        return DatatypeConverter.parseHexBinary(text);
    }

    public static String decryptToString (String text) {
        return new String(decryptToByte(text));
    }

}
