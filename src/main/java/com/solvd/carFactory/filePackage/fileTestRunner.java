package com.solvd.carFactory.filePackage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.StringUtils;

public class fileTestRunner {
	
	public static void main(String[] args) {
		HashMap<String,Integer> words = new HashMap<String,Integer>();
		try {
			//Open file, save it in a string and delete all punctuation marks with regular expressions
			File file = new File("../CarFactory/src/main/resources/text.txt");
			String text = (FileUtils.readFileToString(file,StandardCharsets.UTF_8)).replaceAll("\\p{P}","");
			for(String s : StringUtils.split(StringUtils.lowerCase(text)))
					words.put(s,(words.containsKey(s) ? words.get(s)+1 : 1));
			//Save HashMap strings in another file call results
			FileUtils.writeStringToFile(new File("../CarFactory/src/main/resources/results.txt"), words.toString(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
