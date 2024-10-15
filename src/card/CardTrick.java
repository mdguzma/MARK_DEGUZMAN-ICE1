/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects and then
 * asks the user to pick a card and searches the array of cards for the match to
 * the user's card. To be used as starting code in ICE 1
 *
 * @author srinivsi
 * @Student: Mark De Guzman 991754335
 */
public class CardTrick { // Not High cohesion -> has more than one job, 
    // interacts with both input and output with the user
    //1. Generates 7 cards
    //2. Matching cards print + user interaction
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random rand = new Random();

        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1);
            c.setSuit(Card.SUITS[rand.nextInt(3)]);
            magicHand[i] = c;
        }
        
        Card luckCard = new Card();
        luckCard.setSuit("Diamonds");
        luckCard.setValue(7);
        magicHand[magicHand.length - 1] = luckCard;

        Card userCard = luckCard;
        
        // and search magicHand here
        boolean found = false;
        for (Card card : magicHand) {
            System.out.println(card.getSuit() + " " + card.getValue());
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                found = true;
            }
        }
        
        //Then report the result here
        if (found) {
            System.out.println(String.format("%d of %s is in the magic hand!", userCard.getValue(), userCard.getSuit()));
        } else {
            System.out.println(String.format("Sorry, your card is not in the magic hand.", userCard.getValue(), userCard.getSuit()));
        }

    }
}
