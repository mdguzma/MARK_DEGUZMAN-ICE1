/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects and then
 * asks the user to pick a card and searches the array of cards for the match to
 * the user's card. To be used as starting code in ICE 1
 *
 * @author srinivsi
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random rand = new Random();

        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1);
            c.setSuit(Card.SUITS[rand.nextInt(3)]);
            magicHand[i] = c;
        }
        
        //insert code to ask the user for Card value and suit, create their card
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a card value (1-13): ");
        int userValue = scanner.nextInt();

        System.out.print("Enter a suit (0-3 where 0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
        int userSuitIndex = scanner.nextInt();

        // Create player card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(Card.SUITS[userSuitIndex]);

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
            System.out.println(String.format("%d of %s is in the magic hand!", userValue, userCard.getSuit()));
        } else {
            System.out.println(String.format("Sorry, your card is not in the magic hand.", userValue, userCard.getSuit()));
        }
        // add one luckcard hard code 2,clubs
    }

}
