package wormgame.gui;

import wormgame.domain.Piece;
import wormgame.game.WormGame;

import javax.swing.*;
import java.awt.*;

public class DrawingBoard extends JPanel implements Updatable {
    private WormGame game;
    private int pieceLength;

    public DrawingBoard(WormGame game, int pieceLength){
        this.game = game;
        this.pieceLength = pieceLength;
    }

    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        for(Piece piece : game.getWorm().getPieces()){
            graphics.setColor(Color.BLACK);
            graphics.fill3DRect(piece.getX()*pieceLength, piece.getY()*pieceLength, pieceLength, pieceLength, true);
        }
        graphics.setColor(Color.RED);
        graphics.fillOval(game.getApple().getX()*pieceLength, game.getApple().getY()*pieceLength, pieceLength, pieceLength);
    }

    @Override
    public void update() {
        super.repaint();
    }
}
