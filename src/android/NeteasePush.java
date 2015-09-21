package udata.npns;


import android.app.Activity;
import android.content.Context;
import com.netease.npnssdk.core.NpnsPushService;
import com.netease.npnssdk.interfaces.NpnsSdkInterface;


public class NeteasePush extends PushPlugin {
    private static final String APP_ID = "55ffaf15eb20962673e2b391";
    private static final String TICKET = "1:1442819861:655d35d25dcf19d4:3020d5414167f6899767b8fbb66f5c72df892f35";
    @Override
    protected void onInitialize(Context context) {
        NpnsSdkInterface.setDebugMode(true);
        NpnsSdkInterface.registerPush(context, APP_ID, TICKET);
    }

    @Override
    protected void onEnableDebug(Context context, boolean enable) {
        NpnsSdkInterface.setDebugMode(true);
    }

    @Override
    protected void onRegisterPush(Context context) {
        NpnsSdkInterface.registerPush(context, APP_ID, TICKET);
    }

    @Override
    protected void onRegisterAccount(Context context, String account) {
    }

    @Override
    protected void onUnregisterPush(Context context) {
    }

    @Override
    protected void onSetTag(Context context, String tag) {
    }

    @Override
    protected void onDeleteTag(Context context, String tag) {
    }

    @Override
    protected void onClearCache(Context context) {
    }

    @Override
    protected void onActivityPause(Activity activity) {
    }

    @Override
    protected void onActivityResume(Activity activity) {
    }

    @Override
    protected void onSetIdAndKey(Context context, long id, String key) {
    }

}
