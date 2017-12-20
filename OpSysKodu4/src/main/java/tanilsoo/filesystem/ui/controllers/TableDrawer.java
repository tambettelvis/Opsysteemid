package tanilsoo.filesystem.ui.controllers;

import java.util.List;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import tanilsoo.filesystem.Memory;

public class TableDrawer extends Canvas {
	
	GraphicsContext gc;
	
	int rectWidth;
	int rectHeight;

	int paddingWidth = 60;
	int paddingHeight = 50;
	int heightBetweenSteps = 10;
	
	Color defaultColor = Color.BLACK;
	
	static Color[] colorCodes = {Color.GRAY, Color.GREEN, Color.RED, Color.LIGHTBLUE, Color.YELLOW, Color.BROWN, Color.MAGENTA, 
			Color.PINK, Color.AQUA, Color.DARKSLATEBLUE, Color.ORANGE, Color.CADETBLUE, Color.CORNSILK, Color.LIME};
	
	public TableDrawer(int width, int height) {
		super(width, height);
		gc = this.getGraphicsContext2D();
		
		rectWidth = (int)((getWidth() - paddingWidth) / Memory.MAX_BLOCK_LENGTH);
		rectHeight = (int)((getHeight() - paddingHeight) / Memory.MAX_FILES_AMOUNT);
	}
	
	public void drawTabel(List<Memory> memoryTable){
		clearCanvas();
		rectHeight = (int)((getHeight() - paddingHeight - (heightBetweenSteps * memoryTable.size())) / (memoryTable.size() + 1));
		
		int startX = 10;
		int startY = 10;
	
		int step = 0;
		drawRow(new Memory(), startX, startY, step++);
		startY += rectHeight + heightBetweenSteps;
		for(Memory memoryRow : memoryTable){
			if(memoryRow == null){
				drawEndRow(startX, startY, step++);
				return;
			}
			drawRow(memoryRow, startX, startY, step++);
			startY += rectHeight + heightBetweenSteps;
		}
	}
	
	public void drawEndRow(int x, int y, int currentStep){
		gc.strokeText("Samm " + currentStep, x, y + (rectHeight / 2));
		x+= paddingWidth;
		for(int i = 0; i < Memory.MAX_BLOCK_LENGTH; i++){
			drawRect(x, y, "", Color.BLACK);
			x += rectWidth;
		}
		
		gc.setStroke(Color.WHITE);
		gc.strokeText("Fail ei mahtunud mällu!", paddingWidth + (getWidth() / Memory.MAX_BLOCK_LENGTH), y + (rectHeight/1.5));
		gc.setStroke(Color.BLACK);
		
	}
	
	public void drawRow(Memory memory, int x, int y, int currentStep){
		gc.strokeText("Samm " + currentStep, x, y + (rectHeight / 2));
		x += paddingWidth;
		for(int i = 0; i < Memory.MAX_BLOCK_LENGTH; i++){
			drawRect(x, y, memory.getData()[i] == null ? "" : memory.getData()[i].getName(), 
					memory.getData()[i] == null ? Color.WHITE : colorCodes[memory.getData()[i].getId()]);
			x += rectWidth;
		}
	}
	
	public void drawRect(int x, int y, String text, Color color){
		gc.setFill(color);
		gc.strokeRect(x, y, rectWidth, rectHeight);
		gc.fillRect(x, y, rectWidth, rectHeight);
		gc.setFill(defaultColor);
		if(!text.isEmpty())
			gc.strokeText(text, x + (rectWidth/3) , y + (rectHeight/1.5));
	}
	
	public void clearCanvas() {
		gc.clearRect(0, 0, getWidth(), getHeight());
	}
	
}
