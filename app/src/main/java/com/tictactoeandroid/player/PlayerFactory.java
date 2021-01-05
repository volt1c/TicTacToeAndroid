package com.tictactoeandroid.player;

import com.tictactoeandroid.AbstractFactory;

public class PlayerFactory implements AbstractFactory<Player, PlayerType> {
    public Player create(PlayerType arg) throws ClassNotFoundException {
        switch (arg) {
            case User:
                return (Player) new UserPlayer();
            case RandomAI:
                return (Player) new RandomAIPlayer();
            default:
                throw new ClassNotFoundException();
        }
    }
}