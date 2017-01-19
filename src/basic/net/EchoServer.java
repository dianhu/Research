package basic.net;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Time : 17-1-19 下午2:49
 * Author : hcy
 * Description : 接受客户端的socket请求并响应请求内容
 * example:telnet 127.0.0.1 9999  然后输入内容，这边就能打印输入的内容了
 */
public class EchoServer {
    public static void main(String args[]) {
        // declaration section:
        // declare a server socket and a client socket for the server
        // declare an input and an output stream
        ServerSocket echoServer = null;
        String line;
        DataInputStream is;
        PrintStream os;
        Socket clientSocket = null;
        // Try to open a server socket on port 9999
        // Note that we can't choose a port less than 1023 if we are not
        // privileged users (root)
        try {
            echoServer = new ServerSocket(9999);
        }
        catch (IOException e) {
            System.out.println(e);
        }
        // Create a socket object from the ServerSocket to listen and accept
        // connections.
        // Open input and output streams
        try {
            clientSocket = echoServer.accept();
            is = new DataInputStream(clientSocket.getInputStream());
            os = new PrintStream(clientSocket.getOutputStream());
            // As long as we receive data, echo that data back to the client.
            while (true) {
                line = is.readLine();
                os.println("神的回应："+line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
