package com.tictactoeandroid.player;

import androidx.annotation.NonNull;

import com.tictactoeandroid.AbstractFactory;

public class PlayerFactory implements AbstractFactory<Player, PlayerData> {
    @Override
    public Player create(@NonNull PlayerData arg) throws ClassCastException{
        switch (arg.type){
            case User:
                return new UserPlayer(arg.mark.mark);
            case RandomAI:
                return new RandomAIPlayer(arg.mark.mark);
        }
        throw new ClassCastException();
    }
}
