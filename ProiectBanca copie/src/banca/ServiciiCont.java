/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;

import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author vasua
 */
public interface ServiciiCont {
    
    public void depunere(float suma);
    public void retragere(float suma);
    public void detaliiCont();
    public void afisareSold();
    public void citesteCont();
    public void adaugareCard(Card c);
    public void afisareCarduri();
    public void adaugareCredit(Credit c);
    public void afisareCredite();
    public Credit getCredit(int i);
    public Card getCard(int i);
    public void afisareTot();
    public void detaliiContCSV(FileWriter csv,FileWriter audit) throws Exception;
    public void citesteContFis(Scanner sc,FileWriter audit) throws Exception;
    
}
