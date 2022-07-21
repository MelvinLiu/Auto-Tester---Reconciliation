import java.util.HashSet;
import java.util.List;

public class MainRunner {
	
	private String path1;
	private String path2;
	private String fileOneReturnMessage;
	private String fileTwoReturnMessage;
	
	public MainRunner(String path1, String path2) {
		this.path1 = path1;
		this.path2 = path2;
	}

	public String runner() {
		// TODO Auto-generated method stub

		String file1Path = path1;
		String file2Path = path2;
		
		ReadAFile fileOne = new ReadAFile(file1Path);
		List<String> sourceFile1 = fileOne.processFile("File One");
		fileOneReturnMessage = fileOne.getReturnMessage();
		
		ReadAFile fileTwo = new ReadAFile(file2Path);
		List<String> distationFile2 = fileTwo.processFile("File Two");
		fileTwoReturnMessage = fileTwo.getReturnMessage();
		
		HashSet<String> set2 = new HashSet<>(distationFile2);
		
		boolean result = sourceFile1.stream()
		           .map((e) -> (set2.contains(e)))
		           .allMatch((e) -> e.equals(true));
		
		//System.out.println(result);
		
		if (result == true) return "Two files are the same.";
		
		return "Two files are different.";
	}
	
	public String getFileOneReturnMessage() {
		return fileOneReturnMessage;
	}
	
	public String getFileTwoReturnMessage() {
		return fileTwoReturnMessage;
	}
}