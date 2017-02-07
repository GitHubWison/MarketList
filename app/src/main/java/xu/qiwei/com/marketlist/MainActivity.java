package xu.qiwei.com.marketlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import xu.qiwei.com.marketlist.addmarketitem.AddMarketContract;
import xu.qiwei.com.marketlist.addmarketitem.AddMarketPresenter;
import xu.qiwei.com.marketlist.data.MarketItem;
import xu.qiwei.com.marketlist.showlist.ShowListContract;
import xu.qiwei.com.marketlist.showlist.ShowListPresenter;
import xu.qiwei.com.marketlist.util.inject.Injection;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity implements AddMarketContract.View, ShowListContract.View{

    private AddMarketContract.Presenter presenter;
    private ShowListContract.Presenter showListPresenter;
    private Button addmarket_button;
    private TextView showlist_textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPresenter(new AddMarketPresenter(Injection.provideTasksRepository(this),this));
        setPresenter(new ShowListPresenter(Injection.provideTasksRepository(this),this));
        addmarket_button = (Button)findViewById(R.id.addmarket_button);
        showlist_textview = (TextView)findViewById(R.id.showlist_textview);

        initEvents();

    }

    private void initEvents() {
        addmarket_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.saveMarketItem(new MarketItem("111","111111desc"));
            }
        });
    }

    @Override
    public void showSuccess() {
        Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(AddMarketContract.Presenter presenter) {
        this.presenter = checkNotNull(presenter,"presenter cannot be null");
    }



    @Override
    public void setPresenter(ShowListContract.Presenter presenter) {
        this.showListPresenter = checkNotNull(presenter,"showListPresenter cannot be null");
    }

    @Override
    public void showAllList(Observable<List<MarketItem>> listObservable) {
        listObservable.flatMap(new Func1<List<MarketItem>, Observable<MarketItem>>() {
            @Override
            public Observable<MarketItem> call(List<MarketItem> tasks) {
                return Observable.from(tasks);
            }
        }).toList().subscribe(new Observer<List<MarketItem>>() {
            @Override
            public void onCompleted() {
//                mTasksView.setLoadingIndicator(false);
            }

            @Override
            public void onError(Throwable e) {
//                mTasksView.showLoadingTasksError();
            }

            @Override
            public void onNext(List<MarketItem> tasks) {
//                processTasks(tasks);

                showlist_textview.setText(tasks.size()+"");
            }
        });

    }
}
