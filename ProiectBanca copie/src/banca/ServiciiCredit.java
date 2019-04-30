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
public interface ServiciiCredit {
    public void citesteCredit();
    public void detaliiCredit();
    public void afisareRate();
    public void adaugareRata(Rata c);
    public Rata getRata(int i);
    public void afisareTot();
    public void detaliiCreditCSV(FileWriter csv,FileWriter audit) throws Exception;
    public void citesteCreditFis(Scanner sc,FileWriter audit) throws Exception;
    
}
