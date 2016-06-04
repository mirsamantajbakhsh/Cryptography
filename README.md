# Cryptography
Some simple cryptography algorithms used in Java.

## AES
In AES.java a simple "Hello World!" message is encrypted using with password "1234567890123456" and initial vector of "teststringfor in". The result is then based64'ed and decrypted with the same parameters.

## DES
In DES.java a file named "CAPTURED.png" is encrypted using password "testpass" and stored in other file named "CAPTURED.png.enc". You may use the DES.java or some cryptography learning tools such as "Cryptool" https://www.cryptool.org/en/cryptool2 for decrption.

## Secure Server
In this example I have created a secure server socket (SSL/TLS) binded on port 4443 of localhost. It uses a JKS (Java Key Store) file for encryption/decryption named test.jks (with password of 123 both for JKS and its alias). The key is not put here but you can create one with Java Key Tool (or any other):

```
keytool -genkey -alias mydomain -keyalg RSA -keystore keystore.jks -keysize 2048
```

Take a look at [this link](https://www.sslshopper.com/article-most-common-java-keytool-keystore-commands.html) for more commands.

## Secure Client
This file will connect to the secure server, will recieve a "hello and goodbye!" message from server and finally will be discunnected. Sience the test.jks is a self signed certificate, I have put the code for accepting self signed certificates in the client

```java
TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }
            }
        };
```
