package com.example.presschool.adapters.grid;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.presschool.R;
import com.example.presschool.models.CardItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private static final String TAG = "CardPagerAdapter";
    private Context context;
    private List<CardView> mViews;
    private List<CardItem> mData;
    private float mBaseElevation;
    private Handler handler;
    private Runnable r;
    private Activity activity;
    private int duration = 900;


    public CardPagerAdapter(Context applicationContext) {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        this.context = applicationContext;
    }

    public void addCardItem(CardItem item) {
        mViews.add(null);
        mData.add(item);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {
        return view == object;
    }

    @NotNull
    @Override
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
        View view = null;

        view = mData.get(position).getV();

        container.addView(view);
        bind(position, mData.get(position), view);
        CardView cardView = view.findViewById(R.id.cardView);

        Log.e(TAG, "instantiateItem: " + position);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);


        YoYo.with(Techniques.FadeIn)
                .duration(600)
                .playOn(view);


        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, @NotNull Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(int position, CardItem item, View view) {
        switch (position) {
            case 0:
//
//                view.findViewById(R.id.tvCustomerSkipRegisteration).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        ((Activity) context).finish();
//                        Intent intent = new Intent(context, MainActivity.class);
//                        context.startActivity(intent);
//                        Prefs.edit().putString(Constants.WORKER_OR_CUSTOMER, Constants.CUSTOMERS).apply();
//                        ((Activity) context).overridePendingTransition(R.anim.enter, R.anim.exit);
//
//                    }
//                });

                break;
            case 1:
                break;
            case 2:
                break;
        }
    }


}
