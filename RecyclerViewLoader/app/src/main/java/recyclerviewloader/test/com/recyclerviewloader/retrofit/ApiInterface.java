package recyclerviewloader.test.com.recyclerviewloader.retrofit;


import recyclerviewloader.test.com.recyclerviewloader.model.News;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("ipdpb.ashx?" +
            "TemplateName=Promotions_ipad.htm&p=" +
            "Common.Announcements&Handler=News&AppName=EMC&Type=News&F=J")
    Call<News> getNewsList();
}
