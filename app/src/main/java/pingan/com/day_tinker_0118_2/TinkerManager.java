package pingan.com.day_tinker_0118_2;

import android.content.Context;

import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;

/**
 * Created by WuXirui
 * Create Time: 2018/1/17
 * Description:
 */

public class TinkerManager {
    private static boolean isInstalled = false;
    private static ApplicationLike app;

    /**
     * 安装Tinker
     *
     * @param applicationLike
     */
    public static void installTinker(ApplicationLike applicationLike) {
        app = applicationLike;
        if (isInstalled) {
            return;
        }
        TinkerInstaller.install(applicationLike);
        isInstalled = true;
    }

    /**
     * 添加补丁包路径
     *
     * @param path
     */
    public static void addPatch(String path) {
        if (isInstalled) {
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), path);
        }
    }

    /**
     * 从ApplicationLike中获取上下文环境
     *
     * @return
     */
    public static Context getApplicationContext() {
        return app.getApplication().getApplicationContext();
    }
}
