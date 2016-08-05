package br.gov.tcu.bbt.dica201;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Client {

    @Autowired
    private ServiceOne serviceOne;

    @Autowired
    private ServiceTwo serviceTwo;

    @SuppressWarnings("unused")
    public void stuff() {
        System.out.println("" + serviceOne + serviceTwo);
    }

}
