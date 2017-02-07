package xu.qiwei.com.marketlist.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import xu.qiwei.com.marketlist.data.MarketItem;


/**
 * Created by xuqiwei on 17-2-6.
 */

public class MarketListDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MarketLists.db";
    public static final int DATABASE_VERSION = 1;
    public static final String ID = "_id";


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MarketItem.TABLE_NAME + " (" +
                    ID + " TEXT" + " PRIMARY KEY," +
                    MarketItem.ENTRYID + " TEXT" + "," +
                    MarketItem.TITLE+ " TEXT" + "," +
                    MarketItem.DESCRIPTION + " TEXT" + "," +
                    MarketItem.COMPLETED+ " INTEGER" +
                    " )";
    public MarketListDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
