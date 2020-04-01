package com.example.presschool;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.presschool.adapters.grid.CardFragmentPagerAdapter;
import com.example.presschool.adapters.grid.CardPagerAdapter;
import com.example.presschool.models.CardItem;
import com.example.presschool.models.ShadowTransformer;
import com.example.presschool.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setCardPagerAdapter();
    }

    private void setCardPagerAdapter() {
        mCardAdapter = new CardPagerAdapter(getApplicationContext());
        mCardAdapter.addCardItem(new CardItem(LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.layout_cat1, null)));
        mCardAdapter.addCardItem(new CardItem(LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.layout_cat2, null)));
        mCardAdapter.addCardItem(new CardItem(LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.layout_cat3, null)));
        mCardAdapter.addCardItem(new CardItem(LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.layout_cat4, null)));
        mCardAdapter.addCardItem(new CardItem(LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.layout_cat5, null)));
        mCardAdapter.addCardItem(new CardItem(LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.layout_cat6, null)));

        mFragmentCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),
                Utils.dpToPixels(2, this));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setPageMargin(1);

        mCardShadowTransformer.enableScaling(true);
        mFragmentCardShadowTransformer.enableScaling(true);
    }


}
