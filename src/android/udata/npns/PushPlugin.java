package udata.npns;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public abstract class PushPlugin extends CordovaPlugin {

    private static final String TAG = "NeteasePushPlugin";
    private static final String ACTION_REGISTER_PUSH = "registerpush";
    private static final String ACTION_UNREGISTER_PUSH = "unregisterpush";
    private static final String ACTION_ADD_LISTENER = "addlistener";

    abstract protected boolean registerPush(Context context, CallbackContext callback);
    abstract protected boolean unregisterPush(Context context, CallbackContext callback);
    abstract protected boolean addListener(Context context, CallbackContext callback);

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.d(TAG, "> plugin invoke");
        Context context = cordova.getActivity().getApplicationContext();

        if (ACTION_REGISTER_PUSH.equals(action)) {
            return registerPush(context, callbackContext);

        } else if (ACTION_UNREGISTER_PUSH.equals(action)) {
            return unregisterPush(context, callbackContext);

        } else if (ACTION_ADD_LISTENER.equals(action)) {
            return addListener(context, callbackContext);

        }

        return false;
    }

    /**
     * fix for singletop
     */
    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.cordova.getActivity().setIntent(intent);
    }

}
