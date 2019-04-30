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
public interface ServiciiAngajat {
    
    public void detaliiAngajat();
    public void citesteAngajat();
    public void afisareTot();
    public void citesteAngajatFis(Scanner sc,FileWriter audit)throws Exception;
    public void detaliiAngajatCSV(FileWriter csv,FileWriter audit) throws Exception;
    
}
