/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EncDec;

import com.sun.net.ssl.internal.ssl.Provider;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 *
 * @author Mir Saman Tajbakhsh
 */
public class SecureClient {

    public static void main(String[] args) throws Exception {
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

        SSLContext ssc = null;
        SSLSocketFactory ssf = null;
        try {
            ssc = SSLContext.getInstance("TLS");
            ssc.init(null, trustAllCerts, new java.security.SecureRandom());
            ssf = ssc.getSocketFactory();
            SSLSocket s = (SSLSocket) ssf.createSocket("127.0.0.1", 4443);
            s.startHandshake();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println(br.readLine());
            
        } catch (NoSuchAlgorithmException ex) {

        }

    }

}
