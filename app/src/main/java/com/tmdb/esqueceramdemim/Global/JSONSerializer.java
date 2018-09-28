package com.tmdb.esqueceramdemim.Global;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class JSONSerializer {
    public static <T> T deserialize(Class<T> classe, JSONObject json) throws InstantiationException, IllegalAccessException
    {
        if (classe!= null){
            T  objeto = classe.newInstance();
            if(json != null)
            {

                Field[] campos = classe.getDeclaredFields();
                for(Field campo : campos )
                {

                    if (Modifier.isStatic(campo.getModifiers()))
                    {
                        // pula staticos
                        continue;
                    }
                    try {
                        campo.setAccessible(true);

                        if(json.optJSONObject(campo.getName())!=null)
                            campo.set(objeto,JSONSerializer.deserialize(campo.getType(), json.getJSONObject(campo.getName())));
                        else if(json.optJSONArray(campo.getName())!=null)
                        {
                            Class<?> parametro = (Class<?>)(((ParameterizedType)campo.getGenericType()).getActualTypeArguments()[0]);
                            ArrayList<Object> array = new ArrayList<Object>();
                            JSONArray jArray  = json.optJSONArray(campo.getName());
                            for(int i =0;i<jArray.length();i++)
                                array.add(JSONSerializer.deserialize(parametro, jArray.getJSONObject(i)));
                            campo.set(objeto, array);
                        }
                        else if(campo.getType() == Date.class)
                        {

                            String dt = json.getString(campo.getName());
                            if(dt.length()>0);{
                            dt = dt.substring(dt.indexOf("(")+1,dt.indexOf("-"));
                            campo.set(objeto, new Date(Long.parseLong(dt)));
                        }


                        }
                        else
                            campo.set(objeto,json.get(campo.getName()));

                    } catch (IllegalArgumentException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();

                    }

                }
                return objeto;
            }else{
                return null;
            }

        }else{
            return null;

        }
    }


    public static <T> JSONObject serialize(Class<T> classe, Object objeto) throws JSONException
    {

        if (classe!= null)
        {
            if(objeto != null)
            {
                JSONObject json = new JSONObject();
                Field[] campos = classe.getDeclaredFields();
                for(Field campo : campos )
                {

                    if (Modifier.isStatic(campo.getModifiers()))
                    {
                        // pula staticos
                        continue;
                    }
                    try {

                        campo.setAccessible(true);
                        if(campo.getType()==boolean.class)
                            json.put(campo.getName(), campo.getBoolean(objeto));
                        else if(campo.getType()==double.class)
                            json.put(campo.getName(), campo.getDouble(objeto));
                        else if(campo.getType()==float.class)
                            json.put(campo.getName(), campo.getFloat(objeto));
                        else if(campo.getType()==int.class)
                            json.put(campo.getName(), campo.getInt(objeto));
                        else if(campo.getType()==long.class)
                            json.put(campo.getName(), campo.getLong(objeto));
                        else if(campo.getType()==String.class)
                            json.put(campo.getName(), campo.get(objeto));
                        else if(campo.getType()==Date.class)
                        {
                            SimpleDateFormat format = new SimpleDateFormat("Z");
                            format.setTimeZone(TimeZone.getDefault());
                            String dt = "/Date(" + String.valueOf(((Date)campo.get(objeto)).getTime()) + format.format(((Date)campo.get(objeto))) + ")/";
                            json.put(campo.getName(), dt);
                        }
                        else if(campo.getType()==short.class)
                            json.put(campo.getName(), campo.getShort(objeto));
                        else if(campo.getType()==byte.class)
                            json.put(campo.getName(), campo.getByte(objeto));
                        else if(campo.getType()==List.class || campo.getType()==ArrayList.class)
                        {

                            Class<?> parametro = (Class<?>)(((ParameterizedType)campo.getGenericType()).getActualTypeArguments()[0]);
                            boolean recursivo = false; //
                            campo.setAccessible(true);
                            if(parametro==boolean.class)
                                recursivo = false;
                            else if(parametro==double.class)
                                recursivo = false;
                            else if(parametro==float.class)
                                recursivo = false;
                            else if(parametro==int.class)
                                recursivo = false;
                            else if(parametro==long.class)
                                recursivo = false;
                            else if(parametro==String.class)
                                recursivo = false;
                            else if(parametro==Date.class)
                                recursivo = false;
                            else if(parametro==short.class)
                                recursivo = false;
                            else if(parametro==byte.class)
                                recursivo = false;
                            else
                            {
                                recursivo = true;
                            }

                            if(recursivo)
                            {
                                @SuppressWarnings("unchecked")
                                List<Object> lista = (ArrayList<Object>)campo.get(objeto);
                                JSONArray jArray = new JSONArray();
                                for (Object item : lista)
                                    jArray.put(JSONSerializer.serialize(item.getClass(), item));
                                json.put(campo.getName(), jArray);


                            }else
                            {
                                @SuppressWarnings("unchecked")
                                ArrayList<Object> lista = (ArrayList<Object>)campo.get(objeto);
                                JSONArray jArray = new JSONArray();
                                for (Object item : lista)
                                    jArray.put(item);
                                json.put(campo.getName(), jArray);

                            }


                        }
                        else json.put(campo.getName(),JSONSerializer.serialize(campo.getType(), campo.get(objeto)) );

                    }
                    catch (IllegalArgumentException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        json.put(campo.getName(), null);
                    }
                    catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        json.put(campo.getName(), null);
                    } catch (IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
                return json;
            }else
                return null;
        }else
            return null;

    }






}
