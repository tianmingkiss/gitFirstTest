package com.bj.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainT1 {

	static String file = "E:/stream.txt";
	static String charset = "utf-8";
	
	public static void main(String[] args) {
		write2file();
		readFwrite();
	}
	
	//写入文件
	public static void write2file(){
		try {
			FileOutputStream fos = new FileOutputStream(file,true);
			OutputStreamWriter osw = new OutputStreamWriter(fos,charset);
			String newLine = System.getProperty("line.separator");
			osw.write("这是我要写入文件中的内容和拼音abc!\n");
			osw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(file+"文件找不到！");
		}
	}

	//读取文件
	public static void readFwrite(){
		try {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis,charset);
			char[] buf = new char[64];
			StringBuffer sb = new StringBuffer();
			int count = 0; 
			while((count=isr.read(buf))!=-1){
				sb.append(buf,0,count);
			}
			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
