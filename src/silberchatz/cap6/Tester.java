package silberchatz.cap6;

/**
 * This program generates an instance of HighThread. 
 * Both the thread running in this class and the HighThread
 * each report the value of their priority.
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */

public class Tester
{
	public static void main(String[] args) {
		System.out.println("I am the main thread and my priority is " + Thread.currentThread().getPriority());

		// now create HighThread
		Thread worker = new Thread(new HighThread());
		worker.start();

		try {
			worker.join();
		}
		catch (InterruptedException ie) { }
	}
}
