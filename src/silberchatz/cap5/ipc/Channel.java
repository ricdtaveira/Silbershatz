package silberchatz.cap5.ipc;

/**
 * An interface for a message passing scheme.
 *
 * Figure 4.13
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */

public interface Channel
{
        /**
         * Send a message to the channel.
         * It is possible that this method may or may not block.
         */
	public  abstract void send(Object message);
        
        /**
         * Receive a message from the channel
         * It is possible that this method may or may not block.
         */
	public  abstract Object receive();
}
