package me.sheimi.sgit;

import android.util.Log;

import com.facebook.stetho.Stetho;

import timber.log.Timber;

/**
 * Provides debug-build specific Application.
 *
 * To disable Stetho console logging change the setting in src/debug/res/values/bools.xml
 */
public class MGitDebugApplication extends SGitApplication {
    @Override
    protected Timber.Tree makeTimberTree() {
        Stetho.initializeWithDefaults(this);

        return new ConfigurableStethoTree(new ConfigurableStethoTree.Configuration.Builder()
            .showTags(true)
            .minimumPriority(Log.DEBUG)
            .build());
    }
}
