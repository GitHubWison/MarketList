package xu.qiwei.com.marketlist.showlist;

import java.util.List;

import rx.Observable;
import xu.qiwei.com.marketlist.BasePresenter;
import xu.qiwei.com.marketlist.BaseView;
import xu.qiwei.com.marketlist.data.MarketItem;

/**
 * Created by xuqiwei on 17-2-7.
 */

public class ShowListContract {
    public interface View extends BaseView<Presenter>{
        void showAllList(Observable<List<MarketItem>> listObservable);
    }
    public interface Presenter extends BasePresenter{
        void getAllList();
    }
}
