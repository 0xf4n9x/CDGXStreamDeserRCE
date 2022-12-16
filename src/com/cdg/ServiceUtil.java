package com.cdg;

//import com.esafenet.util.CodeDecoder;

import java.lang.reflect.Array;

public class ServiceUtil {
    private static final byte[] abyte0 = new byte[]{-21, -112, 90, -68, 5, 44, 85, -86, -21, -112, 90, -68, 5, 44, 85, -86};

    public static String changeXMLInfo(String var0) throws Exception {
        CodeDecoder var1 = new CodeDecoder();
        byte[] var2 = var0.getBytes();
        int var3 = Array.getLength(var2);
        CodeDecoder.Encode(var2, var3, abyte0);
        String var4 = new String(var2, "ISO8859_1");
        return CodeDecoder.getTransferEncrptString(var4);
    }
    public static String decodeString(String var0) throws Exception {
        CodeDecoder var1 = new CodeDecoder();
        var0 = CodeDecoder.getTransferUnEncrptString(var0);
        byte[] var2 = var0.getBytes("ISO8859_1");
        int var3 = Array.getLength(var2);
        CodeDecoder.Decode(var2, var3, abyte0);
        var0 = new String(var2);
        return var0;
    }
}
