package xu.qiwei.com.marketlist.addmarketitem;

import xu.qiwei.com.marketlist.BasePresenter;
import xu.qiwei.com.marketlist.BaseView;
import xu.qiwei.com.marketlist.data.MarketItem;

/**
 * Created by xuqiwei on 17-2-7.
 */

public class AddMarketContract {
    public interface View extends BaseView<Presenter>
    {
        void showSuccess();
    }
    public interface Presenter extends BasePresenter
    {
        void saveMarketItem(MarketItem marketItem);
    }
}
