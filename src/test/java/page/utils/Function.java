package page.utils;

import org.jasypt.util.text.BasicTextEncryptor;

public class Function {
    public static String encrypt(String text) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("Pa$$w0rd");
        return textEncryptor.encrypt(text);
    }

    public static String decryptPass(String text) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("Pa$$w0rd");
        return textEncryptor.decrypt(text);
    }
}
