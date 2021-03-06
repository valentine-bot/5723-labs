import java.net.DatagramPacket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Closeable;


public class ConsoleManager implements Closeable {

	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


	public void close() throws IOException {
		this.in.close();
	}	


	public String getMessage(DatagramPacket packet) {
		String message = new String(packet.getData());
		message = message.trim();

		return message;
	}


	public String read() throws IOException {
		String message = in.readLine();

		return message;
	}


	public synchronized void writeListCommands() {
		System.out.println("System:");
		//System.out.println("    Set connect with node:        @connect");
		System.out.println("    Send file:                    @send filename");
		System.out.println("    Cancel comman:                @cancel");
		System.out.println("    Set users name:               @name Vasya");
		System.out.println("    Commands list:                @help");
		System.out.println("    Quit program:                 @quit");
		System.out.println("    Send text message:            Hello");
	}


	public synchronized void printSystemMessage(String text, Throwable exception) {
		System.out.println("SYSTEM: " + text);
		if(exception != null) {
			System.out.println(exception);
		}
	}


	public synchronized void write(String message) {
		System.out.println(message);
	}

}