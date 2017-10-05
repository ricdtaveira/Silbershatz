package silberchatz.cap4.rmi3.rmi /**
 * RemoteDate interface
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */
import java.util.Date;
import java.rmi.*;

public interface RemoteDate extends Remote
{
	public abstract Date getDate() throws RemoteException;
        public abstract void getDate(DateObject date) throws RemoteException;
}
