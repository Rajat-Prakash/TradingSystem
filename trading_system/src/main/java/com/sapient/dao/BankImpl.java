package com.sapient.dao;

import com.sapient.exceptions.BankNameException;
import com.sapient.facades.BankFacade;
import com.sapient.models.Bank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BankImpl implements BankFacade {
    private File file;
    private List<Bank>bankData=new ArrayList<>();
    public BankImpl(String fileName) throws IOException {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("db");
        String path=resourceBundle.getString("location");
        this.file =new File(path,fileName);
        if(file.exists()){
            getAllBankData();
        }
        else
        {
            if(file.createNewFile())
                updateData();
        }
    }

    @Override
    public boolean addBank(Bank bank) throws IOException {
        this.bankData.add(bank);
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
    public boolean editBank(Bank bank,String name) throws BankNameException, IOException {
        for(int i=0; i<this.bankData.size(); i++){
            if(this.bankData.get(i).getBankName().equals(name)){
                if(bank.getBankName().equals(this.bankData.get(i).getBankName())){
                    this.bankData.set(i,bank);
                }
                else{
                    throw new BankNameException("Cannot change Bank name");
                }
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
    public boolean deleteBank(String name) throws IOException {
        for(int i=0; i<this.bankData.size(); i++){
            if(this.bankData.get(i).getBankName().equals(name)){
                this.bankData.remove(i);
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

            for(Bank b:this.bankData){
                bufferedWriter.write(b.getBankId()+',');
                bufferedWriter.write(b.getBankName()+',');
                bufferedWriter.write(b.getNostroAccountInformation()+",");
                bufferedWriter.write(b.getDeskCode()+',');
                bufferedWriter.write(b.getTreasuryInformation()+"\n");
            }
        }
    }
    private void getAllBankData() throws IOException {
        String line=null;
        String[] fields=null;
        try (FileReader fw = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fw)) {
            while ((line = bufferedReader.readLine()) != null) {
                fields = line.split(",");
                Bank bank = new Bank(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]),Integer.parseInt(fields[3]), fields[4]);
                this.bankData.add(bank);
            }
        }
    }
}
