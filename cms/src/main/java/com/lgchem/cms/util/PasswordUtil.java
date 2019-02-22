package com.lgchem.cms.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {
	public static String generateHash(String input) throws NoSuchAlgorithmException {
		StringBuilder sb = new StringBuilder();
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		byte[] d = md.digest(input.getBytes());
		for (int i = 0, len = d.length; i < len; i++) {
			byte t = d[i];
			String s = Integer.toHexString(t & 0xFF);
			while (s.length() < 2) {
				s = "0" + s;
			}
			sb.append(s.substring(s.length() - 2));
		}
		return sb.toString();
	}

	public static boolean verifyHash(String userPw, String dbHash) throws NoSuchAlgorithmException {
		if (userPw == null || userPw.equals("")) {
			throw new NullPointerException("user password is null!");
		}
		if (dbHash == null || dbHash.equals("")) {
			throw new NullPointerException("database hash value is null!");
		}
		userPw = PasswordUtil.generateHash(userPw);
		if (userPw.equals(dbHash)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println(PasswordUtil.generateHash("1111"));
		} catch (NoSuchAlgorithmException e) {
		}
	}
}
