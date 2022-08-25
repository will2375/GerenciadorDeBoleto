package com.gerenciadorDeBoleto.controle.model.controleTipo;

import com.gerenciadorDeBoleto.controle.model.enuns.EnumTipo;

public class ControleTipo {
    
    public EnumTipo decidirTipo(String tipo){
        if (tipo.equalsIgnoreCase("luz")){
            return EnumTipo.LUZ;
        } else if (tipo.equalsIgnoreCase("agua")) {
            return EnumTipo.AGUA;
        } else if (tipo.equalsIgnoreCase("comida")) {
            return EnumTipo.COMIDA;
        } else if (tipo.equalsIgnoreCase("lazer")) {
            return EnumTipo.LAZER;
        }else {
            return EnumTipo.OUTROS;
        }
    }
}
