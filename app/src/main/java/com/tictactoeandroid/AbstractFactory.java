package com.tictactoeandroid;

public interface AbstractFactory<TReturn,TArgument> {
    TReturn create(TArgument arg)
            throws ClassNotFoundException;
}
