package com.example.uas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uas.FirebaseService;
import com.example.uas.R;
import com.example.uas.adapters.NotificationAdapter;
import com.example.uas.models.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private View rootView;
    public static List<Notification> notifications;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(notifications == null){
            notifications = new ArrayList<>();
        }
        rootView = inflater.inflate(R.layout.fragment_notification, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new NotificationAdapter(getActivity(),notifications);
        recyclerView.setAdapter(mAdapter);
        FirebaseService.setRecyclerView(recyclerView);
        return rootView;
    }
}
