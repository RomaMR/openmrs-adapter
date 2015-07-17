package org.openmrs.security;

import org.apache.commons.codec.binary.Base64;
import org.openmrs.domain.user.User;

/**
 * Created by romanmudryi on 16.07.15.
 */
public class SecurityUtils {

    public static String getBase64(String login, String password) {
        String authString = login + ":" + password;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String result = new String(authEncBytes);

        return  result;
    }

    public static String getBase64(User user) {
        return getBase64(user.getLogin(), user.getPassword());
    }

}
