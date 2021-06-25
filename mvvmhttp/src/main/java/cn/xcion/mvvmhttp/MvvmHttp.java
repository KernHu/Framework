package cn.xcion.mvvmhttp;

/**
 * @author: Kern Hu
 * @emali: huming@szprize.com
 * create at: 2019/6/4 20:42.
 * modify at: 2019/6/4 20:42.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public class MvvmHttp {

    public long readTimeout = 10;
    public long connectTimeout = 10;
    public long writeTimeout = 10;
    public boolean retryOnConnectionFailure = true;
    public String logTag = "api-sos";
    public boolean logPrintable = true;
    public boolean retrofitLockable = true;
    public String baseUrl = "";

    public volatile static MvvmHttp mvvmHttp;

    public static MvvmHttp getInstance() {
        synchronized (MvvmHttp.class) {
            if (mvvmHttp == null) {
                mvvmHttp = new MvvmHttp();
            }
        }
        return mvvmHttp;
    }


    public MvvmHttp setReadTimeout(long readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }


    public MvvmHttp setConnectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }


    public MvvmHttp setWriteTimeout(long writeTimeout) {
        this.writeTimeout = writeTimeout;
        return this;
    }


    public MvvmHttp setRetryOnConnectionFailure(boolean retryOnConnectionFailure) {
        this.retryOnConnectionFailure = retryOnConnectionFailure;
        return this;
    }


    public MvvmHttp setLogTag(String logTag) {
        this.logTag = logTag;
        return this;
    }


    public MvvmHttp setLogPrintable(boolean logPrintable) {
        this.logPrintable = logPrintable;
        return this;
    }


    public MvvmHttp setRetrofitLockable(boolean retrofitLockable) {
        this.retrofitLockable = retrofitLockable;
        return this;
    }


    public MvvmHttp setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public void bind() {


    }
}
