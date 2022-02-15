package com.zee.zee5app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class FilesUtils {

	public byte[] read(File file) throws FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] allBytes = new byte[(int) file.length()];
		
		return allBytes;
	}
	
	public String writeFile(byte[] allBytes, String fileName) {
		//FileOutputStream
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(fileName);
			fileOutputStream.write(allBytes);
			return "success";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
		}
		//return success
		//return fail
	}
}
