package silberchatz.cap4.rmi3.client;

/**
 * The RMI Client
 *
 * Figure 4.25
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */

import java.rmi.*;


import silberchatz.cap4.rmi3.server.RemoteDate;


public class RMIClient 
{  
   public static void main(String args[]) { 
    try {
        /**
         * We only need this for loading remote classes
         * System.setSecurityManager(new RMISecurityManager());
         */
      String host = "rmi://127.0.0.1/DateServer";
      RemoteDate dateServer = (RemoteDate)Naming.lookup(host);
      System.out.println(dateServer.getDate());
    }
    catch (Exception e) {
        System.err.println(e);
    }
   }
}

