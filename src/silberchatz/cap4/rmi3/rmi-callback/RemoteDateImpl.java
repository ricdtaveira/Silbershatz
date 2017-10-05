package silberchatz.cap4.rmi3.rmi /**
 * RemoteDate interface implementation.
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
 
import java.rmi.*;

public class RemoteDateImpl extends UnicastRemoteObject implements RemoteDate
{
    public RemoteDateImpl() throws RemoteException {  }
    
    public  Date getDate() throws RemoteException {
        return new Date();
    }
    
    public  void getDate(DateObject date) throws RemoteException {
        date.setDate(new Date());
    }
    
   public static void main(String[] args)  {
        try {
            RemoteDate dateServer = new RemoteDateImpl();

            // Bind this object instance to the name "DateServer"
            //Naming.rebind("DateServer", dateServer);
            Naming.rebind("//localhost:1099/DateServer", dateServer);

            System.out.println("DateServer bound in registry");
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
  
   
   
}
