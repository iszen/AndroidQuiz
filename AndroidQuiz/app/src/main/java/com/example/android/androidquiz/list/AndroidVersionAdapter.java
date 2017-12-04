package com.example.android.androidquiz.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.androidquiz.R;

import java.util.Collections;
import java.util.List;

import static com.example.android.androidquiz.model.AndroidVersions.*;

/**
 * Created by izxmg on 03-Dec-17.
 */

public class AndroidVersionAdapter extends RecyclerView.Adapter<AndroidVersionAdapter.MyViewHolder> implements ItemTouchHelperAdapter {

    private List<String> versionList;

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(versionList, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(versionList, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView versionName;
        public ImageView icon;

        public MyViewHolder(View view) {
            super(view);
            versionName = (TextView) view.findViewById(R.id.version_textview);
            icon = (ImageView) view.findViewById(R.id.icon_imageview);
        }
    }

    public boolean isCorrectlyOrdered() {
        if (AndroidVersion.valueOf(versionList.get(0).replaceAll(" ", "_")) != AndroidVersion.Cupcake) {
            return false;
        } else if (AndroidVersion.valueOf(versionList.get(1).replaceAll(" ", "_")) != AndroidVersion.Donut) {
            return false;
        } else if (AndroidVersion.valueOf(versionList.get(2).replaceAll(" ", "_")) != AndroidVersion.Eclair) {
            return false;
        } else if (AndroidVersion.valueOf(versionList.get(3).replaceAll(" ", "_")) != AndroidVersion.Froyo) {
            return false;
        } else if (AndroidVersion.valueOf(versionList.get(4).replaceAll(" ", "_")) != AndroidVersion.Gingerbread) {
            return false;
        } else if (AndroidVersion.valueOf(versionList.get(5).replaceAll(" ", "_")) != AndroidVersion.Honeycomb) {
            return false;
        } else if (AndroidVersion.valueOf(versionList.get(6).replaceAll(" ", "_")) != AndroidVersion.Ice_Cream_Sandwich) {
            return false;
        } else if (AndroidVersion.valueOf(versionList.get(7).replaceAll(" ", "_")) != AndroidVersion.Jelly_Bean) {
            return false;
        } else if (AndroidVersion.valueOf(versionList.get(8).replaceAll(" ", "_")) != AndroidVersion.KitKat) {
            return false;
        } else if (AndroidVersion.valueOf(versionList.get(9).replaceAll(" ", "_")) != AndroidVersion.Lollipop) {
            return false;
        } else if (AndroidVersion.valueOf(versionList.get(10).replaceAll(" ", "_")) != AndroidVersion.Marshmallow) {
            return false;
        } else if (AndroidVersion.valueOf(versionList.get(11).replaceAll(" ", "_")) != AndroidVersion.Nougat) {
            return false;
        } else if (AndroidVersion.valueOf(versionList.get(12).replaceAll(" ", "_")) != AndroidVersion.Oreo) {
            return false;
        }
        return true;
    }


    public AndroidVersionAdapter(List<String> AndroidVersionList) {
        this.versionList = AndroidVersionList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String version = versionList.get(position);
        AndroidVersion androidVersion = AndroidVersion.valueOf(version.replaceAll(" ", "_"));
        holder.versionName.setText(version);
        int iconId = 0;
        switch (androidVersion) {
            case Cupcake:
                iconId = R.drawable.cupcake;
                break;
            case Donut:
                iconId = R.drawable.donut;
                break;
            case Eclair:
                iconId = R.drawable.eclair;
                break;
            case Froyo:
                iconId = R.drawable.froyo;
                break;
            case Gingerbread:
                iconId = R.drawable.gingerbread;
                break;
            case Honeycomb:
                iconId = R.drawable.honeycomb;
                break;
            case Ice_Cream_Sandwich:
                iconId = R.drawable.ice_cream_sandwich;
                break;
            case Jelly_Bean:
                iconId = R.drawable.jelly_bean;
                break;
            case KitKat:
                iconId = R.drawable.kitkat;
                break;
            case Lollipop:
                iconId = R.drawable.lollipop;
                break;
            case Marshmallow:
                iconId = R.drawable.marshmallow;
                break;
            case Nougat:
                iconId = R.drawable.nougat;
                break;
            case Oreo:
                iconId = R.drawable.oreo;
                break;
        }
        holder.icon.setImageResource(iconId);
    }

    @Override
    public int getItemCount() {
        return versionList.size();
    }
}