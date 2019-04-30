/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vasua
 */
public class MainFis {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\Andra_Drive\\C++_programe\\An2_Sem2\\PAO\\ProiectBanca copie\\in.txt");
        Scanner in;
    
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("Eroare fisier"+ex.getMessage());
            throw new Exception("Scanner negasit");
            
        }
        FileWriter audit;
        
        try {
            audit = new FileWriter("D:\\Andra_Drive\\C++_programe\\An2_Sem2\\PAO\\ProiectBanca copie\\audit.txt",true);
        } 
        catch (IOException ex) {
            System.out.println("Eroare fisier audit"+ex.getMessage());
            throw new Exception("Audit negasit");
        }
        
        FileWriter csv;
        try {
            csv = new FileWriter("D:\\Andra_Drive\\C++_programe\\An2_Sem2\\PAO\\ProiectBanca copie\\csv.txt");
        } 
        catch (IOException ex) {
            System.out.println("Eroare fisier csv"+ex.getMessage());
            throw new Exception("Csv negasit");
        }
        
        Sucursala s;
        Client c;
        Angajat a;
        Cont cont;
        Card card;
        Credit cr;
        Rata r;
        try{
            
        
        s=new Sucursala();
        s.citesteSucursalaFis(in, audit);
        
        
        for(int i=0;i<1;i++)//angajati
        {
            a=new Angajat();
            a.citesteAngajatFis(in,audit);
            s.adaugareAngajat(a);    
        }
        
        for(int i=0;i<1;i++) //clienti
         {   
            c=new Client();
            c.citesteClientFis(in,audit);
            s.adaugareClient(c);
            
            
            for(int k=0;k<1;k++)//conturile clientului i
            {   
                cont=new Cont();
                cont.citesteContFis(in,audit);
                c.adaugareCont(cont);
                
                for(int j=0;j<1;j++)//cardurile conutului k
                {
                    
                    card=new Card();
                    card.citesteCardFis(in,audit);
                    cont.adaugareCard(card);
                }
                
                for(int j=0;j<1;j++)//creditele conutului k
                {
                
                    cr=new Credit();
                    cr.citesteCreditFis(in,audit);
                    cont.adaugareCredit(cr);
                    
                    for(int m=0;m<1;m++)//ratele creditului j
                    {
                         
                         r=new Rata();
                         r.citesteRataFis(in,audit);
                         cr.adaugareRata(r);


                    } 
                }
           }
         
        }
        //scriere detalii despre sucursala
        s.detaliiSucursalaCSV(csv, audit);
        
        //depune in cont
        //o voi face functie separata cand voi face aplicatia(cu click pe buton)
       long cnp_cl=in.nextLong();
       in.nextLine();
       
       long iban_cl=in.nextLong();
       in.nextLine();
       
       float suma_cl=in.nextFloat();
       in.nextLine();
       
       Vector<Client> vect_cl=s.getVector_clienti();
       
       int k=0,m=0;
       int nr_ct=0;
       
       for(int i=0;i<vect_cl.size();i++)
       {
           if(vect_cl.get(i).getCnp()==cnp_cl)
           {
               k=1;
               c=vect_cl.get(i);
               Cont [] array_ct=c.getArray_conturi();
               nr_ct=c.getNr_conturi();
               
               for(int j=0;j<nr_ct;j++)
                {
                    if(array_ct[j].getIban()==iban_cl)
                    {
                        m=1;
                        cont=array_ct[j];
                        cont.depunere(suma_cl);
                        audit.write("S-a depus suma de "+suma_cl+" in contul cu iban-ul "
                                +iban_cl+"\r\n");
                        cont.detaliiContCSV(csv, audit);
                    }
                }
               
                   
           }
        }
       if(k==0)
       {
           audit.write("Nu exista clientul cu cnp: "+cnp_cl+"\r\n");
           System.out.println("Nu exista clientul cu cnp: "+cnp_cl);
           
           
       }
       else
       {
            if(m==0)
            {
                audit.write("Nu exista contul cu iban-ul "+iban_cl+"\r\n");
                System.out.println("Nu exista contul cu iban-ul "+iban_cl);
                
            }
            
       }

        audit.close();
        csv.close();
        

    }
        catch(IOException ex) {
            System.out.println("Eroare main"+ex.getMessage());
            audit.close();
            csv.close();
            throw new Exception("Eroare main");
        }
    }
}

