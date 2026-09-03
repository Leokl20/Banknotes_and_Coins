
import java.util.Scanner;

public class Main{
    public static void main(String[] arg){
        Scanner sc= new Scanner(System.in);

       
        System.out.println("Digite um valor: ");
        double price=sc.nextDouble();

        //teste de valor aceitavel
        if(price<=0){
        System.out.println("Digite um valor positivo! ");
    }else{

        long priceCents = Math.round(price*100);
        
        
         System.out.println("NOTAS: ");  
         long resto = QuantCed(priceCents);
                 
         System.out.println("MOEDAS: ");  
         QuantMoeda(resto);
    

    
}   
    }



    public static long QuantCed(long priceCents){
        //array definido long por causa do math.round pois ele converte de double pra long
         long cedula[] = {10000, 5000, 2000, 1000, 500, 200};

         long qntNotas=0;
     
         for (int i=0; i<cedula.length; i++){
        
          
       qntNotas= priceCents/cedula[i];
            
       // aqui ele atualiza o valor em centavos pra descontar na proxima volta do for
       priceCents=priceCents-(cedula[i]*qntNotas);

       System.out.println("*"+qntNotas+"*" +" NOTA(S) DE R$ "+(cedula[i]/100) );
    
         }
            return priceCents;

    }

     public static void QuantMoeda(long priceCents){
        //Aqui ele segue a mesma lógica da de cima. 

         long Moeda[] = {100, 50, 25, 10, 5, 1};
         //array novo pra guardar os valores das moedas em formato double
         double[] MoedaDouble= new double[6];

         long qntMoedas=0;
     
         for (int i=0; i< Moeda.length; i++){
           
       qntMoedas= priceCents/Moeda[i];
       priceCents=priceCents-(Moeda[i]*qntMoedas);
         // aqui ele faz um math.round e adiciona os valores EM DOUBLE no novo array
        MoedaDouble[i] = Math.round(Moeda[i]);

        //dviide por 100 pra deixar no formato de centavos 0,01
         System.out.println("*"+qntMoedas+"*"+ " MOEDA(S) DE R$ "+MoedaDouble[i]/100);
      
       }
         


    }
}
