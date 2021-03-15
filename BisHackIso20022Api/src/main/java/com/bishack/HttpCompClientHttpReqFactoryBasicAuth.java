
package com.bishack;

import java.net.URI;

import org.apache.http.HttpHost;
import org.apache.http.client.AuthCache;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

/**
 * @author Murali Chakaravarthy
 * @version 1.0
 * @see HttpComponentsClientHttpRequestFactory
 * @since Feb 13, 2018
 *
 */
public class HttpCompClientHttpReqFactoryBasicAuth extends HttpComponentsClientHttpRequestFactory {

	HttpHost host;

	/**
	 * @param host {@code HttpHost}
	 */
	public HttpCompClientHttpReqFactoryBasicAuth(HttpHost host) {
		super();
		this.host = host;
	}

	/* (non-Javadoc)
	 * @see org.springframework.http.client.HttpComponentsClientHttpRequestFactory#createHttpContext(org.springframework.http.HttpMethod, java.net.URI)
	 */
	protected HttpContext createHttpContext(HttpMethod httpMethod, URI uri) {
		return createHttpContext();
	}

	/**
	 * @return {@code HttpContext}
	 */
	private HttpContext createHttpContext() {
		//TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
		/*TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
	        @Override public boolean isTrusted(X509Certificate[] x509Certificates, String s)
	                        throws CertificateException {
	            return true;
	        }
	    };

		SSLContext sslContext = SSLContexts.custom()
		        .loadTrustMaterial(null, acceptingTrustStrategy)
		        .build();
		sslContext
		SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

		CloseableHttpClient httpClient = HttpClients.custom()
		        .setSSLSocketFactory(csf)
		        .build();*/
		
		
		AuthCache authCache = new BasicAuthCache();
		BasicScheme basicAuth = new BasicScheme();
		authCache.put(host, basicAuth);
		BasicHttpContext localcontext = new BasicHttpContext();
		localcontext.setAttribute(HttpClientContext.AUTH_CACHE, authCache);
		return localcontext;
	}
}
