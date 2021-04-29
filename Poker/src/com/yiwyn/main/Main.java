package com.yiwyn.main;

import com.yiwyn.card.CardType;
import com.yiwyn.tool.PokerManager;
import com.yiwyn.tool.PokerPlayer;

public class Main {

    public static void main(String[] args) {
        PokerManager.getInstance().InitPokerGame();
        PokerPlayer winner = PokerManager.getInstance().getWinner();

        System.out.println("获胜的人是" + winner.getPlayerName());


    }
}
