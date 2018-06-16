package fr.acos.parsejsonwithkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.json.JSONException
import org.json.JSONArray
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        val json = "{'Pays':" +
                "['France'," +
                "'Afrique du sud'," +
                "'Burkina Faso'," +
                "'Irlande'," +
                "'Portugal'," +
                "'Suisse']}"

            val jObject = JSONObject(json)
            val jArrayPays = jObject.getJSONArray("Pays")

            for (i in 0 until jArrayPays.length())
            {
                Log.i("XXX", "Valeur à l'index $i = ${jArrayPays.get(i)}")
            }

        val tableauDObjets = "[{'Designation':'ROADSTER','ModeleCommercial':'ROADSTER','CNIT':'M10TSLVP000C002','Id':41124,'ModeleDossier':'ROADSTER'},{'Designation':'ROADSTER','ModeleCommercial':'ROADSTER','CNIT':'M10TSLVP000D003','Id':41125,'ModeleDossier':'ROADSTER'}]";

        val array = JSONArray(tableauDObjets);
        Log.i("XXX","Nombre d'objet dans le tableau : " + array.length());

        for(i in 0 until array.length())
        {
                Log.i("XXX","---------------------------------------");
                val objet = array.getJSONObject(i);
                Log.i("XXX","Contenu de l'objet numéro  :  $i  : ${objet.toString()}");
                Log.i("XXX","Désignation de la voiture : ${objet.get("Designation")}");
                Log.i("XXX","Modele commercial de la voiture : ${objet.get("ModeleCommercial")}");
                Log.i("XXX","CNIT de la voiture : ${objet.get("CNIT")}");
                Log.i("XXX","Id de la voiture : ${objet.get("Id")}");
                Log.i("XXX","Modele dossier de la voiture : ${objet.get("ModeleDossier")}");
                Log.i("XXX","---------------------------------------");
        }


    }
}
