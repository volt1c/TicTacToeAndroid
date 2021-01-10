package com.tictactoeandroid;

import androidx.annotation.NonNull;

public interface AbstractFactory<TReturn,TArgument> {
    TReturn create(@NonNull TArgument arg)
            throws ClassNotFoundException;
}
