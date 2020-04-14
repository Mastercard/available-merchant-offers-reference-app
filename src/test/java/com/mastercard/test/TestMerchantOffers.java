package com.mastercard.test;

import com.mastercard.developer.interceptors.OkHttp2OAuth1Interceptor;
import com.mastercard.developer.utils.AuthenticationUtils;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.openapitools.client.ApiClient;
import org.openapitools.client.api.OffersApi;
import org.openapitools.client.api.OffersApiTest;
import org.openapitools.client.api.ReferenceDataApi;
import org.openapitools.client.model.Merchant;
import org.openapitools.client.model.OfferCategory;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;


public class TestMerchantOffers {

        public static void main(String[] args) throws Exception {

            ApiClient client = new ApiClient();

            signRequest(client);
            System.out.println("Signing Client: " +client);

   /*         ReferenceDataApi api = new ReferenceDataApi(client);
              System.out.println(api.getProductTypes("java","application/json"));

            System.out.println(api.getOfferCategories(null,null));
*/
            OffersApi offers = new OffersApi(client);
            offers.getMerchantOffers(new BigDecimal(90),new BigDecimal(-90),"MCG",null,null,null,
                    null, null,null,null,null,null,null);

        }

        private static void signRequest(ApiClient client) throws IOException, NoSuchProviderException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
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

