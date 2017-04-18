/*
 * Copyright (C) 2016 Facishare Technology Co., Ltd. All Rights Reserved.
 */
package com.ue.permissionutil.util;

import android.content.Context;
import android.content.Intent;

public class MeizuUtils {

    public static void forwardPermSettingPage(Context context, int permOp) {
        if (permOp == PermissionInfoUtil.OP_SYSTEM_ALERT_WINDOW) {
            forwardPopupWinPermSettingPage(context);
        } else {
            forwardPermSettingsPage(context);
        }
    }


    private static void forwardPopupWinPermSettingPage(Context context) {
        forwardPermSettingsPage(context);
    }


    private static void forwardPermSettingsPage(Context context) {
        Intent intent;

        intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        intent.putExtra("packageName", context.getPackageName());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if(CommonUtils.isIntentAvailable(intent,context)){
            context.startActivity(intent);
            return;
        }

        CommonUtils.forwardAppDetailPage(context);
    }
}