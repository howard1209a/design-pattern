package com.dyp.facade;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author howard
 * @version 1.0
 */
public class PageMaker {
    private PageMaker() {
    }

    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HtmlWriter htmlWriter = new HtmlWriter(new FileWriter(filename));
            htmlWriter.title("Welcome to " + username + "'s page.");
            htmlWriter.paragraph(username + "欢迎来到" + username + "的主页。");
            htmlWriter.paragraph("等待你的邮件！");
            htmlWriter.mailto(mailaddr, username);
            htmlWriter.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeLinkPage(String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            HtmlWriter htmlWriter = new HtmlWriter(new FileWriter(filename));
            htmlWriter.title("Link page");
            Set<Map.Entry<Object, Object>> set = mailprop.entrySet();
            for (Map.Entry<Object, Object> entry : set) {
                htmlWriter.mailto((String) entry.getKey(), (String) entry.getValue());
            }
            htmlWriter.close();
            System.out.println(filename + " is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
