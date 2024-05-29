package org.example.adapter;

import java.time.LocalDate;
import java.time.ZoneId;

public class InfoAdapter implements DataSource{

    private Info info;

    public InfoAdapter(Info info){
        this.info = info;
    }

    @Override
    public String getNomeCompleto(){
        return info.getNome() + " " + info.getCognome();
    }

    @Override
    public int getEta() {
        LocalDate localDate = this.info.getDataDiNascita().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return LocalDate.now().getYear() - localDate.getYear();
    }
}
