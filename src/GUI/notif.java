/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.notifications.LocalNotification;
import com.codename1.notifications.LocalNotificationCallback;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;

/**
 *
 * @author khaled Chebbi
 */
public class notif implements LocalNotificationCallback {
    
    
    public void noti(){
        LocalNotification n = new LocalNotification();
        n.setAlertBody("body");
        n.setAlertTitle("title");
        n.setId("id");
        Display.getInstance().scheduleLocalNotification(n, System.currentTimeMillis() + 10, LocalNotification.REPEAT_MINUTE);
        System.out.println("done");
    }
    
    /*
    hhhhhhh
    */

    @Override
    public void localNotificationReceived(String notificationId) {
         System.out.println("Received local notification "+notificationId+" in callback localNotificationReceived");
         Dialog.show("noti", "checking notifications", "ok", null);
    }

}
    