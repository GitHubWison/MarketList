package xu.qiwei.com.marketlist.util.schedulers;

import android.support.annotation.NonNull;

import rx.Scheduler;

/**
 * Created by xuqiwei on 17-2-6.
 */

public interface BaseSchedulerProvider {
    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}
