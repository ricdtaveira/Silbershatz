package silberchatz.cap8; /**
 * This applet displays the time of day.
 *
 * The calls to System.out.println() are purely for debugging - use
 * the Java console with your browser to see these output statements.
 *
 * Figure 8.6
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */
 
import java.applet.*;
import java.awt.*;

public class ClockApplet extends Applet implements Runnable
{
   public void run() {
      while (true) {
         try {
	    // sleep for one second
            Thread.sleep(1000);
       	
	    // now repaint the date and time 
            repaint();
        
	    // check if we need to suspend ourself 
            synchronized (mutex) {
               while (ok == false)
                     mutex.wait();
            }
         }
         catch (InterruptedException e) { }
      }
      //System.out.println("terminating thread");
   }
   
   // this method is called when the applet is 
   // started or we return to the applet
   public void start() {
      if ( clockThread == null ) {
         System.out.println("creating thread");
         ok = true;
         clockThread = new Thread(this);
         clockThread.start();
      }
      else {
         System.out.println("resuming thread");
         synchronized(mutex) {
            ok = true;
            mutex.notify();
         }
      }
   }
   
   // this method is called when we
   // leave the page the applet is on
   public void stop() {
         System.out.println("suspending thread");
         synchronized(mutex) {
            ok = false;
         }
   }
   
   // this method is called when the applet is removed from the cache
/*
   public void destroy() {
        clockThread = null;
	System.out.println("destroying applet");
   }
*/
 
   public void paint(Graphics g) {
      g.drawString( new java.util.Date().toString(), 10, 30);
      System.out.println( new java.util.Date().toString());
   }
   
   private volatile Thread clockThread;
   private boolean ok = false;
   Object mutex = new Object();
}
