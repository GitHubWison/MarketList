package xu.qiwei.com.marketlist.data;

import android.support.annotation.NonNull;

import java.util.List;

import rx.Observable;

/**
 * Created by xuqiwei on 17-2-7.
 */

public interface MarketListDataSource {
    public void saveMarketItem(@NonNull MarketItem marketItem);
    public Observable<List<MarketItem>> getAllMarketList();
}
