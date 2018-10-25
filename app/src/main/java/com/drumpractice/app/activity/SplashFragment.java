package com.drumpractice.app.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.piotrklis.drumpractice.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

public class SplashFragment extends Fragment {

    private Unbinder unbinder;
    private CompositeDisposable subscriptions;
    private SplashViewModel viewModel;

    public static Fragment newInstance() {
        return new SplashFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createViewModel();
        subscriptions.add(viewModel.shouldLoadJsonData()
                .subscribe(shouldLoad -> {
                    if (shouldLoad) {
                        viewModel.loadJsonDataToDB().subscribe();
                    } else {
                        getActivity().finish();
                    }
                }));
    }

    private SplashViewModel createViewModel() {
        return viewModel = DaggerSplashComponent.builder()
                .splashModule(new SplashComponent.SplashModule())
                .build()
                .splashViewModel();
    }
}
