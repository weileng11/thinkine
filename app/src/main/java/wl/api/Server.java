package wl.api;

import retrofit2.http.*;
import rx.Observable;
import wl.model.M;

/**Created by wuzhengu on 2018/10/30 0019 */
public class Server
{
	public static final String TEST_TOKEN="";
	public static final String DEVICE_TYPE="android";
	public static final String BASE_WEB="https://m.totobye.cn/";
	public static final String BASE_URL="https://api.iudeng.cn/";
	
	private static Api api=null;
	
	public static synchronized Api get(){
		if(api==null) api=Servers.getRetrofit(BASE_URL).create(Api.class);
		return api;
	}
	
	public interface Api
	{
		/**
		 登陆
		 */
		@FormUrlEncoded
		@POST("api/User/do_login")
		Observable<M> doLogin(@Field("username") String username,
				@Field("password") String password);
		/**
		 用户信息
		 */
		@GET("api/User/get_user_info")
		Observable<M> getUserInfo();
		
	}
}
