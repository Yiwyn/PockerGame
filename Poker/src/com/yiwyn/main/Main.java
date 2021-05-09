package com.yiwyn.main;

import com.yiwyn.card.CardType;
import com.yiwyn.tool.PokerManager;
import com.yiwyn.tool.PokerPlayer;

public class Main {

    public static void main(String[] args) {

        PokerPlayer playerA = new PokerPlayer("玩家A");
        PokerPlayer playerB = new PokerPlayer("玩家B");

        PokerManager instance = PokerManager.getInstance();
        instance.InitPokerGame(playerA, playerB);
        PokerPlayer winner = instance.getWinner();

        if (winner != null) {
            System.out.println("获胜的人是" + winner.getPlayerName());
        } else {
            System.out.println("平局");
        }


    }
}
