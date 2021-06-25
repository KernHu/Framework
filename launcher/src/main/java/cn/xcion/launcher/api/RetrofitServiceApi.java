package cn.xcion.launcher.api;

import cn.xcion.launcher.entry.MchInfo;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Author: Kern
 * E-mail: sky580@126.com
 * DateTime: 2021/6/26  01:36
 * Intro:
 */
public interface RetrofitServiceApi {

    //获取商家信息
    @POST("users/{userName}")
    Observable<Response<MchInfo>> getMchInfo(@Path("userName") String userName);


    //获取用户信息
    @GET("users/{userName}")
    Observable<Response<Object>> getUserInfo(@Path("userName") String userName);
}
