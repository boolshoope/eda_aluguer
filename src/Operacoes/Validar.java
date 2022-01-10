
package Operacoes;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

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
    
    
    public String validarData() throws IOException{
        String data; 
        /*int dia, mes, ano;
        dia = validarInt(1,31,"Introduza o Dia:  ");
        mes = validarInt(1,31,"Introduza o mes (O numero correspondente):  ");
        ano = validarInt(2020, 2021,"Introduza o Ano:  ");*/
                
        Date d = new Date();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        DateFormat df = DateFormat.getDateInstance();
        cal.set(Calendar.DAY_OF_MONTH, validarInt(1,31,"Introduza o Dia:  "));
        cal.set(Calendar.MONTH, validarInt(1,12,"Introduza o Mes (O numero correspondente:  "));
        cal.set(Calendar.DAY_OF_YEAR,validarInt(2020, 2021,"Introduza o Ano:  "));     
        
        data  = sdf.format(cal);
        
        //data = dia+"-"+mes+"-"+ano;
        return data;
    }
    
    public String validarHora () throws IOException{
        String horas;
        Date data = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        data.setHours(validarByte((byte)1,(byte)24,"Introduza a Hora:"));
        data.setMinutes(validarByte((byte)0,(byte)60,"Introduza os Minutos:"));
        horas = sdf.format(data);
        return horas;
    }
    
   
    
}    

