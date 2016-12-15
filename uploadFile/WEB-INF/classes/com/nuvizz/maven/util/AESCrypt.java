package com.nuvizz.maven.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class AESCrypt {

	private static final String ALGORITHM = "AES";
	private static final String KEY = "1Hbfh667adfDEJ78";

	public static String encrypt(String value) {
		Key key;
		try {
			key = generateKey();
			Cipher cipher = Cipher.getInstance(AESCrypt.ALGORITHM);

			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptedByteValue = cipher.doFinal(value.getBytes("utf-8"));
			String encryptedValue64 = new BASE64Encoder()
					.encode(encryptedByteValue);
			return encryptedValue64;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	public static String decrypt(String value) {
		
		try {
			Key key = generateKey();
			
			Cipher cipher = Cipher.getInstance(AESCrypt.ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptedValue64 = new BASE64Decoder().decodeBuffer(value);
			byte[] decryptedByteValue = cipher.doFinal(decryptedValue64);
			String decryptedValue = new String(decryptedByteValue, "utf-8");
			return decryptedValue;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  null;
		}

	}

	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(AESCrypt.KEY.getBytes(), AESCrypt.ALGORITHM);
		return key;
	}
}
