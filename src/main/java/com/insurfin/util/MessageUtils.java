package com.insurfin.util;

import org.springframework.context.MessageSource;

import java.util.Locale;


public class MessageUtils {

    public static String getMessages(MessageSource messageSource,String name) {
        return getMessages(messageSource, null, name);
    }

    public static String getMessages(MessageSource messageSource,Object[] args,String name) {
        if(messageSource!=null)
            return messageSource.getMessage(name, args, Locale.getDefault());
        return ApplicationConstants.EMPTY;
    }

    public MessageUtils() {

    }
}
