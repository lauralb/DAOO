package daoo.tasks;

import daoo.encoder.SimpleEncoder;
import daoo.ioc.MessageEncoder;
import daoo.ioc.MessageEncoderProvider;
import daoo.server.Task;


import java.io.*;
import java.net.Socket;


public class EncoderTask  extends Task {

    private final MessageEncoderProvider messageEncoderProvider;

    public EncoderTask(Socket socket, MessageEncoderProvider messageEncoderProvider) {
        super(socket);
        this.messageEncoderProvider = messageEncoderProvider;
    }

    @Override protected void task() throws IOException {
        print("encoding...");
        encode();
    }

    private void encode() throws IOException {

        final MessageEncoder messageEncoder = messageEncoderProvider.getMessageEncoder();

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
        if(dividedPath.length > 2){
            String action = dividedPath[1];
            String message = dividedPath[2];
            if (action.equals("encode")){
                out.write("You asked to encode:" +"\r\n");
                out.write(message+"\r\n");
                out.write("Your encoded message is:" +"\r\n");
                out.write(new String(messageEncoder.encode(message))+"\r\n");
            } else if (action.equals("decode")){
                out.write("You asked to decode:" +"\r\n");
                out.write(message+"\r\n");
                out.write("Your decoded message is:" +"\r\n");
                out.write(messageEncoder.decode(message.getBytes())+"\r\n");
            }else if(action.equals("encode-decode")){
                final String result = messageEncoder.decode(messageEncoder.encode(message).toString().getBytes()).toString();
                out.write(result +"\r\n");
            }
            else {
                out.write("Please specify : encode, decode or encode-decode / message" +"\r\n");
            }
        }else{
            out.write("Please specify : encode, decode or encode-decode / message" +"\r\n");
        }


        out.close();
        in.close();

    }


}



