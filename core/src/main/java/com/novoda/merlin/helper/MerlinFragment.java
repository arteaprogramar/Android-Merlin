package com.novoda.merlin.helper;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.novoda.merlin.Bindable;
import com.novoda.merlin.Connectable;
import com.novoda.merlin.Disconnectable;
import com.novoda.merlin.Merlin;

public abstract class MerlinFragment extends Fragment {
    private static final String TAG = MerlinFragment.class.getSimpleName();

    // Merlin Variable
    protected Merlin merlin;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        merlin = createMerlin();
    }

    /**
     * Create Merlin
     *
     * @return new Merlin.Builder()
     * .withConnectableCallbacks()
     * .withDisconnectableCallbacks()
     * .withBindableCallbacks()
     * .build(context)
     */
    protected abstract Merlin createMerlin();

    protected void registerConnectable(Connectable connectable) {
        merlin.registerConnectable(connectable);
    }

    protected void registerDisconnectable(Disconnectable disconnectable) {
        merlin.registerDisconnectable(disconnectable);
    }

    protected void registerBindable(Bindable bindable) {
        merlin.registerBindable(bindable);
    }

    @Override
    public void onStart() {
        super.onStart();
        merlin.bind();
    }

    @Override
    public void onPause() {
        merlin.bind();
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        merlin.unbind();
    }
}