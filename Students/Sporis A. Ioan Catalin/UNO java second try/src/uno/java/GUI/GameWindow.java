package uno.java.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uno.java.entities.Card;
import uno.java.entities.Player;
import uno.java.game.Game;

public class GameWindow extends JFrame implements Designer {
	
	public Color backgroundColor = new Color(14,105,32);
	public JPanel backgroundPanel = new JPanel();
	private Rectangle deckPanelPosition = new Rectangle(400,250,100,152);
	public DeckPanel deckPanel;
	public GameCardsPanel releasedCards = new GameCardsPanel();
	private Rectangle realeasedCardsBounds = new Rectangle(700,250,100,152);
	
	public PlayerDescriptionPanel playerDescPanel1;
	public PlayerDescriptionPanel playerDescPanel2;
	
	public PlayerCardsPanel playerCardsPanel1;
	public PlayerCardsPanel playerCardsPanel2;
	public PlayerCardsPanel playerCardsPanel3;
	public PlayerCardsPanel playerCardsPanel4;
	
	public GameWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1370, 700);
		setVisible(true);
		this.setLayout(new GridLayout(1,1));
		
		backgroundPanel.setLayout(null);
		backgroundPanel.setSize(1370,700);
		backgroundPanel.setBackground(this.backgroundColor);
		this.arrangeItems();
		this.add(backgroundPanel);
		Game.players.get(0).setTurn(true);
		Game.players.get(1).setTurn(true);
		Game.players.get(2).setTurn(true);
		Game.players.get(3).setTurn(true);
		//this.startGame();
		
	}

	@Override
	public void componentSetBounds(Component component, Rectangle bounds) {
		component.setBounds(bounds);
	}

	@Override
	public void arrangeItems() {
		this.setDeckPanel(Game.deckOfCards.deck);
		this.setGameCardsPanel();
	}

	public void placePlayers(int nrOfPlayers,ArrayList<Player> players) {
		if (nrOfPlayers == 2) {
			PlayerDescriptionPanel playerDescPanel1 = new PlayerDescriptionPanel("images.png", players.get(0).getNickname(),
					new Dimension(120, 120));
			PlayerDescriptionPanel playerDescPanel2 = new PlayerDescriptionPanel("images.png", players.get(1).getNickname(),
					new Dimension(120, 120));

			playerCardsPanel1 = new PlayerCardsPanelHorizontal(new Dimension(600, 200));
			playerCardsPanel1.setPlayer(players.get(0));
			
			playerCardsPanel2 = new PlayerCardsPanelHorizontal(new Dimension(600, 150));
			playerCardsPanel2.setPlayer(players.get(1));
			
			playerCardsPanel1.arrangeCards(players.get(0).getHand());
			playerCardsPanel2.arrangeCards(players.get(1).getHand());
			
			this.componentSetBounds(playerDescPanel1, new Rectangle(285, 540, 120, 130));
			this.componentSetBounds(playerCardsPanel1,
					new Rectangle(425, 500, playerCardsPanel1.getWidth(), playerCardsPanel1.getHeight()));
			this.backgroundPanel.add(playerDescPanel1);
			this.backgroundPanel.add(playerCardsPanel1);

			this.componentSetBounds(playerDescPanel2, new Rectangle(905, 40, 120, 130));
			this.componentSetBounds(playerCardsPanel2,
					new Rectangle(285, 0, playerCardsPanel2.getWidth(), playerCardsPanel2.getHeight()));
			this.backgroundPanel.add(playerCardsPanel2);
			this.backgroundPanel.add(playerDescPanel2);
		
		} 
		else if (nrOfPlayers == 3) {
			PlayerDescriptionPanel playerDescPanel1 = new PlayerDescriptionPanel("images.png", players.get(0).getNickname(),
					new Dimension(120, 120));
			PlayerDescriptionPanel playerDescPanel2 = new PlayerDescriptionPanel("images.png", players.get(1).getNickname(),
					new Dimension(120, 120));
			PlayerDescriptionPanel playerDescPanel3 = new PlayerDescriptionPanel("images.png", players.get(2).getNickname(),
					new Dimension(120, 120));

			playerCardsPanel1 = new PlayerCardsPanelHorizontal(new Dimension(600, 200));
			playerCardsPanel1.setPlayer(players.get(0));
			
			playerCardsPanel3 = new PlayerCardsPanelHorizontal(new Dimension(600, 150));
			playerCardsPanel3.setPlayer(players.get(2));
			
			playerCardsPanel2 = new PlayerCardsPanelVertical(new Dimension(150, 400));
			playerCardsPanel2.setPlayer(players.get(1));
			
			playerCardsPanel1.arrangeCards(players.get(0).getHand());
			playerCardsPanel2.arrangeCards(players.get(1).getHand());
			playerCardsPanel3.arrangeCards(players.get(2).getHand());
						
			this.componentSetBounds(playerDescPanel1, new Rectangle(285, 540, 120, 130));
			this.componentSetBounds(playerCardsPanel1,
					new Rectangle(425, 500, playerCardsPanel1.getWidth(), playerCardsPanel1.getHeight()));

			this.backgroundPanel.add(playerDescPanel1);
			this.backgroundPanel.add(playerCardsPanel1);

			this.componentSetBounds(playerDescPanel3, new Rectangle(905, 40, 120, 130));
			this.componentSetBounds(playerCardsPanel3,
					new Rectangle(285, 0, playerCardsPanel3.getWidth(), playerCardsPanel3.getHeight()));

			this.backgroundPanel.add(playerCardsPanel3);
			this.backgroundPanel.add(playerDescPanel3);

			this.componentSetBounds(playerDescPanel2, new Rectangle(0, 65, 120, 130));
			this.componentSetBounds(playerCardsPanel2,
					new Rectangle(0, 205, playerCardsPanel2.getWidth(), playerCardsPanel2.getHeight()));

			this.backgroundPanel.add(playerDescPanel2);
			this.backgroundPanel.add(playerCardsPanel2);
		} else if (nrOfPlayers == 4) {
			PlayerDescriptionPanel playerDescPanel1 = new PlayerDescriptionPanel("images.png", players.get(0).getNickname(),
					new Dimension(120, 120));
			PlayerDescriptionPanel playerDescPanel2 = new PlayerDescriptionPanel("images.png", players.get(1).getNickname(),
					new Dimension(120, 120));
			PlayerDescriptionPanel playerDescPanel3 = new PlayerDescriptionPanel("images.png", players.get(2).getNickname(),
					new Dimension(120, 120));
			PlayerDescriptionPanel playerDescPanel4 = new PlayerDescriptionPanel("images.png", players.get(3).getNickname(),
					new Dimension(120, 120));

			playerCardsPanel1 = new PlayerCardsPanelHorizontal(new Dimension(600, 200));
			playerCardsPanel1.setPlayer(players.get(0));
			
			playerCardsPanel2 = new PlayerCardsPanelVertical(new Dimension(150, 400));
			playerCardsPanel2.setPlayer(players.get(1));
			
			playerCardsPanel3 = new PlayerCardsPanelHorizontal(new Dimension(600, 150));
			playerCardsPanel3.setPlayer(players.get(2));
			
			playerCardsPanel4 = new PlayerCardsPanelVertical(new Dimension(150, 400));
			playerCardsPanel4.setPlayer(players.get(3));

			playerCardsPanel1.arrangeCards(players.get(0).getHand());
			playerCardsPanel2.arrangeCards(players.get(1).getHand());
			playerCardsPanel3.arrangeCards(players.get(2).getHand());
			playerCardsPanel4.arrangeCards(players.get(3).getHand());
			
			this.componentSetBounds(playerDescPanel1, new Rectangle(285, 540, 120, 130));
			this.componentSetBounds(playerCardsPanel1,
					new Rectangle(425, 500, playerCardsPanel1.getWidth(), playerCardsPanel1.getHeight()));

			this.backgroundPanel.add(playerDescPanel1);
			this.backgroundPanel.add(playerCardsPanel1);
			
			this.componentSetBounds(playerDescPanel3, new Rectangle(905, 40, 120, 130));
			this.componentSetBounds(playerCardsPanel3,
					new Rectangle(285, 0, playerCardsPanel3.getWidth(), playerCardsPanel3.getHeight()));

			this.backgroundPanel.add(playerCardsPanel3);
			this.backgroundPanel.add(playerDescPanel3);

			this.componentSetBounds(playerDescPanel2, new Rectangle(0, 65, 120, 130));
			this.componentSetBounds(playerCardsPanel2,
					new Rectangle(0, 205, playerCardsPanel2.getWidth(), playerCardsPanel2.getHeight()));

			this.backgroundPanel.add(playerDescPanel2);
			this.backgroundPanel.add(playerCardsPanel2);

			this.componentSetBounds(playerDescPanel4, new Rectangle(1220, 485, 120, 130));
			this.componentSetBounds(playerCardsPanel4,
					new Rectangle(1220, 65, playerCardsPanel4.getWidth(), playerCardsPanel4.getHeight()));
			
			this.backgroundPanel.add(playerDescPanel4);
			this.backgroundPanel.add(playerCardsPanel4);
		}
		
		
		
	}
	public void setDeckPanel(ArrayList<Card> deck){
		this.deckPanel = new DeckPanel(deck);
		this.componentSetBounds(this.deckPanel, this.deckPanelPosition);
		this.backgroundPanel.add(this.deckPanel);
		}
	
	public void setGameCardsPanel(){
		this.componentSetBounds(this.releasedCards, this.realeasedCardsBounds);
		this.backgroundPanel.add(this.releasedCards);
	}
	
	public static void startGame(){
		
			if(Game.gameWindow.releasedCards.cards.isEmpty()){
				System.out.println("empty");
				//Game.players.get(0).setTurn(true);
		}
	}
}
