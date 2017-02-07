package xu.qiwei.com.marketlist.data;

import android.support.annotation.NonNull;

import java.util.List;

import rx.Observable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by xuqiwei on 17-2-7.
 */

public class MarketListRepository implements MarketListDataSource{
    public static MarketListRepository INSTANCE;
    private MarketListDataSource localDataSource;
    public static MarketListRepository getInstance(@NonNull MarketListDataSource localDataSource) {
        if (INSTANCE==null) {
            INSTANCE = new MarketListRepository(localDataSource);
        }
        return INSTANCE;
    }

    public MarketListRepository(@NonNull MarketListDataSource localDataSource) {
            this.localDataSource = checkNotNull(localDataSource);
    }

    @Override
    public void saveMarketItem(@NonNull MarketItem marketItem) {
        localDataSource.saveMarketItem(marketItem);
    }

    @Override
    public Observable<List<MarketItem>> getAllMarketList() {
        return localDataSource.getAllMarketList();
    }
}
