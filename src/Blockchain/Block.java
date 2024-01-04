package Blockchain;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import Blockchain.Data.Config;
import DigitalSignature.DigitalSignature;

public class Block implements Serializable {

    public static int indexCounter;

    private int blockIndex;
    private Object blockchainData;
    private String preHash;
    private String nowHash;
    private long timeStamp;

    //Add new block constructor
    public Block(Object blockchainData, String preHash, int preBlockIndex) throws Exception{
        super();
        this.blockchainData = blockchainData;
        this.blockIndex = ++preBlockIndex;
        this.preHash = preHash;
        this.timeStamp = new Timestamp(System.currentTimeMillis()).getTime();
        this.nowHash = new DigitalSignature().sign(generateBlock());
    }

    //Verify block constructor
    public Block(int blockIndex, Object data, String preHash, long timeStamp) {
        super();
        this.blockchainData = data;
        this.blockIndex = blockIndex;
        this.preHash = preHash;
        this.timeStamp = timeStamp;
    }

    private String generateBlock() throws Exception {
        byte[] blockBytes = Block.generateByteArray(this);
        if (blockBytes != null) {
            ByteArrayOutputStream byteaarray = new ByteArrayOutputStream();
            byteaarray.write(blockBytes);
            byteaarray.write(preHash.getBytes());
            byteaarray.write(Long.toString(timeStamp).getBytes());
            return Hash.hashing(byteaarray.toByteArray(), Config.HASH_ALGORITHM);
        } else {
            throw new Exception("Unable to generate current block hash!");
        }
    }

    public static byte[] generateByteArray(Block block) {
        ByteArrayOutputStream bytearray = new ByteArrayOutputStream();
        ObjectOutputStream output;
        if (block != null) {
            try {
                output = new ObjectOutputStream(bytearray);
                output.writeObject(block);
                output.flush();
            } catch (IOException e) {
                return null;
            }
            return bytearray.toByteArray();
        } else {
            return null;
        }
    }

    public int getBlockIndex() {
        return this.blockIndex;
    }

    public void setBlockIndex(int blockIndex) {
        this.blockIndex = blockIndex;
    }

    public Object getBlockchainData() {
        return this.blockchainData;
    }

    public void setBlockchainData(Object blockchainData) {
        this.blockchainData = blockchainData;
    }

    public String getPreHash() {
        return this.preHash;
    }

    public void setPreHash(String preHash) {
        this.preHash = preHash;
    }

    public String getNowHash() {
        return this.nowHash;
    }

    public void setNowHash(String nowHash) {
        this.nowHash = nowHash;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "{" +
            " blockIndex='" + getBlockIndex() + "'" +
            ", orderData='" + getBlockchainData() + "'" +
            ", preHash='" + getPreHash() + "'" +
            ", nowHash='" + getNowHash() + "'" +
            ", timeStamp='" + getTimeStamp() + "'" +
            "}";
    }
}
