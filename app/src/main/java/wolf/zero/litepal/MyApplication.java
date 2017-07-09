package wolf.zero.litepal;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

/**
 * @author sineom
 * @version 1.0
 * @time 2017/7/5 21:57
 * @des ${TODO}
 * @updateAuthor ${Author}
 * @updataTIme 2017/7/5
 * @updataDes ${描述更新内容}
 */

public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        LitePal.initialize(mContext);

    }
    public static Context getContext(){
        return mContext;
    }
}
