package rts.lab03;

import java.util.Random;

public class Philosopher implements Runnable {
	private int id;
	private Controller controller;
	private Random random = new Random();

	public Philosopher(int id, Controller controller) {
		super();
		this.id = id;
		this.controller = controller;
	}

	@Override
	public void run() {
		try {
			while (true) {
				haveLunch();
				Thread.sleep(1000 + random.nextInt(10));
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public  void haveLunch() throws InterruptedException {
		Plate plate = controller.getFreePlate();
		Fork leftFork = plate.getLeftFork();
		Fork rightFork = plate.getRightFork();
		boolean haveLunch = false;

		boolean hasLeftFork = controller.takeFork(leftFork);
		if (controller.isDeadlock()) {
			Thread.sleep(100);
		}
		boolean hasRightFork = controller.takeFork(rightFork);

		while (!haveLunch) {
			if (hasLeftFork && hasRightFork) {

				controller.showMessage("Философ " + id + " занял тарелку "
						+ plate.getId() + ",  вилки " + leftFork.getId()
						+ " и " + rightFork.getId() + "\n");
				Thread.sleep(1000 * random.nextInt(9) + 1000);
				finishLunch(plate);
				haveLunch = true;
			} else {

				if (!controller.isDeadlock()) {

					if (hasLeftFork) {
						controller.releaseFork(leftFork);
					}
					if (hasRightFork) {
						controller.releaseFork(rightFork);
					}
					Thread.sleep(1000);
					hasLeftFork = controller.takeFork(leftFork);
					hasRightFork = controller.takeFork(rightFork);
				} else {
					controller.showMessage("Для тарелки " + plate.getId()
							+ ", заняты вилки " + plate.getLeftFork().getId()
							+ " - " + hasLeftFork + " и "
							+ plate.getRightFork().getId() + " - "
							+ hasRightFork + "\n");
					Thread.sleep(1000);
					if (!hasLeftFork) {
						hasLeftFork = controller.takeFork(leftFork);
					}
					if (!hasRightFork) {
						hasRightFork = controller.takeFork(rightFork);
					}
				}
			}
		}
	}

	public  void finishLunch(Plate plate) {
		controller.releasePlateAndForks(plate);
		controller.showMessage("Философ " + id + " освободил тарелку "
				+ plate.getId() + ", вилки " + plate.getLeftFork().getId()
				+ " и " + plate.getRightFork().getId() + "\n");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

}
