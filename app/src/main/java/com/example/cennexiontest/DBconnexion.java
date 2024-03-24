package com.example.cennexiontest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBconnexion extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Connexion";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_INSCRIPTION = "INSCRIPTION";
    private static final String TABLE_ANNONCE = "ANNONCE";

    private static final String CREATE_TABLE1 = "CREATE TABLE inscription (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Email TEXT," +
            "motDePasse TEXT);";
    private static final String CREATE_TABLE = "CREATE TABLE annonce (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "titre TEXT," +
            "categorie TEXT," +
            "secteur TEXT," +
            "typecontrat TEXT," +
            "ville TEXT);";

    public DBconnexion(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE1);
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Gestion des mises à jour de la base de données
        db.execSQL("DROP TABLE IF EXISTS inscription");
        db.execSQL("DROP TABLE IF EXISTS annonce");
        onCreate(db);
    }

    // Méthode pour compter le nombre d'annonces dans une ville donnée
    public int countAnnoncesByVille(String ville) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {"COUNT(*)"};
        String selection = "ville=?";
        String[] selectionArgs = {ville};
        Cursor cursor = db.query("annonce", projection, selection, selectionArgs, null, null, null);
        int count = 0;
        if (cursor != null) {
            cursor.moveToFirst();
            count = cursor.getInt(0);
            cursor.close();
        }
        db.close();
        return count;
}

    // Méthode pour insérer les données dans la table "annonce"
    public long insertInscription(String Email, String motDePasse) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", Email);
        values.put("password", motDePasse);

        long newRowId = db.insert(TABLE_INSCRIPTION, null, values);
        db.close();
        return newRowId;
}
    public long insertAnnonce(String titre, String categorie,String secteur,String typecontrat,String Ville ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("titre", titre);
        values.put("categorie", categorie);
        values.put("secteur", secteur);
        values.put("typecontrat", typecontrat);
        values.put("ville", Ville);

        long newRowId = db.insert(TABLE_ANNONCE, null, values);
        db.close();
        return newRowId;
    }

}
