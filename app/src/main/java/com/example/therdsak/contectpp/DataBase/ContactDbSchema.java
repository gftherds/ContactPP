package com.example.therdsak.contectpp.DataBase;

/**
 * Created by Therdsak on 8/9/2016.
 */
public class ContactDbSchema {
    public static final class ContactTable {
        public static final String NAMEDB = "contacts";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String NAME = "name";
            public static final String NUMBER_PHONE = "numberphone";
            public static final String EMAIL = "email";
        }
    }
}
