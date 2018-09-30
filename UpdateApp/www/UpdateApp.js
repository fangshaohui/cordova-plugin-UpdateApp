var exec = require('cordova/exec');

/**
     * 一共5个参数
     arg0 :参数
     success :成功回调
     error :失败回调
     */
exports.coolMethod = function(arg0, success, error) {
    exec(success, error, "UpdateAppPlugin", "coolMethod", [arg0]);
};
