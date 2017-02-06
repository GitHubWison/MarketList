package xu.qiwei.com.marketlist.data.local;

import android.content.Context;
import android.support.annotation.NonNull;

import xu.qiwei.com.marketlist.util.schedulers.BaseSchedulerProvider;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by xuqiwei on 17-2-6.
 */

public class ListLocalDataSource {

    public ListLocalDataSource(@NonNull Context context, @NonNull BaseSchedulerProvider baseSchedulerProvider) {
        checkNotNull(context,"context不可为null");
        checkNotNull(baseSchedulerProvider,"baseSchedulerProvider不可为null");

    }
}
