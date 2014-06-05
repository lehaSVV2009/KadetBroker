package com.kadet.kadetBroker.security;

import javax.xml.bind.DatatypeConverter;

/**
 * Date: 01.06.14
 * Time: 22:26
 *
 * @author SarokaA
 */
public final class Decrypter {

    public static String decryptToString(String text) {
        StringBuilder result
                = new StringBuilder();
        for (int i = 0; i < text.length() - 1; i += 2) {
            String output = text.substring(i, (i + 2));
            int decimal = Integer.parseInt(output, 16);
            result.append((char) decimal);
        }
        return result.toString();
    }


}
