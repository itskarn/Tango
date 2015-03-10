package com.sb.app;

import android.provider.BaseColumns;

/**
 * Created by Chandan on 3/8/15.
 */
public class DbData {
    public DbData(){}

    public static abstract class DbInfo implements BaseColumns
    {
        public static  final String DB_NAME="tango_db";
        public static final String TABLE_NAME="tango_table";
        public static final String USER_NAME="user_name";
        public static final String PASS_WORD="pass_word";
    }

}
