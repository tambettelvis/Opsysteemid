package tanilsoo.filesystem;

import java.util.HashSet;
import java.util.Set;

public class Memory {

	public static final int MAX_BLOCK_LENGTH = 50;
	public static final int MAX_FILES_AMOUNT = 10;
	
	private File[] data = new File[MAX_BLOCK_LENGTH];
	
	public Memory(){ }
	
	public Memory(File[] data){
		this.data = data;
	}
	
	public void addToMemory(File file){
		int fileSize = file.getSize();
		
		for(int i = 0; i < data.length; i++){
			if(fileSize == 0)
				break;
			if(data[i] == null){
				data[i] = file;
				fileSize--;
			}
		}
	}
	
	public void removeFromMemory(File file){
		removeFromMemory(file.getName());
	}
	
	public void removeFromMemory(String fileName){
		for(int i = 0; i < data.length; i++){
			if(data[i] == null)
				continue;
			if(data[i].getName().equals(fileName))
				data[i] = null;
		}
	}
	
	public Set<File> getFragmentedFiles(){
		Set<File> fragmented = new HashSet<>();
		Set<String> fileNames = new HashSet<>();
		String lastFile = null;
		for(int i = 0; i < data.length; i++){
			if(data[i] == null){
				lastFile = null;
				continue;
			}
			
			if(fileNames.contains(data[i].getName()) && (lastFile == null || !lastFile.equals(data[i].getName()))){
				fragmented.add(data[i]);
			}
			fileNames.add(data[i].getName());
			lastFile = data[i].getName();
		}
		return fragmented;
	}
	
	public Set<File> getAllFiles(){
		Set<File> files = new HashSet<>();
		for(int i = 0; i < data.length; i++){
			if(data[i] != null)
				files.add(data[i]);
		}
		return files;
	}
	
	public int getFreeSpace(){
		return MAX_BLOCK_LENGTH - getUsedSpace();
	}
	
	public int getUsedSpace(){
		int usedSpace = 0;
		for(int i = 0; i < data.length; i++){
			if(data[i] != null)
				usedSpace++;
		}
		return usedSpace;
	}
	
	public int getLargestFreeBlockSize(){
		int largest = 0;
		int read = 0;
		for(int i = 0; i < data.length; i++){
			if(data[i] != null){
				if(largest < read)
					largest = read;
				read = 0;
				continue;
			}
			read++;
			if(i == data.length-1){
				if(largest < read)
					largest = read;
			}
		}
		return largest;
	}
	
	public File[] getData(){
		return data;
	}
	
	
	
}
