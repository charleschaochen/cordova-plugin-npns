package udata.npns;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.netease.npnssdk.interfaces.BaseReceiver;

import android.content.Context;
import android.content.Intent;
import org.apache.cordova.PluginResult;
//import org.json.JSONObject;


/**
 * Receiver to receive push messages or registration state.
 * @author maotianjiao (gzmaotianjiao@corp.netease.com)
 *
 */
public class MessageReceiver extends BaseReceiver {

    @Override
    protected void onPushNotificationReceived(Context context, int msgId, String payload) {
        // If you want show the notification in your own way, remove the super call.
    }
    
    @Override
    protected void onUserDefinedMessageReceived(Context context, int msgId, String payload) {
    }
    
    @Override
    protected void onRegistrationStateReceived(final Context context, int statusCode, String deviceToken) {
        super.onRegistrationStateReceived(context, statusCode, deviceToken);
        
        String message = "";
        if (statusCode == 0) {
            message = "register to NPNS server succeed! token=" + deviceToken;

            /** Set the alias name.
            NpnsSdkInterface.setAlias("npns_123", new AliasCallback() {

                @Override
                public void onResult(int statusCode, String alias) {
                    String message = "";
                    if (statusCode == AliasCallback.SUCCEED) {
                        message = "set alias succeed! alias = " + alias;
                    } else {
                        message = "set alias failed! code=" + statusCode;
                    }
                    updateAndSaveMessage(context, message);
                }
            });

            */
            try {
//				JSONObject obj = new JSONObject();
//				obj.put("token", deviceToken);
//				obj.put("msg", message);
				NeteasePush.pushContext.success(deviceToken);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
        } else {
            message = "register to NPNS server failed!";
            NeteasePush.pushContext.error(message);
        }
        
//        updateAndSaveMessage(context, message);
    }

    @Override
    protected void onConnectionStateReceived(Context context, boolean connected) {
    }
    
    private void updateAndSaveMessage(Context context, String message) {
//        SimpleDateFormat sdf = new SimpleDateFormat("[ MM-dd HH:mm:ss ]", Locale.CHINA);
//        String currentDateandTime = sdf.format(new Date());
//        message = currentDateandTime + "\n" + message + "\n\n";
//
//        Intent intent = new Intent(MainActivity.INTENT_MESSAGE_RECEIVED);
//        intent.putExtra(MainActivity.EXTRA_MESSAGE, message);
//        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
//
//        File file = new File(context.getFilesDir(), MainActivity.MESSAGE_FILE);
//        String oldMessage = MainActivity.readFromFile(file);
//        if (oldMessage != null) {
//            message = message + oldMessage;
//        }
//        MainActivity.writeToFile(file, message);
    }
}
