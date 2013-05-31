package daoo.tasks;

import daoo.encoder.InvertEncoder;
import daoo.ioc.MessageEncoder;
import daoo.server.Task;


import java.io.*;
import java.net.Socket;


public class EncoderTask  extends Task {

    public EncoderTask(Socket socket) { super(socket); }

    @Override protected void task() throws IOException {
        print("encoding...");
        encode();
    }

    private void encode() throws IOException {

        final InvertEncoder invertEncoder = new InvertEncoder();

        final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        final StringBuilder header = new StringBuilder();

        while (true) {
            final String s = in.readLine();
            if(s == null || s.isEmpty()) break;
            header.append(s);
        }

        out.write("HTTP/1.1 200 OK\r\n");
        out.write("Content-Type: text/plain\r\n");

        // Encoder path
        out.write("\r\n");

        final String[] dividedPath = getHeaderPath(header.toString()).split("/");

        if (dividedPath[1].equals("encode")){
            final String path = invertEncoder.encode(dividedPath[2]).toString();
            out.write(path+"\r\n");
        } else if (dividedPath[1].equals("decode")){
            final String path = invertEncoder.decode(dividedPath[2].getBytes()).toString();
            out.write(path+"\r\n");
        } else {
            out.write("Please specify a task, Like encode or decode" +"\r\n");
        }

        out.close();
        in.close();

    }


}



