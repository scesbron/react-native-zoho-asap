package fr.wecasa;

import android.app.Activity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.zoho.deskportalsdk.DeskConfig;
import com.zoho.deskportalsdk.ZohoDeskPortalSDK;

public class ZohoAsapModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private ZohoDeskPortalSDK deskInstance;

    public ZohoAsapModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "ZohoAsap";
    }

    @ReactMethod
    public void init(String orgId, String appId, String dataCenterValue) {
        ZohoDeskPortalSDK.Logger.enableLogs();
        DeskConfig config = new DeskConfig.Builder().build();
        deskInstance = ZohoDeskPortalSDK.getInstance(this);
        deskInstance.initDesk(orgId, appId, dataCenterValue, config);
    }

    @ReactMethod
    public void startDeskHomeScreen() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            deskInstance.startDeskHomeScreen(currentActivity.this);
        }
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }
}
