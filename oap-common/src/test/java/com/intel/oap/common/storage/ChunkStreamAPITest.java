package com.intel.oap.common.storage;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

public class ChunkStreamAPITest {

    @Test
    public void testFileStreamReadWrite() throws IOException {
        String fileName = "target/test.file";
        Properties properties = new Properties();
        properties.put("type", "SPDK");
        byte[] data = new byte[]{'a', 'b', 'c'};
        ChunkOutputStream chunkoutputStream = new ChunkOutputStream(fileName, null);
        chunkoutputStream.write(data);
        chunkoutputStream.close();

        ChunkInputStream chunkInputStream = new ChunkInputStream(fileName);
        byte[] readData = new byte[3];
        chunkInputStream.read(readData);
        Assert.assertArrayEquals(data, readData);
    }
}