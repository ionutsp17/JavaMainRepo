package uno.java.GUI;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import uno.java.entities.Card;
import uno.java.game.Game;

public class Handler implements MouseListener{
	public static int turn = 0;
	@Override
	public void mouseClicked(MouseEvent e) {
		if(turn == 4){
			turn = 0;
		}
		else if (turn == -1){
			turn = 3;
		}
		
		if(((Card)e.getSource()).isSpecial == false){
			if(turn == 0){
				this.releaseCard(((Card)e.getSource()));
				this.refreshPanel(Game.gameWindow.playerCardsPanel1, ((Card)e.getSource()));
			} else if(turn ==1){
				this.releaseCard(((Card)e.getSource()));
				this.refreshPanel(Game.gameWindow.playerCardsPanel2, ((Card)e.getSource()));
			}
			else if (turn == 2){
				this.releaseCard(((Card)e.getSource()));
				this.refreshPanel(Game.gameWindow.playerCardsPanel3, ((Card)e.getSource()));
			}
			else if (turn == 3){
				this.releaseCard(((Card)e.getSource()));
				this.refreshPanel(Game.gameWindow.playerCardsPanel4, ((Card)e.getSource()));
			}
			
			//Game.players.get(turn).setTurn(false);
			
			
			
			
		}
		turn++;
		System.out.println(turn);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void refreshPanel(PlayerCardsPanel panel,Card card){
		panel.player.getHand().remove(card);
		panel.removeAll();
		panel.updateUI();
		panel.arrangeCards(panel.player.getHand());
	}
	public void releaseCard(Card card){
		Game.gameWindow.releasedCards.cards.add(card);
		Game.gameWindow.releasedCards.releasedCard = (card);
		Game.gameWindow.releasedCards.repaint();
	}
}
