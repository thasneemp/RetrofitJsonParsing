package recyclerviewloader.test.com.recyclerviewloader;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import recyclerviewloader.test.com.recyclerviewloader.communication.NetworkManager;
import recyclerviewloader.test.com.recyclerviewloader.communication.NetworkOptions;
import recyclerviewloader.test.com.recyclerviewloader.model.News;
import recyclerviewloader.test.com.recyclerviewloader.retrofit.ApiClient;
import recyclerviewloader.test.com.recyclerviewloader.retrofit.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListActivity extends AppCompatActivity implements NetworkManager.OnNetWorkListener {

    private RecyclerView mNewsListRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private View mCoordinatorLayoutView;
    private static final long SCAN_PERIOD = 5000;
    private NetworkManager mNetworkManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mNetworkManager = NetworkManager.getInstance(this);
        mNetworkManager.setOnNetworkListener(this);
        setUI();

    }

    private void setUI() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        mCoordinatorLayoutView = findViewById(R.id.snackbarPosition);
        mNewsListRecyclerView  = (RecyclerView) findViewById(R.id.device_recycler_view);
        mNewsListRecyclerView.setLayoutManager(new LinearLayoutManager(NewsListActivity.this));
        mNewsListRecyclerView.setHasFixedSize(true);
        mSwipeRefreshLayout.setVisibility(View.VISIBLE);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent);
        mSwipeRefreshLayout.setOnRefreshListener(onRefreshListener);
        getLists();
    }

    private void getLists() {
     /*   mNetworkManager.setProgressDialog(NewsListActivity.this, getString(R.string.loading), false);
        if (AppUtil.hasDataConnectivity(this)) {
            mNetworkManager.getJsonRequestWithHeaders(NetworkOptions.GET_REQUEST, URLConstants.GET_NEWS_LIST,
                    100);
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.not_connected_to_network),
                    Toast.LENGTH_SHORT).show();
        }*/

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<News> call = apiService.getNewsList();
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                int statusCode = response.code();
                Log.d("TAG","SIZE IS " + response.toString().length());
                //List<Movie> movies = response.body().getResults();
               // recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                // Log error here since request failed
                Log.e("TAG", t.toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_news_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        @Override
        public void onRefresh() {
            Toast.makeText(getApplicationContext(),"Loading",Toast.LENGTH_SHORT).show();
            try {
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, SCAN_PERIOD);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    };


    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(Object object, int type, int requestId) {
        switch (type) {
            case NetworkOptions.JSON_OBJECT_REQUEST: {
                switch (requestId) {
                    case 100:
                        if (object instanceof JSONObject) {
                            JSONObject jsonObject = (JSONObject) object;

                        } else
                            return;
                        break;
                }
            }
        }
    }
}
