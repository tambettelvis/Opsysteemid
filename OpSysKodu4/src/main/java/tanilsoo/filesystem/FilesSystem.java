package tanilsoo.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FilesSystem {

	
	public static List<Memory> calculateDataBlocks(String pattern){
		Queue<File> queue = DataParser.patternToFiles(pattern);
		
		List<Memory> memoryTable = new ArrayList<>();
		
		while(!queue.isEmpty()){
			File file = queue.poll();
			
			Memory memoryStep;
			if(memoryTable.isEmpty())
				memoryStep = new Memory();
			else
				memoryStep = new Memory(memoryTable.get(memoryTable.size()-1).getData().clone());
			if(file.getSize() > memoryStep.getFreeSpace()){
				memoryTable.add(null);
				break;
			}
			
			if(file.getEndState())
				memoryStep.removeFromMemory(file);
			else
				memoryStep.addToMemory(file);
			
			memoryTable.add(memoryStep);
		}
		
		return memoryTable;
	}
	
	public static double fragmentedFilesPecentageOfUsedSpace(List<Memory> memoryTable){
		Memory lastMemory = memoryTable.get(memoryTable.size()-1);
		int fragmentedSize = 0;
		for(File f : lastMemory.getFragmentedFiles()){
			fragmentedSize += f.getSize();
		}
		return Math.round(((double)fragmentedSize / (double)lastMemory.getUsedSpace())*100*100.0)/100.0;
	}
	
	public static double getFragmentedAmountPrecentage(List<Memory> memoryTable){
		Memory lastMemory = memoryTable.get(memoryTable.size()-1);
		return Math.round((double)lastMemory.getFragmentedFiles().size() / (double)lastMemory.getAllFiles().size() *100 *100.0)/100.0;
	}
	
	
	
}
