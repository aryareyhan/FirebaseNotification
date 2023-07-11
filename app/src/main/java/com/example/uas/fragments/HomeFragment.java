package com.example.uas.fragments;

import static com.example.uas.fragments.NotificationFragment.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.uas.R;
import com.example.uas.adapters.PostAdapter;
import com.example.uas.models.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private PostAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Post> dataList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        dataList = new ArrayList<>();
        recyclerView = rootView.findViewById(R.id.recycler_view);
        fetchPosts();

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new PostAdapter(getActivity(),dataList);
        recyclerView.setAdapter(mAdapter);

        return rootView;
    }
    private void fetchPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject post = response.getJSONObject(i);

                                String userId = String.valueOf(post.getInt("userId"));
                                String id = String.valueOf(post.getInt("id"));
                                String title = post.getString("title");
                                String body = post.getString("body");

                                dataList.add(new Post(userId,id,title,body));
                            }
                            layoutManager = new LinearLayoutManager(getActivity());
                            recyclerView.setLayoutManager(layoutManager);

                            mAdapter = new PostAdapter(getActivity(),dataList);
                            recyclerView.setAdapter(mAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(requireContext());
        requestQueue.add(jsonArrayRequest);
    }
}
