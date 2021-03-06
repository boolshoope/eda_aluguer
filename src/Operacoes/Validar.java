
package Operacoes;
import Objectos.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Validar {
     BufferedReader x  = new BufferedReader(new InputStreamReader(System.in));
    
     
       
    public byte validarByte(byte a, byte b, String s)throws IOException{
        byte num = 0;
        System.out.println(s);
        do{
            try{
                 num = Byte.parseByte(x.readLine());
            }
            catch(NumberFormatException  exx){
            System.out.println("Numero inesperado Introduza novamente.");
            }
            if(num < a || num > b){
                System.out.println("Invalido. Introduza novamente.");
            }
        }while(num < a || num > b); 
        return num;
    }
    
    public String validarString(int a, int b, String s) throws IOException {
        String nome = "";
        System.out.println(s);
        do{
            try{
                nome = x.readLine();
            }catch(NumberFormatException  exx){
                System.out.println("Entrada inesperada Introduza novamente.");
            }
            
            if(nome.length() < a ||nome.length() > b){
                System.out.println("Invalido. Introduza novamente.");
            }
        }while(nome.length() < a ||nome.length() > b);
        return nome;
   }
    
   public int validarInt(int a, int b, String s)throws IOException{
        int i = 0;
        System.out.println(s);
        do{
            try{
                 i = Integer.parseInt(x.readLine());
            }
            catch(NumberFormatException  xx){
                System.out.println("Entrada inesperada. Introduza novamente.");
            }
            if(i < a || i > b){
                System.out.println("Invalido. Introduza novamente.");
            }
        }while(i < a || i > b); 
        return i;
    }
   
    public char validarChar(char a, char b, String c) throws IOException{
         char n = ' ';
         System.out.println(c);
         do{
             try{
                n = x.readLine().charAt(0);
            }catch(NumberFormatException  exx){
                System.out.println("Numero inesperado Introduza novamente.");
            }
            if(n != a && n != b){
                System.out.println("Invalido, introduza novamente... ");
            }
        }while(n != a && n != b); 
        return n;
    }
    
    
     public double validarDouble(double a, double b, String s)throws IOException{
       double i = 0;
        System.out.println(s);
        do{
            try{
                 i = Double.parseDouble(x.readLine());
            }
            catch(NumberFormatException  xx){
                System.out.println("Entrada inesperada. Introduza novamente.");
            }
            if(i < a || i > b){
                System.out.println("Invalido. Introduza novamente.");
            }
        }while(i < a || i > b); 
        return i;
    }
    
    
   public Date validarData(String t) throws IOException, ParseException{
       
        String data; 
        int dia, mes, ano;
 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");     
                        
        System.out.println(t);
        dia = validarInt(1,31,"Introduza o Dia:  ");
        mes = validarInt(1,12,"Introduza o Mes (O numero correspondente:   ");
        ano = validarInt(2020, 2022,"Introduza o Ano:  ");
        
        Calendar d = new GregorianCalendar(ano, mes-1, dia, 0,0,0);
        Date dataa = d.getTime();      
        data = sdf.format(dataa);
        
        
        return sdf.parse(data);
    }
   
    
    public int validarID(listaLigada lista, String tipo) throws IOException{
        int id = 0; boolean ex = false; byte opcao = 0;
        
        switch (tipo){
            case "a":
                Automovel a;
                do{
                    id = validarInt(0, 999, "Identificacao do Automovel: ");
                    for (int i = 0; i < lista.getSize(); i++){
                        a = (Automovel) lista.getElemento(i).getInfo();
                        if (a.getIdAutomovel() == id){
                            ex = true;
                            return id;
                        }
                    }  
                    
                    if(ex == false){
                        opcao = validarByte((byte)0, (byte)1,"\nAutomovel Nao Identificado."+
                                                              "\n1. Introduzir Novamente"+
                                                               "\n0. Cancelar Procedimento");  
                                            
                    if(opcao == 0)
                        return 0;
                    
                    }
                    
                    
                }while (ex == false && opcao == 1);
               break;
            
            case "c":
                Cliente c;
                do{
                    id = validarInt(0, 999, "Identificacao do Cliente: ");
                    for (int i = 0; i < lista.getSize(); i++){
                        c = (Cliente) lista.getElemento(i).getInfo();
                        if (c.getIdCliente() == id){
                            ex = true;
                            return id;
                        }
                    }
                        if(ex == false){
                            opcao = validarByte((byte)0, (byte)1,"Cliente Nao Identificado."+
                                                                  "\n1. Introduzir Novamente"+
                                                                  "\n0. Cancelar Procedimento");
                            if (opcao == 0)
                                return 0;
                        }
                }while (ex == false && opcao == 1);
                break;
             
            case "al":
                Aluguer al;
                do{
                    id = validarInt(0, 999, "Identificacao do Aluguer: ");
                    for (int i = 0; i < lista.getSize(); i++){
                        al = (Aluguer) lista.getElemento(i).getInfo();
                        if (al.getIdAluguer() == id){
                            ex = true;
                            return id;
                        }
                    }
                        if(ex == false){
                            opcao = validarByte((byte)0, (byte)1,"Aluguer Nao Identificado."+
                                                                  "\n1. Introduzir Novamente"+
                                                                  "\n0. Cancelar Procedimento");
                            if (opcao == 0)
                                return 0;
                        }
                }while (ex == false && opcao ==1);
                break;
        }
        
       return id;
    }

    
   
    
}    

