package com.example.myapplication;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtils {
    private OKHttpRequest mHttpRequest;
    private int mType;
    private final int TYPE_POST =0X0011,TYPE_GET=0X0022;
    private Map<String,Object>mParams;
    private String mUrl;
    private Context mContext;
    public static  HttpUtils with(Context context){
        return new HttpUtils(context);
    }
    public HttpUtils get(){
        mType =TYPE_GET;
        return this;
    }
    private HttpUtils(Context context){
        mHttpRequest = new OKHttpRequest();
        mParams = new HashMap<>();
        this.mContext =context;
    }
    public HttpUtils params(String key,Object value){
        mParams.put(key,value);
        return this;
    }
    public HttpUtils url(String url){
        this.mUrl =url;
        return this;
    }
    public HttpUtils cache(boolean cache){
        return this;
    }
    public <T>void request(final HttpCallBack<T> callBack){
        mHttpRequest.get(mContext,mUrl,mParams,callBack,true);
    }
//    public <T> void get(Context context, String url, Map<String,Object>params, final HttpCallBack<T> callBack,final boolean cache){
//        mHttpRequest.get(context,url,params,callBack,cache);
//    }
//    public <T> void get(Context context, String url, Map<String,Object>params, final HttpCallBack<T> callBack,final boolean cache,final boolean cookie,int recount ){
//        mHttpRequest.get(context,url,params,callBack,cache);
//    }
}
