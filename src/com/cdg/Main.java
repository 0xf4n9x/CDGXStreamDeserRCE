package com.cdg;

public class Main {
    public static void main(String[] args){
        try{
            if(args[0].equals("decode"))
            {
                Decode.decoder(args[1]);
            }
            else if(args[0].equals("encode")){
                Encode.encoder(args[1]);
            }
            else {
                System.out.println("Usage:\n\tjava -jar CDGDEcodeXML.jar decode xxxxxxxx\n\tjava -jar CDGDEcodeXML.jar encode test.xml");
            }
        } catch (Exception e) {
            System.out.println("Usage:\n\tjava -jar CDGDEcodeXML.jar decode xxxxxxxx\n\tjava -jar CDGDEcodeXML.jar encode test.xml");
        }

    }
}
