/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;

import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author vasua
 */
public interface ServiciiSucursala {
    
    public void citesteSucursala();
    public void detaliiSucursala();
    public void afisareAngajati();
    public void afisareClienti();
    public void adaugareAngajat(Angajat c);
    public void adaugareClient(Client c);
    public Client getClient(int i);
    public void afisareTot();
    public Vector<Client> getVector_clienti();
    public void detaliiSucursalaCSV(FileWriter csv,FileWriter audit) throws Exception;
    public void citesteSucursalaFis(Scanner sc,FileWriter audit) throws Exception;
    
}
