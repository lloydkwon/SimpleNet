package com.github.simplenet;

import com.github.simplenet.packet.Packet;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Client client = new Client();

        client.connect("localhost", 8099,executorService);

        Packet.builder().putBytes(readData("./data/10H")).queueAndFlush(client);
        Packet.builder().putBytes(readData("./data/11H")).queueAndFlush(client);
        Packet.builder().putBytes(readData("./data/12H")).queueAndFlush(client);
        Packet.builder().putBytes(readData("./data/13H")).queueAndFlush(client);



//        client.close();
//        executorService.shutdown();
        Thread.sleep(1000);

        Packet.builder().putBytes(readData("./data/10H")).queueAndFlush(client);
        Packet.builder().putBytes(readData("./data/11H")).queueAndFlush(client);
        Packet.builder().putBytes(readData("./data/12H")).queueAndFlush(client);
        Packet.builder().putBytes(readData("./data/13H")).queueAndFlush(client);
        Thread.sleep(1000);



    }
    private static byte[] readData(String path) throws IOException {
        String s = FileUtils.readFileToString(new File(path), "UTF-8");
        byte[] bytes = Base64.decodeBase64(s);
        return bytes;
    }
}
