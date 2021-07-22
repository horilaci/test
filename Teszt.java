package com.teszt;

public class Teszt {

    public static int balancecounter(String s){
        int balance =0;
        for (int i=0;i<s.length();i++) {
        if(s.charAt(i)=='-'){
            balance--;
        }else{
            balance++;
        }
    }
        return balance;
}

    public static int negativitycounter(String s){
        int negativity=0;
        String segedString=s;

        for(int i=0;i<s.length();i++){
            if(balancecounter(segedString)<0){
                negativity++;
            }
            segedString = segedString.substring(0,segedString.length()-1);
        }
        return negativity;
    }

    public static int lesscng(String s,int k){
        int steps=0;

        while (negativitycounter(s) > k) {
            s = s.replaceFirst("-", "+");
            steps++;
        }
        return steps;
    }

    public static void main(String[] args){
        System.out.println("Steps: "+lesscng("---",1));
        System.out.println("Steps: "+lesscng("+-+-",0));
        System.out.println("Steps: "+lesscng("-+-+---",2));
        System.out.println("Steps: "+lesscng("-------++",3));
        System.out.println("Steps: "+lesscng("++--+--+--++++----+",3));
    }
}
