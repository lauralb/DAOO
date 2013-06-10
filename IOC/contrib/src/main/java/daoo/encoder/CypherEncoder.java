package daoo.encoder;

import com.sun.istack.internal.NotNull;
import daoo.ioc.MessageEncoder;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class CypherEncoder implements MessageEncoder {

    public static final SecretKeySpec SECRET_KEY = generateKey();

    @Override
    public byte[] encode(@NotNull String message) {
        try{
            Cipher aes = Cipher.getInstance("AES");
            aes.init(Cipher.ENCRYPT_MODE, SECRET_KEY);
            byte[] ciphertext = aes.doFinal(message.getBytes());
            return ciphertext;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String decode(@NotNull byte[] message) {
        try{
            Cipher aes = Cipher.getInstance("AES");
            aes.init(Cipher.DECRYPT_MODE, SECRET_KEY);
            String cleartext = new String(aes.doFinal(message));
            return cleartext;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static SecretKeySpec generateKey()  {
        String passphrase = "correct horse battery staple";
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        digest.update(passphrase.getBytes());
        SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");
        return key;
    }

    public static void main(String[] args) {
        CypherEncoder c=new CypherEncoder();
        System.out.println(c.decode(c.encode("pizza party ")));
        System.out.println(c.encode("pizza party"));
        System.out.println(c.decode("pizza party".getBytes()));
    }



}
