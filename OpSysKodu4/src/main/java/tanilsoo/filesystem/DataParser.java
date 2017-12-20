package tanilsoo.filesystem;

import java.util.LinkedList;
import java.util.Queue;

public class DataParser {
	
	public static Queue<File> patternToFiles(String pattern){
		Queue<File> files = new LinkedList<>();
		
		String[] datas = pattern.split(";");
		for(int i = 0; i < datas.length; i++){
			String[] fileData = datas[i].split(",");
			String fileName = fileData[0];
			if(fileData[1].equals("-")){
				files.add(new File(fileName, -1, true));
				continue;
			}
			int size = Integer.parseInt(fileData[1]);
			files.add(new File(i, fileName, size));
		}
		return files;
	}
	
}
