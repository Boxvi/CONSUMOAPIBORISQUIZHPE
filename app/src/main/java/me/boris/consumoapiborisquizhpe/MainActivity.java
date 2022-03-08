package me.boris.consumoapiborisquizhpe;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import me.boris.consumoapiborisquizhpe.model.Vaccines;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> datos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewVaccines);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, datos);

        listView.setAdapter(arrayAdapter);
        obtenerDatos();


    }


    private void obtenerDatos() {
        String url = "https://covid-api.mmediagroup.fr/v1/vaccines?country=Ecuador";


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                pasarJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }

    private void pasarJson(JSONObject jsonObject) {
        try {
            JSONObject jsonObject1 = jsonObject.getJSONObject("All");

            Vaccines vaccines = new Vaccines();

            vaccines.setAdministered(jsonObject1.getInt("administered"));
            vaccines.setPeople_vaccinated(jsonObject1.getInt("people_vaccinated"));
            vaccines.setPeople_partially_vaccinated(jsonObject1.getInt("people_partially_vaccinated"));
            vaccines.setCountry(jsonObject1.getString("country"));
            vaccines.setPopulation(jsonObject1.getInt("population"));
            vaccines.setSq_km_area(jsonObject1.getInt("sq_km_area"));
            vaccines.setLife_expectancy(jsonObject1.getString("life_expectancy"));
            vaccines.setElevation_in_meters(jsonObject1.getString("elevation_in_meters"));
            vaccines.setContinent(jsonObject1.getString("continent"));
            vaccines.setAbbreviation(jsonObject1.getString("abbreviation"));
            vaccines.setLocation(jsonObject1.getString("location"));
            vaccines.setIso(jsonObject1.getInt("iso"));
            vaccines.setCapital_city(jsonObject1.getString("capital_city"));
            vaccines.setUpdated(jsonObject1.getString("updated"));


            datos.add("Administrado: " + vaccines.getAdministered() + ".");
            datos.add("Personas vacunadas: " + vaccines.getPeople_vaccinated() + "");
            datos.add("Personas participantes: " + vaccines.getPeople_partially_vaccinated() + "");
            datos.add("Pais: " + vaccines.getCountry());
            datos.add("Capital: " + vaccines.getCapital_city());
            datos.add("Continente: " + vaccines.getContinent());
            datos.add("Abreviacion: " + vaccines.getAbbreviation());
            datos.add("Actualizacion: " + vaccines.getUpdated());

            Log.d("sdas", " " + jsonObject1.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayAdapter.notifyDataSetChanged();

    }

}

/*
            datos.add(vaccines.getPopulation() + "");
            datos.add(vaccines.getSq_km_area() + "");
            datos.add(vaccines.getLife_expectancy());
            datos.add(vaccines.getElevation_in_meters());
            datos.add(vaccines.getIso() + "");
            datos.add(vaccines.getCapital_city());*/


/*
        JSONArray jsonArray = null;
        try {
            jsonArray = jsonObject.getJSONArray("All");

            //JSONObject jArry = jsonObject.getJSONObject("All");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                Vaccines vaccines = new Vaccines();

                vaccines.setAdministered(object.getInt("administered"));
                vaccines.setPeople_vaccinated(object.getInt("people_vaccinated"));
                vaccines.setPeople_partially_vaccinated(object.getInt("people_partially_vaccinated"));

                datos.add(vaccines.getAdministered() + "");
                datos.add(vaccines.getPeople_vaccinated() + "");
                datos.add(vaccines.getPeople_partially_vaccinated() + "");
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

       /* try {
            JSONObject jArry = jsonObject.getJSONObject("All");

            for (int i = 0; i < jArry.length(); i++) {
                JSONObject jsonObjects = jArry.getJSONObject(String.valueOf(i));
                Vaccines vaccines = new Vaccines();

                try {
                    jsonObjects = jArry.getJSONObject(String.valueOf(i));

                    vaccines.setAdministered(jsonObjects.getInt("administered"));
                    vaccines.setPeople_vaccinated(jsonObjects.getInt("people_vaccinated"));
                    vaccines.setPeople_partially_vaccinated(jsonObjects.getInt("people_partially_vaccinated"));
                    vaccines.setCountry(jsonObjects.getString("country"));
                    vaccines.setPopulation(jsonObjects.getInt("population"));
                    vaccines.setSq_km_area(jsonObjects.getInt("sq_km_area"));
                    vaccines.setLife_expectancy(jsonObjects.getString("life_expectancy"));
                    vaccines.setElevation_in_meters(jsonObjects.getString("elevation_in_meters"));
                    vaccines.setContinent(jsonObjects.getString("continent"));
                    vaccines.setAbbreviation(jsonObjects.getString("abbreviation"));
                    vaccines.setLocation(jsonObjects.getString("location"));
                    vaccines.setIso(jsonObjects.getInt("iso"));
                    vaccines.setCapital_city(jsonObjects.getString("capital_city"));
                    vaccines.setUpdated(jsonObjects.getString("updated"));


                    datos.add(vaccines.getAdministered() + "");
                    datos.add(vaccines.getPeople_vaccinated() + "");
                    datos.add(vaccines.getPeople_partially_vaccinated() + "");
                    datos.add(vaccines.getCountry());
                    datos.add(vaccines.getPopulation() + "");
                    datos.add(vaccines.getSq_km_area() + "");
                    datos.add(vaccines.getLife_expectancy());
                    datos.add(vaccines.getElevation_in_meters());
                    datos.add(vaccines.getContinent());
                    datos.add(vaccines.getAbbreviation());
                    datos.add(vaccines.getLocation());
                    datos.add(vaccines.getIso() + "");
                    datos.add(vaccines.getCapital_city());
                    datos.add(vaccines.getUpdated());


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }




        } catch (JSONException e) {
            e.printStackTrace();
        }*/


    /*
    private void pasarJson(JSONArray jsonArray) {



        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = null;
            Vaccines vaccines = new Vaccines();

            try {
                jsonObject = jsonArray.getJSONObject(i);

                vaccines.setAdministered(jsonObject.getInt("administered"));
                vaccines.setPeople_vaccinated(jsonObject.getInt("people_vaccinated"));
                vaccines.setPeople_partially_vaccinated(jsonObject.getInt("people_partially_vaccinated"));
                vaccines.setCountry(jsonObject.getString("country"));
                vaccines.setPopulation(jsonObject.getInt("population"));
                vaccines.setSq_km_area(jsonObject.getInt("sq_km_area"));
                vaccines.setLife_expectancy(jsonObject.getString("life_expectancy"));
                vaccines.setElevation_in_meters(jsonObject.getString("elevation_in_meters"));
                vaccines.setContinent(jsonObject.getString("continent"));
                vaccines.setAbbreviation(jsonObject.getString("abbreviation"));
                vaccines.setLocation(jsonObject.getString("location"));
                vaccines.setIso(jsonObject.getInt("iso"));
                vaccines.setCapital_city(jsonObject.getString("capital_city"));
                vaccines.setUpdated(jsonObject.getString("updated"));


                datos.add(vaccines.getAdministered() + "");
                datos.add(vaccines.getPeople_vaccinated() + "");
                datos.add(vaccines.getPeople_partially_vaccinated() + "");
                datos.add(vaccines.getCountry());
                datos.add(vaccines.getPopulation() + "");
                datos.add(vaccines.getSq_km_area() + "");
                datos.add(vaccines.getLife_expectancy());
                datos.add(vaccines.getElevation_in_meters());
                datos.add(vaccines.getContinent());
                datos.add(vaccines.getAbbreviation());
                datos.add(vaccines.getLocation());
                datos.add(vaccines.getIso() + "");
                datos.add(vaccines.getCapital_city());
                datos.add(vaccines.getUpdated());


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        arrayAdapter.notifyDataSetChanged();

    }


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                    pasarJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //manear error en caso de problema
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });*/
//pasamos la peticion del ws a ala cola del vollwey
