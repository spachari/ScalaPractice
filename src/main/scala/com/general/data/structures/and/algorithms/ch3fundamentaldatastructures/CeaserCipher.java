package com.general.data.structures.and.algorithms.ch3fundamentaldatastructures;

public class CeaserCipher {

    protected char[] encoder = new char[26];
    protected char[] decoder = new char[26];


    public CeaserCipher(int rotation) {
        for (int k=0; k < 26; k++) {
            encoder[k] = (char) ('A' + (k + rotation) % 26);
            decoder[k] = (char) ('A' + (k - rotation + 26) % 26);

        }
        Utilities.printArray(encoder);
        Utilities.printArray(decoder);
    }

    public String encrypt(String message) {
        return transform(message, encoder);
    }

    public String decrypt(String message) {
        return transform(message, decoder);
    }

    private String transform(String original, char[] code) {
        char[] msg = original.toCharArray();

        for(int j = 0; j < msg.length; j ++) {
            if (Character.isUpperCase(msg[j])) {
                int k = msg[j] - 'A';
                msg[j] = code[k];
            }
        }
        return new String(msg);
    }


    public static void main(String[] args) {
        String str = "bird";
        char[] strArray = str.toCharArray();
        Utilities.printArray(strArray);

        char t = 't';
        char a = 'a';

        System.out.println(t - a);
        System.out.println(t - 65);

        CeaserCipher c = new CeaserCipher(10);
        System.out.println("Encryption coder : " + c.encoder);
        System.out.println("Encryption coder : " + c.decoder);

        String message = "THE EAGLE IS IN PLAY. MEET AT JOE'S";
        String coded = c.encrypt(message);
        System.out.println("Coded message " + coded);
        String original = c.decrypt(coded);
        System.out.println("Original message " + original);

    }
}
