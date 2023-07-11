package com.example.uas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uas.R;
import com.example.uas.models.Notification;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder>{
    private Context context;
    private List<Notification> notifications;

    public NotificationAdapter(Context context, List<Notification> notifications) {
        this.context = context;
        this.notifications = notifications;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView bodyNotifications, titleNotifications;
        public ViewHolder(@NonNull View view) {
            super(view);
            titleNotifications = view.findViewById(R.id.notificationTitle);
            bodyNotifications = view.findViewById(R.id.notificationBody);
        }
    }

    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.ViewHolder holder, int position) {
        Notification notification = notifications.get(position);
        holder.bodyNotifications.setText(notification.getBody());
        holder.titleNotifications.setText(notification.getTitle());
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }
}