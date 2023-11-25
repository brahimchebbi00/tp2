package com.tp2.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CompteService extends Remote {

    void debiter(double montant) throws RemoteException;

    void crediter(double montant) throws RemoteException;

    double lire_solde() throws RemoteException;

}