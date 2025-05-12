package com.ifsc.contaclick;

import java.util.ArrayList;

public class PlanetaDao {
    ArrayList<Planeta> planetas;
    public PlanetaDao() {//carregar lista de planetas
        this.planetas=new ArrayList<>();
        String [] nomes = new String[] { "Mercurio","Venus", "Marte", "Saturno", "Terra", "Urano", "Netuno", "Júpter"};
        Integer[] imagens=new Integer[]{R.drawable.mercury, R.drawable.venus,R.drawable.mars, R.drawable.saturn,
                R.drawable.earth, R.drawable.uranus, R.drawable.neptune, R.drawable.jupter};
    }

    public ArrayList<Planeta> getPlanetas(){

        return this.planetas;
    }
}
