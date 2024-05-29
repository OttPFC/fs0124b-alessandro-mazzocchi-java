package org.example;

import org.example.adapter.DataSource;
import org.example.adapter.Info;
import org.example.adapter.InfoAdapter;

import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Info info = new Info("Mario", "Rossi", new Date(90, 5, 15));
        DataSource dataSource = new InfoAdapter(info);
        System.out.println("Nome Completo: " + dataSource.getNomeCompleto());
        System.out.println("Età: " + dataSource.getEta());
    }
}