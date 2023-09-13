package com.ibm.captor;

public interface DeliveryPlatform {

    void deliver(Email email);

    String getServiceStatus();

    AuthenticationStatus authenticate(Credentials credentials);
}