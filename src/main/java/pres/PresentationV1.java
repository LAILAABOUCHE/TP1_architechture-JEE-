package pres;
import DAO.daoIMPL;
import  metier.metierIMP;

import static metier.metier.dao;

public class PresentationV1 {

     public static void main(String[]args){

         daoIMPL d= new daoIMPL();
         metierIMP metier= new metierIMP();
         metier.setDAO(d);
         System.out.println("RES=" +metier.calcul());
     }


}
