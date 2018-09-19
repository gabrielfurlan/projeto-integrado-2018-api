package com.boot.spring.utils;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.mindrot.jbcrypt.BCrypt;

public class CryptUtil{
	
	public static String hash(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	public static boolean verify(String password, String hash) {
		return BCrypt.checkpw(password, hash);
	}
	
}