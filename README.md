# cordova-plugin-UpdateApp
#### APP自动更新cordova插件
#### js调用方式
+  url : http下载地址
+	 success : 开始下载回调函数
+	 error : 下载失败回掉
+	 说明：下载成功后会直接调用安装方法所以这里没有下载成功的回掉函数 如果下载失败请检查权限
``` 
 document.addEventListener("deviceready", onDeviceReady, false);
 function onDeviceReady() {
      cordova.plugins.UpdateApp.coolMethod(url,usccess,error)
 }
```
