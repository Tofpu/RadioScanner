package online.umbcraft.libraries.encrypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

public class HelpfulAESKey {

    private SecretKey AES_KEY;


    /**
     * Creates a {@link HelpfulRSAKeyPair} containing a randomly generated key
     */
    public HelpfulAESKey()  {
        KeyGenerator generator = null;
        try {
            generator = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        generator.init(128);
        AES_KEY = generator.generateKey();
    }


    /**
     * Creates a {@link SecretKey} object from a base64 encoded AES key
     *
     * @param key_b64           base64 encoded AES key
     *
     * @return the generated {@link SecretKey}
     */
    public HelpfulAESKey(String key_b64) {
        byte[] key_bytes = Base64.decodeBase64(key_b64);
        AES_KEY = new SecretKeySpec(key_bytes, 0, key_bytes.length, "AES");
    }


    /**
     * returns the base64 encoded representation of the contained AES key
     *
     * @return the base64 encoded key
     */
    public String key64() {
        return Base64.encodeBase64String(AES_KEY.getEncoded());
    }

    /**
     * returns the contained AES key
     *
     * @return the AES key
     */
    public SecretKey key() {
        return AES_KEY;
    }
}
