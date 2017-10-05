package silberchatz.cap4.rmi3.server;

/**
 * The remote interface
 *
 * Figure 4.23
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
}
