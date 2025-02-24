package metier;

import DAO.IDAO;

public class metierIMP implements metier {
    private IDAO dao=null;

    @Override

    public double calcul(){

        double t=dao.getdata();
        double res=t*23;
        return res;
    }

    public void setDAO(){
          this.dao=dao;

    }

}
