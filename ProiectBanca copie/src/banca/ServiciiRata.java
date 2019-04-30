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
public interface ServiciiRata {
    
    public void detaliiRata();
    public void citesteRata();
    public void afisareTot();
    public void detaliiRataCSV(FileWriter csv,FileWriter audit) throws Exception;
    public void citesteRataFis(Scanner sc,FileWriter audit) throws Exception;
    
    
}
