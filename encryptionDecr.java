package dashboardcw;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Abdulrahman Ibrahim
 */


public class encryptionDecr {
    private static final String encryptDecryptTypeAES = "AES";
    private byte[] valueEncryptDecrByte;
    
    public encryptionDecr(String encryptedText){
        
        valueEncryptDecrByte = encryptedText.getBytes();
    }

    public String encryptData(String textForEncryption) throws Exception{
        Key myKey = getAkey();
        Cipher myCipher = Cipher.getInstance(encryptDecryptTypeAES);
        myCipher.init(Cipher.ENCRYPT_MODE, myKey);
        byte[] encryptedByte = myCipher.doFinal(textForEncryption.getBytes());
        String newEncryptedString = new BASE64Encoder().encode(encryptedByte);
        
        
        return newEncryptedString;
        
        
        
    }
    
     public String decryptData(String textForEncryption) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException{
        Key myKey = getAkey();
        Cipher myCipher = Cipher.getInstance(encryptDecryptTypeAES);
        myCipher.init(Cipher.DECRYPT_MODE, myKey);
        byte[] decodeType = new BASE64Decoder().decodeBuffer(textForEncryption);
        byte[] encryptedByte = myCipher.doFinal(decodeType);
        String newDecryptedString = new String(encryptedByte);
             
        return newDecryptedString;  
    }

    private Key getAkey(){
        Key myKey = new SecretKeySpec(valueEncryptDecrByte, encryptDecryptTypeAES);
        return myKey;
    }
}

