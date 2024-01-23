package tw.eeit178.jdbc.msproject;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.BufferedInputStream;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;


public class Msbufferinput {

	public static void main(String[] args) {

		try {

			File file= new File("c:/Action/ClassInfo.csv");

			FileInputStream fis = new FileInputStream("c:/Action/ClassInfo.csv");

			BufferedInputStream bis= new BufferedInputStream(fis);

			byte[] data =new byte[bis.available()];

			bis.read(data);

			String str= new String(data);

			System.out.println(str);

			bis.close();

			fis.close();

		}catch(IOException e) {e.printStackTrace();}

	}



}



