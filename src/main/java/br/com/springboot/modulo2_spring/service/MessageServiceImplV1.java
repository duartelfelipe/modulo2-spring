package br.com.springboot.modulo2_spring.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("v1")
public class MessageServiceImplV1 implements IMessageService{

    @Override
    public String getCustomMessage(String originalMessage) {
        return originalMessage.toUpperCase();
    }

}
