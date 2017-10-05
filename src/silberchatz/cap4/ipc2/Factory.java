package silberchatz.cap4.ipc2; /**
 * This creates the mailbox and the producer and consumer threads.
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */

import java.util.*;
 
public class Factory 
{  
   public Factory()
   {
      // first create the message buffer     
      Channel mailBox = new MessageQueue();
      
      // now create the producer and consumer threads
      Thread producerThread = new Thread(new Producer(mailBox));
      Thread consumerThread = new Thread(new Consumer(mailBox));
      
      producerThread.start();
      consumerThread.start();               
   }

   public static void main(String args[]) { 
      Factory server = new Factory();
   }
}

