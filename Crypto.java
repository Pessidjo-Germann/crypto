package crypto;

/**
 * @author Pessidjo Germann !!!
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Map;

public class Crypto{
   
    public static void main(String[] args){

        

        Scanner sc = new Scanner(System.in);
        int bye;
        Scanner so = new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<Integer>();
        ArrayList<Integer>list_a=new ArrayList<Integer>();
        ArrayList<Integer>list_b=new ArrayList<Integer>();
        ArrayList<Integer>list_c=new ArrayList<Integer>();
        ArrayList<Integer> list_decrypte=new ArrayList<Integer>();
         ArrayList<String> list_2=new ArrayList<String>();
        Map<String,Integer> keyWords_with_letter=new Hashtable<>();
        keyWords_with_letter.put("a",0);
        keyWords_with_letter.put("b",1);
        keyWords_with_letter.put("c",2);
        keyWords_with_letter.put("d",3);
        keyWords_with_letter.put("e",4);
        keyWords_with_letter.put("f",5);
        keyWords_with_letter.put("g",6);
        keyWords_with_letter.put("h",7);
        keyWords_with_letter.put("i",8);
        keyWords_with_letter.put("j",9);
        keyWords_with_letter.put("k",10);
        keyWords_with_letter.put("l",11);
        keyWords_with_letter.put("m",12);
        keyWords_with_letter.put("n",13);
        keyWords_with_letter.put("o",14);
        keyWords_with_letter.put("p",15);
        keyWords_with_letter.put("q",16);
        keyWords_with_letter.put("r",17);
        keyWords_with_letter.put("s",18);
        keyWords_with_letter.put("t",19);
        keyWords_with_letter.put("u",20);
        keyWords_with_letter.put("v",21);
        keyWords_with_letter.put("w",22);
        keyWords_with_letter.put("x",23);
        keyWords_with_letter.put("y",24);
        keyWords_with_letter.put("z",25);
        
        
Map<Integer,String> keyWords_with_number=new Hashtable<>();
        keyWords_with_number.put(0,"a");
        keyWords_with_number.put(1,"b");
        keyWords_with_number.put(2,"c");
        keyWords_with_number.put(3,"d");
        keyWords_with_number.put(4,"e");
        keyWords_with_number.put(5,"f");
        keyWords_with_number.put(6,"g");
        keyWords_with_number.put(7,"h");
        keyWords_with_number.put(8,"i");
        keyWords_with_number.put(9,"j");
        keyWords_with_number.put(10,"k");
        keyWords_with_number.put(11,"l");
        keyWords_with_number.put(12,"m");
        keyWords_with_number.put(13,"n");
        keyWords_with_number.put(14,"o");
        keyWords_with_number.put(15,"p");
        keyWords_with_number.put(16,"q");
        keyWords_with_number.put(17,"r");
        keyWords_with_number.put(18,"s");
        keyWords_with_number.put(19,"t");
        keyWords_with_number.put(20,"u");
        keyWords_with_number.put(21,"v");
        keyWords_with_number.put(22,"w");
        keyWords_with_number.put(23,"x");
        keyWords_with_number.put(24,"y");
        keyWords_with_number.put(25,"z");
         String[] word;

    do
    {
       menu1();
    int resp=sc.nextInt();
    if(resp==1)
    {
        menu2();
        int resp1=sc.nextInt();
        if(resp1==1)
        {
            word =textToArray(so);
            int key=sc.nextInt(); 
            /**
             * ici je transforme les lettres obtenues en chiffres
             */
            letterToInteger(word,list,keyWords_with_letter);
            /**
             * J'applique la formule de césar
             */
            for(int i=0;i<list.size();i++)
            {
                int pass_value=list.get(i);
               int value_change = (pass_value-key)%26;
              list_decrypte.add(value_change);
            }
            
            /**
             * ici je transforme mes chiffres obtenus en lettres
             */
            integerToLetter(list_2,list_decrypte,list,keyWords_with_number);
           
           lireList(list_2);
            list_2.clear();
            list.clear();
            list_decrypte.clear();

        }else
        {
            //ici on doit crypter la phrase
         
            word =textToArray(so);
            
           
            int key=sc.nextInt(); 

            letterToInteger(word,list,keyWords_with_letter);
            
            /**
             * J'applique la formule de césar
             */
            for(int i=0;i<list.size();i++)
            {
                int pass_value=list.get(i);
               int value_change = (pass_value+key)%26;
              list_decrypte.add(value_change);
            }
            
            /**
             * ici je transforme mes chiffres obtenus en lettres
             */
            integerToLetter(list_2,list_decrypte,list,keyWords_with_number);
            
           
           lireList(list_2);
            list_2.clear();
            list.clear();
            list_decrypte.clear();
        
        }
    }else if(resp==2)
    {
        menu2();
        int resp1=sc.nextInt();
        if(resp1==1)
        {
            //on parle de decryptage
               //recuperation du texte a crypter 
            word=textToArrayVigenere(so);
            System.out.print("Combien d'élément possède la clé ");
            int j=0;//itterateur
            int key_lentgh=sc.nextInt();
            ArrayList<Integer> key_list=new ArrayList<Integer>();
            //recupere la clé de vigenere
            for(int i=0;i<key_lentgh;i++)
            {
                System.out.print("Entrez l'élement " + i + " de la clé : ");
                int key_change=sc.nextInt();
                key_list.add(key_change);
            } 
            
            //transforme les mots en chiffres
            letterToInteger(word,list,keyWords_with_letter);

            for(int i=0;i<list.size();i++)
            {
                int pass_value=list.get(i);
                int key_value=key_list.get(j);
               int value_change = (pass_value-key_value)%26;
              list_decrypte.add(value_change);
              j=(j+1)%key_lentgh;
            }

            integerToLetter(list_2,list_decrypte,list,keyWords_with_number);
            lireList(list_2);
            list_2.clear();
            key_list.clear();
            list.clear();
            list_decrypte.clear();
        }else
        {
            //on carle de cryptage
            //recuperation du texte a crypter 
            word=textToArrayVigenere(so);
            System.out.print("Combien d'élément possède la clé ");
            int j=0;//itterateur
            int key_lentgh=sc.nextInt();
            ArrayList<Integer> key_list=new ArrayList<Integer>();
            //recupere la clé de vigenere
            for(int i=0;i<key_lentgh;i++)
            {
                System.out.print("Entrez l'élement " + i+1 + " de la clé : ");
                int key_change=sc.nextInt();
                key_list.add(key_change);
            } 
            
            //transforme les mots en chiffres
            letterToInteger(word,list,keyWords_with_letter);


            //de vigenere
            for(int i=0;i<list.size();i++)
            {
                int pass_value=list.get(i);
                int key_value=key_list.get(j);
               int value_change = (pass_value+key_value)%26;
              list_decrypte.add(value_change);
              j=(j+1)%key_lentgh;
            }

              /**
             * ici je transforme mes chiffres obtenus en lettres
             */
            integerToLetter(list_2,list_decrypte,list,keyWords_with_number);
            lireList(list_2);
            list_2.clear();
            key_list.clear();
            list.clear();
            list_decrypte.clear();
        }
    }else if(resp==3)
    {
        System.out.println("Nous sommes dans le chiffrement de RSA");
        System.out.println("Veuillez remplir les informations de la cle publique");
     
        int n,e;
        int p=0;
        int q=0;
        int pi=0;
        System.out.print("entrer le nombre (n): ");
        n=sc.nextInt();
        System.out.print("entrer le nombre (e): ");
        e=sc.nextInt();
       
        //determinons le p et q
       for(int i=1;i<n-1;i++)//je cherche p
       {
          int intermediare=0;
           if(isPremier(i))//si i est premier
            {
                intermediare=i;
            }else{
                continue;
            }
            
            if(n%intermediare==0)//si le n est divisible par intermediaire alors intermediaire est p
            {
                q=n/intermediare;
                p=intermediare;
            }
       }
       
            //calculons P(n)
            pi=(p-1)*(q-1);
            pi=3599;
           int reste=1;
           int quoitient=1;
           //j'ajoute les elements dans la list a
           list_a.add(pi);
           System.out.println();
           list_a.add(1);
           list_a.add(0);
            //j'ajoute les elements dans la list b
            list_b.add(e);
           list_b.add(0);
           list_b.add(1);
           int a=0;
           int b=0;
           int c=0;
           do
            {
                 a=list_a.get(0);
                 b=list_a.get(0);
                quoitient=a/b;
                for(int i=0;i<3;i++)
                {
                    int s=list_b.get(i);
                    list_c.add(s);
                }
                for(int i=0;i<3;i++)
                {
                int b1=list_b.get(i);
                int a1=list_a.get(i);
                int res=a1-quoitient*b1;
                list_b.get(res);
                }
                for(int i=0;i<3;i++)
                {
                    int s=list_c.get(i);
                    list_a.add(s);
                }
                }while(a!=0);

                for(int i=0;i<3;i++)
                {
                    int s=list_b.get(i);
                    System.out.println(s);
                }

          

         //  System.out.println("La valeur de quoitient " +quoitient);
           
           
           
           
       // }
         
        
         menu2();
        int resp2=sc.nextInt();
        if(resp2==1)
        {
          //on dechiffre le message
        }else
        {
            //on crypte le message 
        }
    }
    System.out.println("");
    System.out.print("Voulez-vous recommencer? (Entrer 1 pour rester et 0 pour sortir) ");
    bye=sc.nextInt();

   
}while(bye==1);

    }
   static void menu1()
   {
     System.out.println("***************************************************************");
        System.out.println("                  BIENVENUE DANS MON PROGRAMME");
          System.out.println("***************************************************************");
          System.out.println("1> Cryptographie par César");
          System.out.println("2> Chiffrement par Vigenère");
    System.out.println("3> Cryptographie de RSA");
    System.out.print("Veuillez effectuer un choix, ");
   }

   static void menu2()
   {
      System.out.println("***************************************************************");
        System.out.println("1> Décryper un texte");
        System.out.println("2> Chiffer un texte");
        System.out.print("Veuillez effectuer un choix, ");
   }
   
   /**
    * params: cette fonction transforme toutes les lettres en nombres
    */
   static void letterToInteger(String[] word, ArrayList<Integer> list, Map<String,Integer> keyWords_with_letter)
   {
         for(int i=0;i<word.length;i++)
            { 
               if(keyWords_with_letter.containsKey(word[i]))
               {
                   list.add(keyWords_with_letter.get(word[i]));
               }   
            }
   }

   /**
    * Cette fonction transmet tous les nombres d'une liste en lettres
    */
   static void integerToLetter(ArrayList<String> list_2,ArrayList<Integer> list_decrypte, ArrayList<Integer> list, Map<Integer,String> keyWords_with_number)
   {
         for(int i=0;i<list.size();i++)
            {
                if(keyWords_with_number.containsKey(list_decrypte.get(i)))
                {
                    list_2.add(keyWords_with_number.get(list_decrypte.get(i)));
                }
            }
   }

   static boolean isPremier(int number)
   {
     boolean value=true;  
            for(int j=2;j<number-1;j++)
            {
                if(number==2)
                {
                  value=false;
                  break;    
                }else if(number==3)
                {
                     value=false;
                  break;
                }
               if(number%j==0)
               {
                value=false;
                  break;
               }else{
                value=true;
               }
            }
       return value;     
   }


   /**
    * @params: Scanner so pour lire l'entrée du clavier
    */

   static String[] textToArray(Scanner so)
   {
    System.out.print("Veuillez entrer le texte a encoder ");
    String text=so.nextLine();
    String text_final=text.toLowerCase();
    String[] ors = text_final.split("");
            System.out.print("veuillez entrer la clé de décallage ");
            return ors;
   }

   static String[] textToArrayVigenere(Scanner so)
   {
    System.out.print("Veuillez entrer le texte a encoder ");
    String text=so.nextLine();
    String text_final=text.toLowerCase();
    String[] ors = text_final.split("");
            return ors;
   }
   
   static void lireList(ArrayList<String> liste)
   {
      for(int i=0;i<liste.size();i++)
            {
                System.out.print(liste.get(i));
            }
   }
   
}