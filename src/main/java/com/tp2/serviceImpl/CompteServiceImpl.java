package com.tp2.serviceImpl;

import com.tp2.service.CompteService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@Service
public class CompteServiceImpl extends UnicastRemoteObject implements CompteService, Serializable {
    private double solde;

    public CompteServiceImpl() throws RemoteException {
        super();
        this.solde = 0;
    }

    @Override
    public void debiter(double montant) throws RemoteException {
        if (montant > this.solde) {
            throw new RuntimeException("Solde insuffisant");
        }

        this.solde -= montant;
    }

    @Override
    public void crediter(double montant) throws RemoteException {
        this.solde += montant;
    }

    @Override
    public double lire_solde() throws RemoteException {
        return this.solde;
    }

}
