package udata.npns;

import com.netease.npnssdk.interfaces.NpnsSdkInterface;
import org.apache.cordova.CallbackContext;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

public class NeteasePush extends PushPlugin {
    private static final String APP_ID = "55ffaf15eb20962673e2b391";
    private static final String TICKET = "1:1442819861:655d35d25dcf19d4:3020d5414167f6899767b8fbb66f5c72df892f35";

    private static final String TAG = "NeteasePushPlugin";

   public static CallbackContext pushContext;

    @Override
    protected boolean registerPush(Context context, CallbackContext callback) {
        pushContext = callback;
        Log.d(TAG, "> register");
        NpnsSdkInterface.registerPush(context, APP_ID, TICKET, MessageReceiver.class);
        return true;
    }

    @Override
    protected boolean unregisterPush(Context context, CallbackContext callback) {
        return true;
    }

    @Override
    protected boolean addListener(Context context, CallbackContext callback) {
		return true;
    }

}
