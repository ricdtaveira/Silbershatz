package silberchatz.cap5.ipc; /**
 * This is the producer thread for the bounded buffer problem.
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */

import java.util.*;

class Producer implements Runnable
{
   public Producer(Channel m)
   {
      mbox = m;
   }              
   
   public void run()
   {
   Date message;
     
      while (true) { 
	SleepUtilities.nap();   
         message = new Date();      
	 System.out.println("Producer produced " + message);
         // produce an item & enter it into the buffer
         mbox.send(message);
      }
   }
   
   private  Channel mbox;
}
