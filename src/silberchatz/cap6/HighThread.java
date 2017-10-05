package silberchatz.cap6;

/**
 * This program illustrates setting the priority of a Java thread
 *
 * Figure 6.13
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */

public class HighThread implements Runnable
{
	public void run() {
		Thread.currentThread().setPriority(Thread.NORM_PRIORITY + 1);
                System.out.println("I am the HighThread and my priority is " + Thread.currentThread().getPriority());

		// remainder of the run() method
                // . . .
	}
}
