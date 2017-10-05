package silberchatz.cap5;

/**
 * This program creates a separate thread by extending
 * the java.lang.Runnable interface.
 *
 * Figure 5.9
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */

class Worker2 implements Runnable
{
   public void run() {
      System.out.println("I Am a Worker Thread ");
   }
}
 
public class Second
{
   public static void main(String args[]) {
      Runnable runner = new Worker2();
      
      Thread thrd = new Thread(runner);
      
      thrd.start();

	System.out.println("I Am The Main Thread");
   }
}
