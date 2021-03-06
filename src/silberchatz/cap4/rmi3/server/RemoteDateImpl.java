package silberchatz.cap4.rmi3.server;

/**
 * Implementation of the RemoteDate interface
 *
 * Figure 4.24
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class RemoteDateImpl extends UnicastRemoteObject implements RemoteDate
{
    public RemoteDateImpl() throws RemoteException {  }
    
    public  Date getDate() throws RemoteException {
        return new Date();
    }
    
   public static void main(String[] args)  {
        try {
		/** 
                 * we only need to install this to distribute classes
                 * 	System.setSecurityManager(new RMISecurityManager());
                 */
            RemoteDate dateServer = new RemoteDateImpl();

            // Bind this object instance to the name "DateServer"
            Naming.rebind("DateServer", dateServer);
            //Naming.rebind("//localhost:1099/DateServer", dateServer);

            System.out.println("DateServer bound in registry");
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
  
   
   
}
