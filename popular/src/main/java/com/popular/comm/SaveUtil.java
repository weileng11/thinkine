package com.popular.comm;

import com.tencent.mmkv.MMKV;

/**
 * @author: ${bruce}
 * @project: thinkine
 * @package: com.popular.comm
 * @description:
 * @date: 2019/1/8  
 * @time: 17:32
 */
public class SaveUtil
{
	private static final String KEY_ENCRYPT_KEY = "KEY_PWD";
	private static final String KEY_SESSIONID = "KEY_OK";
	
	//获取mmkv对象
	private static MMKV kv = MMKV.defaultMMKV();
	
	public static void clearAll() {
		//清除
		kv.removeValuesForKeys(new String[]{
				KEY_ENCRYPT_KEY,
				KEY_SESSIONID,
		});
		
	}
	
	public static void saveKey(String key, String sessionId) {
		// 存储数据
		kv.encode(KEY_ENCRYPT_KEY, key);
		kv.encode(KEY_SESSIONID, sessionId);
	}
	
	public static String loadKey() {
		return kv.decodeString(KEY_ENCRYPT_KEY);
	}
	
	public static String loadKey2() {
		return kv.decodeString(KEY_SESSIONID);
	}
}
