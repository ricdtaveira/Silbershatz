package silberchatz.cap5;

/**
 * This program creates a simple thread by extending the 
 * java.lang.Thread class.
 *
 * Figure 5.8
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */

class Worker1 extends Thread
{
   public void run() {
      System.out.println("I Am a Worker Thread");
   }
}

public class First
{
   public static void main(String args[]) {
      Thread runner = new Worker1();
      
      runner.start();

	System.out.println("I Am The Main Thread");
   }
}



