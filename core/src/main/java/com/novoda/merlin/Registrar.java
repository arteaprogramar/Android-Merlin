package com.novoda.merlin;

import androidx.annotation.Nullable;

class Registrar {

    @Nullable
    private final Register<Connectable> connectables;
    @Nullable
    private final Register<Disconnectable> disconnectables;
    @Nullable
    private final Register<Bindable> bindables;

    Registrar(@Nullable Register<Connectable> connectables, @Nullable Register<Disconnectable> disconnectables, @Nullable Register<Bindable> bindables) {
        this.connectables = connectables;
        this.disconnectables = disconnectables;
        this.bindables = bindables;
    }

    void registerConnectable(Connectable connectable) {
        connectables().register(connectable);
    }

    private Register<Connectable> connectables() {
        if (connectables == null) {
            throw MerlinMissingRegisterablesException.missing(Connectable.class);
        }
        return connectables;
    }

    void registerDisconnectable(Disconnectable disconnectable) {
        disconnectables().register(disconnectable);
    }

    private Register<Disconnectable> disconnectables() {
        if (disconnectables == null) {
            throw MerlinMissingRegisterablesException.missing(Disconnectable.class);
        }
        return disconnectables;
    }

    void registerBindable(Bindable bindable) {
        bindables().register(bindable);
    }

    private Register<Bindable> bindables() {
        if (bindables == null) {
            throw MerlinMissingRegisterablesException.missing(Bindable.class);
        }
        return bindables;
    }

    void clearRegistrations() {
        if (connectables != null) {
            connectables.clear();
        }

        if (disconnectables != null) {
            disconnectables.clear();
        }

        if (bindables != null) {
            bindables.clear();
        }
    }
}