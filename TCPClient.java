package networks;

import java.io.*;
import java.net.*;

public class TCPClient {

	public static void main(String argv[]) throws Exception {
		String sentence; //el beygelk ml console
		String modifiedSentence; //bygelk mn server
		String chat = "";  
		
			
			BufferedReader inFromUser = new BufferedReader(
					new InputStreamReader(System.in));
			sentence = inFromUser.readLine(); //took info from user in console 
			if (sentence.contentEquals("CONNECT")) { //user katab connect fl console
				System.out.println("connection established");
				Socket clientSocket = new Socket("127.0.0.1", 6789);// bta3 el server

			DataOutputStream outToServer = new DataOutputStream(
					clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));

			while (true) { //while connected
				if(chat.contentEquals("Disconnect")){
					clientSocket.close();
				}
				
				if(inFromServer.ready()){ //
					modifiedSentence = inFromServer.readLine();
					
					

					System.out.println("FROM SERVER: " + modifiedSentence);
				}
				if(inFromUser.ready()){  //USER ANDO HAGA YB3THA
					chat=inFromUser.readLine();
					outToServer.writeBytes(chat + '\n'); //will send to server chat
				}
				
				

				

			}

		}

	}

}
