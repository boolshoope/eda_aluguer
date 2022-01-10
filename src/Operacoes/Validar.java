
package Operacoes;
import Objectos.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.LinkedList;

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
        System.out.println(t);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
        cal.set(Calendar.DAY_OF_MONTH, validarInt(1,31,"Introduza o Dia:  "));
        cal.set(Calendar.MONTH, validarInt(1,12,"Introduza o Mes (O numero correspondente):  "));
        cal.set(Calendar.DAY_OF_YEAR,validarInt(2020, 2021,"Introduza o Ano:  "));     
        
        data  = sdf.format(cal);
        Date d = sdf.parse(data);
        
        return d;
    }
    
    public int validarID(LinkedList lista, String tipo) throws IOException{
        int id = 0; boolean ex = false; byte opcao;
        
        switch (tipo){
            case "a":
                Automovel a;
                do{
                    id = validarInt(100, 999, "Identificacao do Automovel: ");
                    for (int i = 0; i < lista.size(); i++){
                        a = (Automovel) lista.get(i);
                        if (a.getIdAutomovel() == id){
                            ex = true;
                            return id;
                        }
                        if((i == lista.size() - 1) && ex == false){
                            opcao = validarByte((byte)0, (byte)1,"Automovel Nao Identificado."+
                                                                  "\n1. Introduzir Novamente"+
                                                                  "\n0. Cancelar Procedimento");
                            if (opcao == 0)
                                return 0;
                        }
                    }
                }while (ex == false);
                break;
            
            case "c":
                Cliente c;
                do{
                    id = validarInt(100, 999, "Identificacao do Cliente: ");
                    for (int i = 0; i < lista.size(); i++){
                        c = (Cliente) lista.get(i);
                        if (c.getIdCliente() == id){
                            ex = true;
                            return id;
                        }
                        if((i == lista.size() - 1) && ex == false){
                            opcao = validarByte((byte)0, (byte)1,"Cliente Nao Identificado."+
                                                                  "\n1. Introduzir Novamente"+
                                                                  "\n0. Cancelar Procedimento");
                            if (opcao == 0)
                                return 0;
                        }
                    }
                }while (ex == false);
                break;
             
            case "al":
                Aluguer al;
                do{
                    id = validarInt(100, 999, "Identificacao do Aluguer: ");
                    for (int i = 0; i < lista.size(); i++){
                        al = (Aluguer) lista.get(i);
                        if (al.getIdAluguer() == id){
                            ex = true;
                            return id;
                        }
                        if((i == lista.size() - 1) && ex == false){
                            opcao = validarByte((byte)0, (byte)1,"Aluguer Nao Identificado."+
                                                                  "\n1. Introduzir Novamente"+
                                                                  "\n0. Cancelar Procedimento");
                            if (opcao == 0)
                                return 0;
                        }
                    }
                }while (ex == false);
                break;
        }
        
       return id;
    }

    
   
    
}    

