/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.practica01;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author EMend17
 */
public class DES {

    public DES() {
    }

    
        String KEY = "password";
        
        public SecretKey createKey(String chave) {
            try {
                byte[] charac = chave.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("SHA-1");
                charac = md.digest(charac);
                charac = Arrays.copyOf(charac, 16);
                SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
                SecretKey key = factory.generateSecret(new   DESKeySpec(charac));
                return key;
            } catch (Exception e) {
                return null;
            }
        }
    
        
        public String crypt(String encrypt) {
    
            try {
                SecretKey secretKeySpec = createKey(KEY);
                Cipher cipher = Cipher.getInstance("DES");
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
    
                byte[] charac = encrypt.getBytes("UTF-8");
                byte[] encrypted = cipher.doFinal(charac);
                String encrypted_charac = java.util.Base64.getEncoder().encodeToString(encrypted);
                return encrypted_charac;
    
            } catch (Exception e) {
                return e.toString();
            }
        }
    
        public String decrypt(String decrypt) {
    
            try {
                SecretKey secretKeySpec = createKey(KEY);
                Cipher cipher = Cipher.getInstance("DES");
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
    
                byte[] charac = Base64.getDecoder().decode(decrypt);
                byte[] decryption = cipher.doFinal(charac);
                String decrypted_charac = new String(decryption);
                return decrypted_charac;
    
            } catch (Exception e) {
                return e.toString();
            }
        }
    
        
        
        
    }