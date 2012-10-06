package rts.lab03;

public class Fork {
	private int id;
	private boolean enable;

	public Fork(int id) {
		super();
		this.id = id;
		this.enable = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
}
