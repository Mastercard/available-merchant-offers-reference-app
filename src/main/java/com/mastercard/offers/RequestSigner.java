package com.mastercard.offers;

import com.mastercard.developer.interceptors.OkHttp2OAuth1Interceptor;
import com.mastercard.developer.utils.AuthenticationUtils;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.openapitools.client.ApiClient;

import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.List;

public class RequestSigner {
    /**
     * Intercepts and signs the request. Using Stage GW for testing as SBX is not viable for this Service
     * @// TODO: 13/04/2020 Load properties from a file
     * @param client
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws KeyStoreException
     * @throws CertificateException
     * @throws NoSuchAlgorithmException
     * @throws UnrecoverableKeyException
     */
    public static void signRequest(ApiClient client) throws IOException, NoSuchProviderException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
        String consumerKey = "6QO2YfK6OKPzYZOxNA-jzX6giLUjmhTp_2CCU5_Q39a9ebc0!f1b0a15d1e9748d0906b3d2f90403b500000000000000000";
        String signingKeyFilePath = "/Users/ishfaqlone/officeprojs/AvailMerchantOffersReferenceImpl/src/main/resources/test-merchant-avail-offers-sandbox.p12";
        String signingKeyAlias = "keyalias";
        String signingKeyPassword = "keystorepassword";
        PrivateKey signingKey = AuthenticationUtils.loadSigningKey(signingKeyFilePath, signingKeyAlias, signingKeyPassword);

        client.setBasePath("https://stage.api.mastercard.com/de/merchantoffers");
        client.setDebugging(true);
        client.setReadTimeout(40000);
        List<Interceptor> interceptors = client.getHttpClient().networkInterceptors();
        interceptors.add(new ForceJsonResponseInterceptor());
        interceptors.add(new OkHttp2OAuth1Interceptor(consumerKey, signingKey));
    }

    /**Add "Format=JSON" to the request for the service/gateway to return a JSON response.*/
    private static class ForceJsonResponseInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            String withJsonFormatUrl = withJsonFormat(originalRequest.uri().toString());
            Request newRequest = originalRequest.newBuilder().url(withJsonFormatUrl).build();
            return chain.proceed(newRequest);
        }

        private String withJsonFormat(String uri) {
            StringBuilder newUri = new StringBuilder(uri);
            newUri.append(uri.contains("?") ? "&" : "?");
            newUri.append("Format=JSON");
            return newUri.toString();
        }
    }
}
