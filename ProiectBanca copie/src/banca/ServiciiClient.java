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
public interface ServiciiClient {
    
    public void detaliiClient();
    public void citesteClient();
    public void afisareConturi();
    public void adaugareCont(Cont c);
    public Cont getCont(int i);
    public void afisareTot();
    public Cont[] getArray_conturi();
    public void citesteClientFis(Scanner sc,FileWriter audit) throws Exception;
    public void detaliiClientCSV(FileWriter csv,FileWriter audit) throws Exception;
    
}
