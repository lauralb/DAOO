package daoo.tasks;

import daoo.encoder.InvertEncoder;
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
        if(dividedPath.length > 2){
            String action = dividedPath[1];
            String message = dividedPath[2];
            if (action.equals("encode")){
                final String result = invertEncoder.encode(message).toString();
                out.write(result+"\r\n");
            } else if (action.equals("decode")){
                final String result = invertEncoder.decode(message.getBytes()).toString();
                out.write(result+"\r\n");
            }else if(action.equals("encode-decode")){
                final String result = invertEncoder.decode(invertEncoder.encode(message).toString().getBytes()).toString();
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



