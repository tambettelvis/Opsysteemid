package tanilsoo.filesystem;

public class File {

	
	private int id = -1;
	private String name;
	private int size;
	private boolean endState = false;
	
	public File(int id, String name, int size) {
		this.setName(name);
		this.setSize(size);
		this.id = id;
	}
	
	public File(String name, int size, boolean endState){
		this.name = name;
		this.size = size;
		this.endState = endState;
	}
	
	@Override
	public String toString(){
		return name + " size: " + size;
	}
	
	public boolean getEndState(){
		return endState;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
