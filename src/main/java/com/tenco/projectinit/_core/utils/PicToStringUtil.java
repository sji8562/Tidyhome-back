package com.tenco.projectinit._core.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

public class PicToStringUtil {

    public static String picToString(String picUrl){
        byte[] productImages = Base64.getDecoder().decode(picUrl);
        UUID uuid = UUID.randomUUID();
        String filename =  "partner" + "_" + uuid + ".png";
        Path filePath = Paths.get(Define.UPLOAD_DIRECTORY, filename);
        try {
            Files.write(filePath, productImages);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filePath.toString();
    }

}
