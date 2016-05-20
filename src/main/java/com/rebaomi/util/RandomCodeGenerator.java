package com.rebaomi.util;

import java.util.Random;

public class RandomCodeGenerator
{

	private static Random randGen = null;
	private static char[] numbersAndLetters = null;

	private static final int defaultLen = 20;
	
	/***
	 * 获取随机的字符
	 * 
	 * @param length
	 *            :随机数长度
	 * @return
	 */
	public static String getRandomString(int length)
	{

		if (length < 1)
		{
			return null;
		}
		if (randGen == null)
		{
			randGen = new Random();
			numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz"
					+ "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
		}
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++)
		{
			randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
		}
		return new String(randBuffer);
	}
	
	public static String getDefaultLenRandomString(){
	    return getRandomString(defaultLen);
	}
}
