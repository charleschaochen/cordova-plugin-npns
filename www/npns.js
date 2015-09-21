/**
 * Created by charles on 15/9/21.
 */
var EventEmitter = require('eventemitter3');
var exec = cordova.require('cordova/exec');

/**
 * 信鸽 Cordova 服务类，用于注册。
 *
 * @class
 * @extends external:EventEmitter
 * @param {function} exec - cordova 插件接口
 * @tutorial README.md
 */
function NeteasePush() {
    EventEmitter.call(this);
    this.exec = exec;
}

NeteasePush.prototype = new EventEmitter();

NeteasePush.SERVICE = 'NeteasePush';
NeteasePush.ACTION_REGISTER_PUSH = 'registerpush';
NeteasePush.ACTION_UNREGISTER_PUSH = 'unregisterpush';
NeteasePush.ACTION_ADD_LISTENER = 'addlistener';

NeteasePush.prototype.eventSuccess = function(results) {
    console.log('receive message:', results);
    this.emit('textmessage', results);
};

NeteasePush.prototype.eventError = function(err) {
    console.log('receive error:', err);
    this.emit('error', err);
};

NeteasePush.prototype.registerReceiver = function(success, error) {
    var exec = this.exec;
    exec(
        success, error,
        NeteasePush.SERVICE, NeteasePush.ACTION_ADD_LISTENER,
        []
    );
};

/**
 * 注册推送。
 *
 * @example
 * // 直接注册
 * NeteasePush.registerPush().then(function() {
 *   console.log('success');
 *
 * }).catch(function(errCode) {
 *   console.log('oh no: ' + errCode);
 * });
 */
NeteasePush.prototype.registerPush = function() {
    var exec = this.exec;
    return new Promise(function(resolve, reject) {
        exec(
            resolve, reject,
            NeteasePush.SERVICE, NeteasePush.ACTION_REGISTER_PUSH,
            []
        );
    });
};

module.exports = new NeteasePush();
