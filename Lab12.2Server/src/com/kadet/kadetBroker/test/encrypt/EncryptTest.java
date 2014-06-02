package com.kadet.kadetBroker.test.encrypt;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.xml.bind.DatatypeConverter;

public final class EncryptTest {

    public static String toHexString(byte[] array) {
        return DatatypeConverter.printHexBinary(array);
    }

    public static byte[] toByteArray(String s) {
        return DatatypeConverter.parseHexBinary(s);
    }


    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, IOException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException {

        String text = "public";
        String hexString = toHexString(text.getBytes());
        System.out.println("Hex:" + hexString);
        String answer = new String(toByteArray(hexString));
        System.out.println("Answer: " + answer);

        /*





        String mySecretKeyPhrase = "public";

        DESKeySpec keySpec = new DESKeySpec(mySecretKeyPhrase.getBytes("UTF8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(keySpec);
        sun.misc.BASE64Encoder base64encoder = new BASE64Encoder();
        sun.misc.BASE64Decoder base64decoder = new BASE64Decoder();

// ENCODE plainTextPassword String
        byte[] cleartext = mySecretKeyPhrase.getBytes("UTF8");

        Cipher cipher = Cipher.getInstance("DES"); // cipher is not thread safe
        cipher.init(Cipher.ENCRYPT_MODE, key);
        String encryptedPwd = base64encoder.encode(cipher.doFinal(cleartext));

        System.out.println("Encrypted Pwad: " + encryptedPwd);
// now you can store it


// DECODE encryptedPwd String
        byte[] encrypedPwdBytes = base64decoder.decodeBuffer(encryptedPwd);

        cipher = Cipher.getInstance("DES");// cipher is not thread safe
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] plainTextPwdBytes = (cipher.doFinal(encrypedPwdBytes));

        String newText = new String(plainTextPwdBytes);

        System.out.println("Decrypted Password: " + newText);
        */
    }
}