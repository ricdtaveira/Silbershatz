package silberchatz.cap4.sockets4; /**
 * Servidor de Hora do Dia ouvindo a porta 6013.
 *
 * Figure 4.18
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Sixth Edition
 * Copyright John Wiley & Sons - 2003.
 */
 
import java.net.*;
import java.io.*;

public class DateServer
{
	public static void main(String[] args) throws IOException {
		Socket client     = null;
		ServerSocket sock = null;

		try {
			sock = new ServerSocket(6013);
			// now listen for connections
			while (true) {
				client = sock.accept();
				System.out.println("server = " + sock);
				System.out.println("client = " + client);

				// we have a connection
				PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
				// write the Date to the socket
				pout.println(new java.util.Date().toString());

				pout.close();
				client.close();
			}
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
		finally {
			if (sock != null)
				sock.close();
			if (client != null)
				client.close();
		}
	}
}
