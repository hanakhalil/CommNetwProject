package networks;


import java.io.*; 
import java.net.*; 

public class TCPServer { 

  public static void main(String argv[]) throws Exception 
    { 
      String clientSentence; 
      String capitalizedSentence; 
      String chat2="";
      String sentence2 ="";

      ServerSocket welcomeSocket = new ServerSocket(6789); 
        
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				System.in)); //allow eny aktb f console server
        sentence2=inFromServer.readLine();
        if (sentence2.contentEquals("CONNECT")) {
			System.out.println("connection established");
             
              
        Socket connectionSocket = welcomeSocket.accept(); //wafe2 al connection
      
      BufferedReader inFromClient = 
              new BufferedReader(new
              InputStreamReader(connectionSocket.getInputStream())); //kalam gy ml client 
           DataOutputStream  outToClient = 
                   new DataOutputStream(connectionSocket.getOutputStream()); //el b3to lel client
          
           
      

      while(true) { 
    	  if(inFromServer.ready()){ //kateb f conxole server haga
				chat2=inFromServer.readLine();
				outToClient.writeBytes(chat2 + '\n');
			}
    	  if(inFromClient.ready()){ //gyly haga ml client
    		  clientSentence = inFromClient.readLine(); //el gylo ml client

              capitalizedSentence = clientSentence.toUpperCase() + '\n'; 

              System.out.println("USER:"+capitalizedSentence );
    	  
    	 
				

				
			}
            
    	
           
              } 


    }
    }
}


