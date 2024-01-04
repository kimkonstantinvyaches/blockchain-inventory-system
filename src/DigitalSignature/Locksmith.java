package DigitalSignature;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import Blockchain.Data.Config;

public class Locksmith {
    KeyPairGenerator keyPairGenerator;
    KeyPair keyPair;

    public Locksmith() throws NoSuchAlgorithmException{
        keyPairGenerator = KeyPairGenerator.getInstance(Config.ALGORITHM);
        keyPairGenerator.initialize(1024); //Size of key
    }

    public static void createKeyPair() {
        try {
            Locksmith keymaker = new Locksmith();
            keymaker.keyPair = keymaker.keyPairGenerator.generateKeyPair();
            PublicKey publicKey = keymaker.keyPair.getPublic();
            PrivateKey privateKey = keymaker.keyPair.getPrivate();
            recordKey(Config.PUBLICKEY_FILE, publicKey.getEncoded());
            recordKey(Config.PRIVATEKEY_FILE, privateKey.getEncoded());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void recordKey(String filepath, byte[] key) {
        File file = new File(filepath);
        file.getParentFile().mkdir();
        try {
            Files.write(Paths.get(filepath), key, StandardOpenOption.CREATE);
        } catch (Exception e) {
            System.out.println("failed here");
            e.printStackTrace();
        }
    }

    public static PublicKey getPublicKey() throws Exception {
        byte[] keyBytes = Files.readAllBytes(Paths.get(Config.PUBLICKEY_FILE));
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance(Config.ALGORITHM).generatePublic(keySpec);
    }

    public static PrivateKey getPrivateKey() throws Exception {
        byte[] keyBytes = Files.readAllBytes(Paths.get(Config.PRIVATEKEY_FILE));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance(Config.ALGORITHM).generatePrivate(keySpec);
    }

}
