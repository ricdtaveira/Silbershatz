package silberchatz.cap4.rmi3.rmi

/**
 * RemoteDate interface iplementation.
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */
public class DateObjectImpl extends java.rmi.server.UnicastRemoteObject implements DateObject
{
	private java.util.Date date;

	public DateObjectImpl() throws java.rmi.RemoteException { }

	public void setDate(java.util.Date date) throws java.rmi.RemoteException {
		this.date = date;
	}

	public java.util.Date getDate() {
		return date;
	}

	public String toString() {
		return date.toString();
	}
}
