package xu.qiwei.com.marketlist.data;

import android.support.annotation.Nullable;

import java.util.UUID;

/**
 * Created by xuqiwei on 17-2-6.
 */

public class MarketItem {
    public static final String ENTRYID = "entryid";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String COMPLETED = "completed";
    public static final String TABLE_NAME = "MarketList";

    private final String mId;

    @Nullable
    private final String mTitle;

    @Nullable
    private final String mDescription;

    private final boolean mCompleted;

    public MarketItem(String mId, String mTitle, String mDescription) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        mCompleted = false;
    }
    public MarketItem( String mTitle, String mDescription) {
        this.mId = UUID.randomUUID().toString();
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        mCompleted = false;
    }
    public MarketItem( String mTitle, String mDescription,boolean mCompleted) {
        this.mId = UUID.randomUUID().toString();
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mCompleted = mCompleted;
    }

    public MarketItem(String entryid, String title, String description, boolean isComplete) {
        this.mId = entryid;
        this.mTitle = title;
        this.mDescription = description;
        this.mCompleted = isComplete;
    }

    @Nullable
    public String getmTitle() {
        return mTitle;
    }

    @Nullable
    public String getmDescription() {
        return mDescription;
    }

    public boolean ismCompleted() {
        return mCompleted;
    }

    public String getmId() {
        return mId;
    }
}
