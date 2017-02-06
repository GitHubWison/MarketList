package xu.qiwei.com.marketlist.data;

import android.support.annotation.Nullable;

/**
 * Created by xuqiwei on 17-2-6.
 */

public class MarketItem {
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
}
