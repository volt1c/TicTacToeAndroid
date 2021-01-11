package com.tictactoeandroid.player;

import androidx.annotation.NonNull;

import com.tictactoeandroid.AbstractFactory;

public class PlayerFactory implements AbstractFactory<Player, PlayerType> {
    @Override
    public Player create(@NonNull PlayerType arg) throws ClassCastException{
        switch (arg){
            case User:
                new UserPlayer(arg.type);
            case RandomAI:
                new RandomAIPlayer(arg.type);
        }
        throw new ClassCastException();
    }
}
