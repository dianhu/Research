package basic.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Time : 17-7-2 下午3:06
 * Author : hcy
 * Description :
 */
public class EchoServer {


    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel = null;
        Selector selector = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);//设置非阻塞模式

            ServerSocket serverSocket = serverSocketChannel.socket();//得到ServerSocket
            serverSocket.bind(new InetSocketAddress(9999));//绑定端口号

            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);//注册到对应的selector和设置关注的事件
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true){
            try {
                selector.select();
            }catch (IOException e){
                e.printStackTrace();
                break;
            }
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iter = keys.iterator();
            while (iter.hasNext()){
                SelectionKey key = iter.next();
                iter.remove();
                try {
                    if(key.isAcceptable()){
                        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = serverChannel.accept();
                        System.out.println("Accepted connection from "+socketChannel);
                        socketChannel.configureBlocking(false);
                        SelectionKey key1 = socketChannel.register(selector,SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        key1.attach(ByteBuffer.allocate(100));
                    }
                    if(key.isReadable()){
                        System.out.println("监听到可以读取了...");
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        socketChannel.read(output);//读取echo的内容到output

                    }
                    if(key.isWritable()){
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        output.flip();
                        socketChannel.write(output);//把output的内容写到管道中
                        output.compact();
                    }
                }catch (Exception e){
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }
}
