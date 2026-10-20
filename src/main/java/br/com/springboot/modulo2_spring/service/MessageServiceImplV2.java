package br.com.springboot.modulo2_spring.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("v2")
public class MessageServiceImplV2 implements IMessageService{

    @Override
    public String getCustomMessage(String originalMessage) {
        return "-"
                .concat(originalMessage.toUpperCase())
                .concat("-");
    }

}
