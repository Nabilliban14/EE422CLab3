package assignment3;

public class word {
	
	private String value;
	private word parent;

	public word(String val){

		this.value = val;
		this.parent = null;

	}

	public void setParent(word w){
		this.parent =w;
	}
	public word getParent(){
		return this.parent;
	}
	public String getValue(){
		return this.value;
	}


}
