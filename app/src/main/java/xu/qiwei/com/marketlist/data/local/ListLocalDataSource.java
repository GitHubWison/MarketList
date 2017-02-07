package xu.qiwei.com.marketlist.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import xu.qiwei.com.marketlist.data.MarketItem;
import xu.qiwei.com.marketlist.data.MarketListDataSource;
import xu.qiwei.com.marketlist.util.schedulers.BaseSchedulerProvider;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by xuqiwei on 17-2-6.
 */

public class ListLocalDataSource implements MarketListDataSource{
    @NonNull
    private final BriteDatabase mDatabaseHelper;
    @Nullable
    private static ListLocalDataSource INSTANCE;
    private Func1<Cursor,MarketItem> mMarketMapperFunc;

    public ListLocalDataSource(@NonNull Context context, @NonNull BaseSchedulerProvider baseSchedulerProvider) {
        checkNotNull(context,"context不可为null");
        checkNotNull(baseSchedulerProvider,"baseSchedulerProvider不可为null");
        MarketListDBHelper dbHelper = new MarketListDBHelper(context);
        SqlBrite sqlBrite = SqlBrite.create();
        mDatabaseHelper = sqlBrite.wrapDatabaseHelper(dbHelper, baseSchedulerProvider.io());
        mMarketMapperFunc = new Func1<Cursor, MarketItem>() {
            @Override
            public MarketItem call(Cursor cursor) {
                String entryid = cursor.getString(cursor.getColumnIndexOrThrow(MarketItem.ENTRYID));
                String description = cursor.getString(cursor.getColumnIndexOrThrow(MarketItem.DESCRIPTION));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(MarketItem.TITLE));
                boolean isComplete = cursor.getInt(cursor.getColumnIndexOrThrow(MarketItem.COMPLETED))==1;
                return new MarketItem(entryid,title,description,isComplete);
            }
        };

    }

    public static ListLocalDataSource getInstance(
            @NonNull Context context,
            @NonNull BaseSchedulerProvider schedulerProvider) {
        if (INSTANCE==null) {
            INSTANCE = new ListLocalDataSource(context,schedulerProvider);
        }
        return INSTANCE;
    }
  /*  public void saveMarketList(MarketItem marketItem)
    {
        ContentValues content = new ContentValues();
        content.put(MarketItem.ENTRYID,marketItem.getmId());
        content.put(MarketItem.TITLE,marketItem.getmTitle());
        content.put(MarketItem.COMPLETED,marketItem.ismCompleted());
        content.put(MarketItem.DESCRIPTION,marketItem.getmDescription());
        mDatabaseHelper.insert(MarketItem.TABLE_NAME, content, SQLiteDatabase.CONFLICT_REPLACE);
    }*/
/*    public Observable<List<MarketItem>> getAllList(){
        String[] projection = {
                MarketItem.ENTRYID,
                MarketItem.TITLE,
                MarketItem.DESCRIPTION,
                MarketItem.COMPLETED
        };
        String sql = String.format("SELECT %s FROM %s", TextUtils.join(",", projection), MarketItem.TABLE_NAME);
        return mDatabaseHelper.createQuery(MarketItem.TABLE_NAME, sql)
                .mapToList(mMarketMapperFunc);
    }*/

    @Override
    public void saveMarketItem(@NonNull MarketItem marketItem) {
        ContentValues content = new ContentValues();
        content.put(MarketItem.ENTRYID,marketItem.getmId());
        content.put(MarketItem.TITLE,marketItem.getmTitle());
        content.put(MarketItem.COMPLETED,marketItem.ismCompleted());
        content.put(MarketItem.DESCRIPTION,marketItem.getmDescription());
        mDatabaseHelper.insert(MarketItem.TABLE_NAME, content, SQLiteDatabase.CONFLICT_REPLACE);
    }

    @Override
    public Observable<List<MarketItem>> getAllMarketList() {
        String[] projection = {
                MarketItem.ENTRYID,
                MarketItem.TITLE,
                MarketItem.DESCRIPTION,
                MarketItem.COMPLETED
        };
        String sql = String.format("SELECT %s FROM %s", TextUtils.join(",", projection), MarketItem.TABLE_NAME);
        return mDatabaseHelper.createQuery(MarketItem.TABLE_NAME, sql)
                .mapToList(mMarketMapperFunc);
    }
}
