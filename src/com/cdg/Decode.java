package com.cdg;

import java.util.Scanner;

public class Decode {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("请输入密文：");
        String var0 = "FEPCCCLCENHIPOAFPAPDDFCGEAPNMDBMOJPMJAKKNPHOKIKIDCBPHEGKLDGNHCBDEIMODEKMKPFBAIMMNLOJJKMIICLAPJAAFGNGAKFBMPKPJMOIKODEJJMHJCCHKBMFMMFDLOMDPABOJCEAPOFDCPMKGDHFNBBIMCIPAMMIIANFPAJHFAABLLLANNIDAGNKOHONJGFGBKHFDMCLJIMICBHBJEIAAIMACN";

        String str11 = scan.nextLine();
        try {
            String str1 = ServiceUtil.decodeString(str11);
            System.out.println(str1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
