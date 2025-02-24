package metier;

import DAO.IDAO;

public interface metier {

    //couplage faible

     public  IDAO dao=null;


      double calcul();


}
