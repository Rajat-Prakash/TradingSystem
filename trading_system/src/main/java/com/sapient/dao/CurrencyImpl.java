package com.sapient.dao;

import com.sapient.exceptions.BankNameException;
import com.sapient.facades.CurrencyFacade;
import com.sapient.models.Bank;
import com.sapient.models.Currency;
import com.sapient.models.Symbol;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Data
public class CurrencyImpl implements CurrencyFacade {
    private List<Currency>currencyData = new ArrayList<>();
    private File file;
    public CurrencyImpl(String fileName) throws IOException {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("db");
        String path=resourceBundle.getString("location");
        this.file = new File(path,fileName);
        if(file.exists()){
            getAllCurrencyData();
        }
        else
        {
            if(file.createNewFile())
                getAllCurrencyData();
        }
    }

    @Override
    public boolean addCurrency(Currency currency) throws IOException {
        this.currencyData.add(currency);
        if(file.exists()){
            updateData();
        }
        else
        {
            if(file.createNewFile())
                updateData();
        }
        return true;
    }

    @Override
    public boolean editCurrency(int id, Currency currency) throws IOException {
        for(int i=0; i<this.currencyData.size(); i++){
            if(this.currencyData.get(i).getCurrencyId() == id){
                    this.currencyData.set(i,currency);
            }
        }
        if(file.exists()){
            updateData();
        }
        else
        {
            if(file.createNewFile())
                updateData();
        }
        return true;
    }

    @Override
    public boolean deleteCurrency(int id) throws IOException {
        for(int i=0; i<this.currencyData.size(); i++){
            if(this.currencyData.get(i).getCurrencyId() == id){
                this.currencyData.remove(i);
                break;
            }
        }
        if(file.exists()){
            updateData();
        }
        else
        {
            if(file.createNewFile())
                updateData();
        }
        return true;
    }

    private void updateData() throws IOException {
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fw)) {
            for(Currency c:this.currencyData){
                bufferedWriter.write(String.valueOf(c.getCurrencyId())+',');
                bufferedWriter.write(c.getCurrencyDescription()+",");
                bufferedWriter.write(String.valueOf(c.getCurrencyCode())+',');
                bufferedWriter.write(c.getCurrencySymbol()+",");
                bufferedWriter.write(c.getCountryUsingCurrency()+"\n");
            }
        }
    }

    private void getAllCurrencyData() throws IOException {
        String line=null;
        String[] fields=null;
        try (FileReader fw = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fw)) {
            while((line=bufferedReader.readLine())!=null){
                fields = line.split(",");
                Currency currency = new Currency(Integer.parseInt(fields[0]),fields[1],Integer.parseInt(fields[2]),Symbol.valueOf(fields[3]),fields[4]);
                this.currencyData.add(currency);
            }
        }
    }
}
