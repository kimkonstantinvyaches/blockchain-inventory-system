package DigitalSignature;

import java.security.Signature;
import java.util.Base64;

import Blockchain.Data.Config;

public class DigitalSignature {
    private Signature signature;

    public DigitalSignature() {
        try {
            signature = Signature.getInstance(Config.SIGNATURE_ALGORITHM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String sign(String data) {
        try {
            signature.initSign(Locksmith.getPrivateKey());
            signature.update(data.getBytes());
            byte[] digitalSignatureBytes = signature.sign();
            return Base64.getEncoder().encodeToString(digitalSignatureBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean verifySignature(String data, String digitalSignature) throws Exception {
        signature.initVerify(Locksmith.getPublicKey());
        signature.update(data.getBytes());
        return signature.verify(Base64.getDecoder().decode(digitalSignature));
    }
}
