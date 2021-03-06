package silberchatz.cap5;

/**
 *This program illustrates usage of the ThreaadLocal class
 *
 * Figure 5.12
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */

public class TSD
{
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Thread worker = new Thread(new Worker());
			worker.start();
		}
	}
}

/**
 * Each thread performs a transaction and every transaction is
 * identified by a separate serial number. For logging purposes,
 * we may wish to log the transaction being performed by each thread.
 */
class Worker implements Runnable
{
	public void run() {
		provider.transaction();
		System.out.println(Thread.currentThread().getName() + " > " + provider.getErrorCode() + " < ");
	}

	private static Service provider;
}
		

/**
 * This service class fulfills transactions which are performed by separate threads. Because a transaction
 * may result in an error, we need to record the error. However, since there is only a static instance
 * of this class, there is only one copy of errorCode. If an error occurs in one thread, it will set
 * the value of errorCode, however another thread may set it to a different value. The solution to this
 * is to use ThreadLocal copies of errorCode. Every thread that causes an error will set its own
 * copy of errorCode.
 *
 * In Java the use of thread local data is not as obvious. For example, you could subclass the Thread
 * class and declare instance data that provides a separate copy for each thread. However, if you do
 * not have control over the thread creation process (i.e. you are using a thread pool), then you must
 * use a strategy such as thread local data.
 */

class Service
{
	public static void transaction() {
		// fulfill some kind of transaction service
		try { Thread.sleep( (int) (Math.random() * 1000) ); } catch (InterruptedException ie) { }
                
		try {
			/**
			 * some operation where an error may occur
			 */
                	int num = (int) (Math.random() * 2);
			double recip = 1 / num;
		}
		catch (Exception e) {
			errorCode.set(e);
		}
	}	

	/**
	 * get the error code for this transaction
	 */
	public static Object getErrorCode() {
		System.out.println("calling get() " + Thread.currentThread().getName());
		return errorCode.get();
	}

	private static ThreadLocal errorCode = new ThreadLocal();
}
