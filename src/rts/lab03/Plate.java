package rts.lab03;

public class Plate {
	private int id;
	private Fork leftFork;
	private Fork rightFork;
	private boolean enable;
	public Plate(int id) {
		super();
		this.id = id;
		this.enable=true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Fork getLeftFork() {
		return leftFork;
	}
	public void setLeftFork(Fork leftFork) {
		this.leftFork = leftFork;
	}
	public Fork getRightFork() {
		return rightFork;
	}
	public void setRightFork(Fork rightFork) {
		this.rightFork = rightFork;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

}
