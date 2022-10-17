import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;


public class groupserver implements Runnable {
    Socket s;
    public static Vector client1 = new Vector();
    // vector comes from util package
    // now adding all messages on vector and we have to broadcast messages to every client
    // vector class is something like arraylist which is comes from AbstractList class implements List
    //  and further class abstract AbstractCollection which implements Collection interface which extends iterable class which is further acts as an interface. 

    // we can always use map() instead of vector
    groupserver(Socket s){
        // we use constructor to initialize our variables
        try {
            this.s = s;
        } catch (Exception e) {
            
        }
    }

    public static void main(String[] args)  {
       

        try {
            ServerSocket skt = new ServerSocket(2003);
            // this class comes from java.net package
            // now we have to connect our client to server
            while (true) {
                // creating clients
                Socket s = skt.accept();
                 // this class comes from java.net package
                groupserver server =  new groupserver(s);
                // explicitly defining object of Thread class   
                // passimg object of groupserver class to Thread class because we have to run clients on thread
                 Thread thread = new Thread(server);
                //  with the help of multithreading we can run all our clients at once.
                // all we have to do just we have to connect our clients with Thread thread = new Thread(server); 
                thread.start();

            }
            
        } catch (Exception e) {
          e.printStackTrace();
        }
    }

    @Override
    public void run() {
    //    for reading and writing messages we are using bufferreader class and bufferwriter class comes under io package.
    try {
       BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream())); 
    //    client1 is trying to read the message with the help of bufferreader class.
    // while in previous we have achieve it using DataInputStream din = new DataInputStream(s.getInputStream());
    // s is object of client socket class
    // InputStreamReader accepts message from client1.getInputStream() and reading message with the help of BufferReader.

    // creating object of Bufferwriter to pass message from client1 to any other client
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
    
    // now i have to create the user for creating user we will use one method called public static Vector client1 = new Vector(); defines globally means above constructor.
    client1.add(writer);
    // passing every messages to client1.
    while (true) {

        String data = reader.readLine().trim();
        // taking message from bufferreader class to String variable
        // trim() use to trim empty spaces while passing message sometimes users give space for that spaces we have to trim() that spaces.
        System.out.println("Received " + data );
        
        // now broadcast everyclient to receive to pass messages

        for(int i=0;i<client1.size();i++){
            try {
                BufferedWriter bw = (BufferedWriter) client1.get(i);
                // we cant convert object to BufferedWriter means client1 is the object of vector class for that we have to cast with BufferedWriter.
                // for broadcasting the message we can use write
                bw.write(data);
                // server accepts data write data to its own dispaly.
                // then we are returning all messages with the help of char h as mention below.  
                bw.write("\r\n");
                // important concept
                // returning char h in java
                bw.flush();
                // flush() use to send message to other clients. 
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
        
    }

    } catch (Exception e) {
       e.printStackTrace();
    }
    
        
    }
}
