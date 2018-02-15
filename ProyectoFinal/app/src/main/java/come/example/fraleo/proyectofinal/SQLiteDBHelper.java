package come.example.fraleo.proyectofinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "clientes";
    private static final int DATABASE_VERSION = 5;

    public static final String TABLE_NAME = "profile";
    public static final String COLUMN_ID =  "userid";
    public static final String COLUMN_FULLNAME =  "fullname";
    public static final String COLUMN_EMAIL =  "email";
    public static final String COLUMN_PASSWORD =  "password";
    public static final String COLUMN_MOBILE =  "mobile";

    public static final String TABLE_NAME_2 = "juego";
    public static final String COLUMN_ID_2 =  "juegoid";
    public static final String COLUMN_NAME =  "nombre";
    public static final String COLUMN_DES =  "descripcion";
    public static final String COLUMN_PRE =  "precio";
    public static final String COLUMN_IMG =  "imagen";

    public static final String TABLE_NAME_3 = "factura";

    public static final String COLUMN_ID_3 =  "facturaid";
    public static final String COLUMN_COM_ID =  "compradorid";
    public static final String COLUMN_GAME_ID =  "juegoid";

    public static final String COLUMN_GAME_NAME =  "nombre_juego";
    public static final String COLUMN_GAME_PRICE =  "precio_juego";
    public static final String COLUMN_COM_NAME =  "nombre_comprador";
    public static final String COLUMN_COM_EMAIL =  "email_comprador";


    private static final String CREATE_TABLE_QUERY =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FULLNAME + " TEXT, "+
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT, " +
                    COLUMN_MOBILE + " TEXT " + ")";

    private static final String CREATE_TABLE_JUEGO =
            "CREATE TABLE " + TABLE_NAME_2+ " (" +
                    COLUMN_ID_2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, "+
                    COLUMN_DES + " TEXT, " +
                    COLUMN_PRE + " INTEGER, " +
                    COLUMN_IMG + " INTEGER " + ")";

    private static final String CREATE_TABLE_FACTURA =
            "CREATE TABLE " + TABLE_NAME_3+ " (" +
                    COLUMN_ID_3 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_COM_ID + " INTEGER, "+
                    COLUMN_GAME_ID + " INTEGER, " +
                    COLUMN_GAME_NAME + " TEXT, " +
                    COLUMN_GAME_PRICE+" INTEGER, "+
                    COLUMN_COM_NAME+" TEXT, "+
                    COLUMN_COM_EMAIL + " TEXT, "+
                    "FOREIGN KEY ("+COLUMN_GAME_ID +") REFERENCES "+TABLE_NAME_2+" ("+COLUMN_ID_2 +"),"+
                    "FOREIGN KEY ("+COLUMN_COM_ID +") REFERENCES "+TABLE_NAME+" ("+COLUMN_ID +"));";



    public SQLiteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_QUERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_JUEGO);
        sqLiteDatabase.execSQL(CREATE_TABLE_FACTURA);

        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_NAME_2 + " ('nombre','descripcion','precio','imagen') VALUES" +
                "('God of war','Olympus',15," + R.drawable.juego1 + ")," +
                "('Ben 10','Cosmic destuction',30,"+ R.drawable.juego2 +")," +
                "('Grand theft auto','San Andreas',20,"+ R.drawable.juego3 +")" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_2);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_3);
        onCreate(sqLiteDatabase);
    }

    public void close(){
        this.close();
    }


}
