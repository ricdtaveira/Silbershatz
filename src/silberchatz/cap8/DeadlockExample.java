package silberchatz.cap8;

/**
 * This program gives an example of how deadlock can occur between threads.
 * This program differs from the book as each thread will sleep a random
 * amount of time between calls to the synchronized statement. It may require
 * several runs of the program to deadlock the threads.
 *
 * Figure 8.4
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */

class Mutex
{

}

class A implements Runnable
{
   private Mutex first, second;
   
   public A(Mutex f, Mutex s) {
      first = f;
      second = s;
   }
   
   public void run() {
      synchronized (first) {
         // do something

	try { 
		Thread.sleep( ((int)(3*Math.random()))*1000);
	}
	catch (InterruptedException e) {}

         System.out.println("threadA got first mutex");
         synchronized (second) {
            // do something
            System.out.println("threadA got second mutex");
            
         }
      }
   }
}

class B implements Runnable
{
   private Mutex first, second;
   
   public B(Mutex f, Mutex s) {
      first = f;
      second = s;
   }
   
   public void run() {
      synchronized (second) {
         // do something

	try { 
                Thread.sleep( ((int)(3*Math.random()))*1000);
        }
        catch (InterruptedException e) {}

         System.out.println("threadB got second mutex");
         synchronized (first) {
            // do something
            System.out.println("threadB got first mutex");
         }
      }
   }
}


public class DeadlockExample 
{  
   public static void main(String arg[]) {         
      Mutex mutexX = new Mutex();
      Mutex mutexY = new Mutex();
      
      Thread threadA = new Thread(new A(mutexX,mutexY));
      Thread threadB = new Thread(new B(mutexX,mutexY));
      
      threadA.start();
      threadB.start();
   }
}

