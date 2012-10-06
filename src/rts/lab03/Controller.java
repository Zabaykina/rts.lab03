package rts.lab03;

import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Controller {

	private List<Philosopher> philosophers = new ArrayList<Philosopher>();
	private List<Plate> plates = new ArrayList<Plate>();
	private List<Fork> forks = new ArrayList<Fork>();
	private ThreadGroup philosopherGroup = new ThreadGroup("philosophers");
	private List<Thread> philospherThreads = new ArrayList<Thread>();

	private Boolean deadlock;
	private JTextArea textArea;
	private List<JLabel> lblPlates;
	private List<JLabel> lblForks;

	public Controller(Boolean deadlock, JTextArea textArea,
			List<JLabel> lblPlates, List<JLabel> lblForks) {
		this();
		this.deadlock = deadlock;
		this.textArea = textArea;
		this.lblPlates = lblPlates;
		this.lblForks = lblForks;
	}

	private Controller() {
		super();
		for (int i = 1; i <= 5; i++) {
			philosophers.add(new Philosopher(i, this));
			plates.add(new Plate(i));
			forks.add(new Fork(i));
		}

		plates.get(0).setLeftFork(forks.get(1));
		plates.get(0).setRightFork(forks.get(0));

		plates.get(1).setLeftFork(forks.get(2));
		plates.get(1).setRightFork(forks.get(1));

		plates.get(2).setLeftFork(forks.get(3));
		plates.get(2).setRightFork(forks.get(2));

		plates.get(3).setLeftFork(forks.get(4));
		plates.get(3).setRightFork(forks.get(3));

		plates.get(4).setLeftFork(forks.get(0));
		plates.get(4).setRightFork(forks.get(4));

	}

	public void start() {
		textArea.append("clear \n");
		textArea.append("deadlock: " + deadlock + "\n");
		clear();
		for (Philosopher philosopher : philosophers) {
			new Thread(philosopherGroup, philosopher).start();
		}

	}

	public void clear() {
		for (Plate plate : plates) {
			plate.setEnable(true);
		}

		for (Fork fork : forks) {
			fork.setEnable(true);
		}

		for (JLabel lblPlate : lblPlates) {
			lblPlate.setEnabled(true);
		}
		for (JLabel lblFork : lblForks) {
			lblFork.setEnabled(true);
		}
	}

	public void stop() {
		philosopherGroup.interrupt();
	}

	public synchronized Plate getFreePlate() {
		Plate freePlate = null;
		for (Plate plate : plates) {
			if (plate.isEnable()) {
				freePlate = plate;
				plate.setEnable(false);
				lblPlates.get((plates.indexOf(plate))).setEnabled(false);
				break;
			}
		}
		return freePlate;
	}

	public synchronized Boolean takeFork(Fork fork) {
		if (fork.isEnable()) {
			fork.setEnable(false);
			lblForks.get(forks.indexOf(fork)).setEnabled(false);
			return true;
		} else {
			return false;
		}
	}

	public synchronized void releasePlateAndForks(Plate plate) {
		plate.setEnable(true);
		lblPlates.get(plates.indexOf(plate)).setEnabled(true);

		releaseFork(plate.getLeftFork());
		releaseFork(plate.getRightFork());
	}

	public synchronized void releaseFork(Fork fork) {
		fork.setEnable(true);
		lblForks.get(forks.indexOf(fork)).setEnabled(true);
	}

	public void showMessage(String message) {
		textArea.append(message);
	}

	public List<Philosopher> getPhilosophers() {
		return philosophers;
	}

	public void setPhilosophers(List<Philosopher> philosophers) {
		this.philosophers = philosophers;
	}

	public List<Plate> getPlates() {
		return plates;
	}

	public void setPlates(List<Plate> plates) {
		this.plates = plates;
	}

	public List<Fork> getForks() {
		return forks;
	}

	public void setForks(List<Fork> forks) {
		this.forks = forks;
	}

	public Boolean isDeadlock() {
		return deadlock;
	}

	public void setDeadlock(Boolean deadlock) {
		this.deadlock = deadlock;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public List<JLabel> getLblPlates() {
		return lblPlates;
	}

	public void setLblPlates(List<JLabel> lblPlates) {
		this.lblPlates = lblPlates;
	}

	public List<JLabel> getLblForks() {
		return lblForks;
	}

	public void setLblForks(List<JLabel> lblForks) {
		this.lblForks = lblForks;
	}

}
