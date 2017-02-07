package xu.qiwei.com.marketlist.addmarketitem;

import xu.qiwei.com.marketlist.data.MarketItem;
import xu.qiwei.com.marketlist.data.MarketListDataSource;
import xu.qiwei.com.marketlist.data.MarketListRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by xuqiwei on 17-2-7.
 */

public class AddMarketPresenter implements AddMarketContract.Presenter{

    private MarketListDataSource marketListDataSource;
    private AddMarketContract.View view;
    public AddMarketPresenter(MarketListRepository listRepository, AddMarketContract.View view) {
        this.marketListDataSource = checkNotNull(listRepository,"listLocalDataSource cannot be null");
        this.view = checkNotNull(view,"view cannot be null");

    }

    @Override
    public void saveMarketItem(MarketItem marketItem) {
        marketListDataSource.saveMarketItem(marketItem);
        view.showSuccess();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
