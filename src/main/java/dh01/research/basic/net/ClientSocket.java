package dh01.research.basic.net;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * Time : 17-1-19 下午2:17
 * Author : hcy
 * Description : 一个简单的socket客户端
 */
public class ClientSocket {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8989;
        try {
            Socket client = new Socket(host,port);
            Writer writer = new OutputStreamWriter(client.getOutputStream());
            writer.write("Hello from hcy's socket client");
            writer.flush();
            writer.close();
            client.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
