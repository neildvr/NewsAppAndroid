package com.qoobico.remindme.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qoobico.remindme.R;
import com.qoobico.remindme.adapter.NewListAdapter;
import com.qoobico.remindme.adapter.RemindListAdapter;
import com.qoobico.remindme.dto.NewsDTO;
import com.qoobico.remindme.dto.RemindDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neil on 5/14/16.
 */
public class IUCA extends AbstractTabFragment implements SwipeRefreshLayout.OnRefreshListener {

    private static final int LAYOUT = R.layout.fragment_iuca;
    private String title;
    private Context context;
    private View view;
    private SwipeRefreshLayout swipeContainer;

    public static IUCA getInstance(Context context){
        Bundle args = new Bundle();
        IUCA fragment = new IUCA();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tap_itemm_IUCA));



        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        swipeContainer = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        swipeContainer.setOnRefreshListener(this);


        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycleView1);
        rv.setLayoutManager(new LinearLayoutManager(context));
        if(swipeContainer.isRefreshing()){
            swipeContainer.setRefreshing(false);
        }
        rv.setAdapter(new NewListAdapter(createMockNewsListData()));



        return view;
    }

    private List<NewsDTO> createMockNewsListData() {
        List<NewsDTO> data = new ArrayList<>();
        data.add(new NewsDTO("Bazarbaev I R+ "));
        data.add(new NewsDTO("Lansarov III R- "));
        data.add(new NewsDTO("Dauzov II R+ "));
        data.add(new NewsDTO("Kadyrov IV R- "));
        data.add(new NewsDTO("Shvab II R+ "));
        data.add(new NewsDTO("Bazarbaev I R+ "));
        data.add(new NewsDTO("Lansarov III R- "));
        data.add(new NewsDTO("Dauzov II R+ "));
        data.add(new NewsDTO("Kadyrov IV R- "));
        data.add(new NewsDTO("Shvab II R+ "));
        data.add(new NewsDTO("Bazarbaev I R+ "));
        data.add(new NewsDTO("Lansarov III R- "));
        data.add(new NewsDTO("Dauzov II R+ "));
        data.add(new NewsDTO("Kadyrov IV R- "));
        data.add(new NewsDTO("Shvab II R+ "));



        return data;

    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    public String getTitle() {
        return title;
    }


    @Override
    public void onRefresh() {
        createMockNewsListData();
    }
}
