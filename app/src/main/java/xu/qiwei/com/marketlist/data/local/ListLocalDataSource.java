package xu.qiwei.com.marketlist.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import xu.qiwei.com.marketlist.data.MarketItem;
import xu.qiwei.com.marketlist.util.schedulers.BaseSchedulerProvider;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by xuqiwei on 17-2-6.
 */

public class ListLocalDataSource {
    @NonNull
    private final BriteDatabase mDatabaseHelper;
    @Nullable
    private static ListLocalDataSource INSTANCE;

    public ListLocalDataSource(@NonNull Context context, @NonNull BaseSchedulerProvider baseSchedulerProvider) {
        checkNotNull(context,"context不可为null");
        checkNotNull(baseSchedulerProvider,"baseSchedulerProvider不可为null");
        MarketListDBHelper dbHelper = new MarketListDBHelper(context);
        SqlBrite sqlBrite = SqlBrite.create();
        mDatabaseHelper = sqlBrite.wrapDatabaseHelper(dbHelper, baseSchedulerProvider.io());

    }

    public static ListLocalDataSource getInstance(
            @NonNull Context context,
            @NonNull BaseSchedulerProvider schedulerProvider) {
        if (INSTANCE==null) {
            INSTANCE = new ListLocalDataSource(context,schedulerProvider);
        }
        return INSTANCE;
    }
    public void saveMarketList(MarketItem marketItem)
    {
        ContentValues content = new ContentValues();
//        content.put();
    }
}
