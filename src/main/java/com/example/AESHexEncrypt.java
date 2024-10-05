package com.example;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.HexFormat;

public class AESHexEncrypt {
    public static void main(String[] args) {
        try {
            // Chiave e dati in esadecimale
            String hexKey = "00000000000000000000000000123456";
            String hexData = "00000000000000000000000000000000";

            // Conversione della chiave e dei dati in un array di byte
            byte[] keyBytes = HexFormat.of().parseHex(hexKey);
            byte[] dataBytes = HexFormat.of().parseHex(hexData);

            // Configurazione della cifratura AES
            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);

            // Cifratura dei dati
            byte[] cipherText = cipher.doFinal(dataBytes);

            // Conversione del testo cifrato in esadecimale
            String hexCipherText = HexFormat.of().formatHex(cipherText);

            // Stampa del risultato
            System.out.println("Ciphertext in Hex: " + hexCipherText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
