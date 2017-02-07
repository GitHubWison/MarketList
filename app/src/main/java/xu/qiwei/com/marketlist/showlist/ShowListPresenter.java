package xu.qiwei.com.marketlist.showlist;

import java.util.List;

import rx.Observable;
import xu.qiwei.com.marketlist.addmarketitem.AddMarketContract;
import xu.qiwei.com.marketlist.data.MarketItem;
import xu.qiwei.com.marketlist.data.MarketListDataSource;
import xu.qiwei.com.marketlist.data.MarketListRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by xuqiwei on 17-2-7.
 */

public class ShowListPresenter implements ShowListContract.Presenter {
    private MarketListDataSource marketListDataSource;
    private ShowListContract.View view;
    public ShowListPresenter(MarketListRepository listRepository, AddMarketContract.View view) {
        this.marketListDataSource = listRepository;
        view = checkNotNull(view);
    }

    @Override
    public void getAllList() {
        Observable<List<MarketItem>> marketItems =  marketListDataSource.getAllMarketList();
        view.showAllList(marketItems);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
