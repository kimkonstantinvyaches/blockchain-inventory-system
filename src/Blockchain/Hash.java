package Blockchain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    private static MessageDigest messageDigest;

    public static String hashing(byte[] blockBytes, String algorithm) {
        String hashResult = null;

        try {
            messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(blockBytes);
            byte[] hashBytes = messageDigest.digest(blockBytes);
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < hashBytes.length; i++) {
                stringBuilder.append(Integer.toHexString(0xFF & hashBytes[i]));
            }
            hashResult = stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashResult;
    }
}



