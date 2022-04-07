package com.laptopshop.ulti;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RSAUtil {

  @Value("${rsa.privatekey.filepath}")
  private String privateKeyFileName;
  
  @Value("${rsa.publickey.filepath}")
  private String publicKeyFileName;

  public String getPrivateKeyFileName() {
    return privateKeyFileName;
  }

  public void setPrivateKeyFileName(String privateKeyFileName) {
    this.privateKeyFileName = privateKeyFileName;
  }

  public String getPublicKeyFileName() {
    return publicKeyFileName;
  }

  public void setPublicKeyFileName(String publicKeyFileName) {
    this.publicKeyFileName = publicKeyFileName;
  }

  public RSAUtil() {
  }

  public RSAUtil(String privateKeyFileName, String publicKeyFileName) {
    this.privateKeyFileName = privateKeyFileName;
    this.publicKeyFileName = publicKeyFileName;
  }

  public RSAPublicKey readPublicKey() throws Exception {

    File publicFile = new File(this.publicKeyFileName);
    String key = new String(Files.readAllBytes(publicFile.toPath()), Charset.defaultCharset());

    String publicKeyPEM = key
        .replace("-----BEGIN PUBLIC KEY-----", "")
        .replaceAll(System.lineSeparator(), "")
        .replace("-----END PUBLIC KEY-----", "");

    byte[] encoded = Base64.decodeBase64(publicKeyPEM);

    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
    return (RSAPublicKey) keyFactory.generatePublic(keySpec);
  }

  public RSAPrivateKey readPrivateKey() throws Exception {
    File privateFile = new File(this.privateKeyFileName);
    String key = new String(Files.readAllBytes(privateFile.toPath()), Charset.defaultCharset());

    String privateKeyPEM = key
        .replace("-----BEGIN PRIVATE KEY-----", "")
        .replaceAll(System.lineSeparator(), "")
        .replace("-----END PRIVATE KEY-----", "");

    byte[] encoded = Base64.decodeBase64(privateKeyPEM);

    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
    return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
  }

  
}
