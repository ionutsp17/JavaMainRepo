package uno.java.GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import uno.java.entities.Card;
import uno.java.game.Game;

public class DeckHandler implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		this.refreshPanel(Game.gameWindow.playerCardsPanel1, ((DeckPanel)e.getSource()).getDeck().get(((DeckPanel)e.getSource()).getDeck().size()-1));
		//System.out.println(Game.gameWindow.deckPanel.getDeck().get(Game.gameWindow.deckPanel.getDeck().size()-1));
		Game.gameWindow.deckPanel.getDeck().remove(((DeckPanel)e.getSource()).getDeck().get(((DeckPanel)e.getSource()).getDeck().size()-1));
		
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
		panel.player.getHand().add(card);
		panel.removeAll();
		panel.updateUI();
		panel.arrangeCards(panel.player.getHand());
	}
}
