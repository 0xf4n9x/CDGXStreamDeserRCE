package com.cdg;

import java.util.Scanner;

public class Decode {
    public static void decoder(String targetstr) {
//        System.out.println("请输入密文：");
//        String var0 = "FEPCCCLCENHIPOAFPAPDDFCGEAPNMDBMOJPMJAKKNPHOKIKIDCBPHEGKLDGNHCBDEIMODEKMKPFBAIMMNLOJJKMIICLAPJAAFGNGAKFBMPKPJMOIKODEJJMHJCCHKBMFMMFDLOMDPABOJCEAPOFDCPMKGDHFNBBIMCIPAMMIIANFPAJHFAABLLLANNIDAGNKOHONJGFGBKHFDMCLJIMICBHBJEIAAIMACN";
        try {
            String result = ServiceUtil.decodeString(targetstr);
            System.out.println("[+]Success:");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
