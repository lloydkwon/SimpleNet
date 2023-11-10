package com.github.simplenet;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class MekClients {


    private static byte[] readData(String path) throws IOException {
        String s = FileUtils.readFileToString(new File(path), "UTF-8");
        byte[] bytes = Base64.decodeBase64(s);
        return bytes;
    }
}
