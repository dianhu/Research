package basic.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Time : 17-7-2 下午9:38
 * Author : hcy
 * Description :
 */
public class ClientSocket {
    public static void main(String[] args) {
        SocketChannel socketChannel = null;
        Selector selector = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);//设置非阻塞模式
            socketChannel.connect(new InetSocketAddress("localhost",9999));
            selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);//注册到对应的selector和设置关注的事件
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
                    if(key.isConnectable()){
                        System.out.println("is connecting to remote server");
                        SocketChannel channel = (SocketChannel) key.channel();
                        if(channel.isConnectionPending()){
                            channel.finishConnect();
                            System.out.println("connected remote server");
                        }
                        channel.register(selector,SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                    }
                    if(key.isReadable()){
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        socketChannel.read(output);//读取echo的内容到output

                    }
                    if(key.isWritable()){
                        ByteBuffer output = ByteBuffer.allocate(100);
                        output.put("你好，我是hcy的手下".getBytes());
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
