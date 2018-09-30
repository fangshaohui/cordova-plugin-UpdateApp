package org.apache.cordova.updateApp;

import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by xa.Fang.
 */
public class UpdateAppPlugin extends CordovaPlugin{
    private CallbackContext cb = null;
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if("coolMethod".equals(action)){
            this.cb = callbackContext;
            downLoad(args.getString(0));
        }
        callbackContext.success();
        return true;
    }
    private void downLoad(String url){
        if(!url.equals("")){
		    Intent intent = new Intent(cordova.getActivity(), DownloadApkService.class);
            intent.putExtra("apkUrl", url);
			intent.putExtra("applicationId", preferences.getString("PACKAGE_NAME", ""));
            cordova.getActivity().startService(intent);
			PluginResult result = new PluginResult(PluginResult.Status.OK, "开始下载");
			result.setKeepCallback(false);
			this.cb.sendPluginResult(result);
		}else{
			PluginResult result = new PluginResult(PluginResult.Status.ERROR, "下载地址错误");
			result.setKeepCallback(false);
			this.cb.sendPluginResult(result);
		}
    }
}
