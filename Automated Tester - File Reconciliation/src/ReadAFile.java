import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadAFile {
	
	private String path;
	private List<String> res;
	private StringBuilder sb;
	private String returnMessage;
	
	public ReadAFile(String filePath){
		path = filePath;
		res = new ArrayList<>();
		sb = new StringBuilder();
	}
	
	public List<String> processFile(String fileNumber) {
		String line = "";
		int counter = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			//s.nextLine(); //skip the first line
			try {
				while((line = br.readLine()) != null) {
					String[] values = line.split(",");
					res.add(values[0]);
					counter++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sb.append(fileNumber + " has " + counter +" unique transaction IDs.");
			returnMessage = sb.toString();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public List<String> getResArray() {
		return res;
	}
	
	public String getReturnMessage() {
		return returnMessage;
	}
}