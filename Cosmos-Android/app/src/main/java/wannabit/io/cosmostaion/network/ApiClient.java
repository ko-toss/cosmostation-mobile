package wannabit.io.cosmostaion.network;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import wannabit.io.cosmostaion.R;
import wannabit.io.cosmostaion.utils.WUtil;

public class ApiClient {

    private static WannabitChain service_wannabit_chain = null;
    public static WannabitChain getWannabitChain(Context c) {
        if (service_wannabit_chain == null) {
            synchronized (ApiClient.class) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(c.getString(R.string.url_lcd_wannabit))
                        .client(WUtil.getUnsafeOkHttpClient().build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                service_wannabit_chain = retrofit.create(WannabitChain.class);
            }
        }
        return service_wannabit_chain;
    }
}