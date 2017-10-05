package silberchatz.cap4.rmi3.rmi

/**
 * DateObject interface.
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */
public interface DateObject extends java.rmi.Remote
{
	public void setDate(java.util.Date date) throws java.rmi.RemoteException;
}
