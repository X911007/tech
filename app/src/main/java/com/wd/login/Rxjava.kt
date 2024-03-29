package com.wd.login

import android.content.Context

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.security.*
import java.security.cert.CertificateException
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

//private constructor() 私有构造
class Rxjava private constructor() {
    private var retrofit: Retrofit? = null

    companion object {
        val instance : Rxjava by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED){
            Rxjava()
        }

    }

    init {
//        val x509TrustManager: X509TrustManager = getTrustManager("server.crt")
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
//                .addNetworkInterceptor(httpLoggingInterceptor)
                .retryOnConnectionFailure(true)
//                .sslSocketFactory(getSSLSocketFactory(x509TrustManager), x509TrustManager)
                .build()
         retrofit = Retrofit.Builder()
//                .baseUrl("https://mobile.bwstudent.com/")
                .baseUrl(Api.BASE_URL_)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

    }

    fun <T> create(tClass: Class<T>): T {
        return retrofit!!.create(tClass)
    }

    fun getTrustManager(certificateName: String): X509TrustManager {
        var tCertFactory = CertificateFactory.getInstance("X.509")
        val tJDBCert = readJDBCertFromAsset(App.getContent(), certificateName, tCertFactory)
        val tTrustMgr = newTrustManager(tJDBCert)

        return tTrustMgr
    }

    fun getSSLSocketFactory(trustManager: X509TrustManager): SSLSocketFactory? {
        try {
            val tSSLContext = newSSLContext(trustManager)
            val sslSocketFactory = tSSLContext!!.socketFactory
            return sslSocketFactory
        } catch (e: CertificateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: KeyManagementException) {
            e.printStackTrace()
        }

        return null
    }

    /**
     * xxx.cer证书 -> X509Certificate
     */
    @Throws(IOException::class, CertificateException::class)
    private fun readJDBCertFromAsset(context: Context, certificateName: String, pCertFactory: CertificateFactory): X509Certificate? {
        val caInput = context.assets.open(certificateName) ?: return null

        try {
            val tCert = pCertFactory.generateCertificate(caInput) as X509Certificate
            tCert.checkValidity()
            return tCert
        } finally {
            caInput.close()
        }
    }

    /**
     * X509TrustManager实例化 Android 自带的一套https认证机制
     */
    fun newTrustManager(privateCert: X509Certificate?): X509TrustManager {
        return object : X509TrustManager {
            @Throws(CertificateException::class)
            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
            }

            @Throws(CertificateException::class)
            override fun checkServerTrusted(chain: Array<X509Certificate>?, authType: String?) {
                if (null == chain || 0 == chain.size) {
                    throw CertificateException("Certificate chain is invalid.")
                }

                if (null == authType || 0 == authType.length) {
                    throw CertificateException("Authentication type is invalid.")
                }

                for (cert in chain) {
                    cert.checkValidity()
                    try {
                        cert.verify(privateCert!!.publicKey)
                    } catch (e: NoSuchAlgorithmException) {
                        e.printStackTrace()
                    } catch (e: InvalidKeyException) {
                        e.printStackTrace()
                    } catch (e: NoSuchProviderException) {
                        e.printStackTrace()
                    } catch (e: SignatureException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return arrayOf()
            }
        }
    }

    @Throws(NoSuchAlgorithmException::class, KeyManagementException::class)
    private fun newSSLContext(pTrustManager: X509TrustManager): SSLContext {
        val tSSLContext = SSLContext.getInstance("TLS")
        tSSLContext.init(null, arrayOf<TrustManager>(pTrustManager), null)
        return tSSLContext
    }

}

