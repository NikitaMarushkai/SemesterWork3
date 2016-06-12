package ru.kpfu.itis.group408.marushkai.domain;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Contestant_Array_Rank_1_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, ru.kpfu.itis.group408.marushkai.domain.Contestant[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static ru.kpfu.itis.group408.marushkai.domain.Contestant[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new ru.kpfu.itis.group408.marushkai.domain.Contestant[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ru.kpfu.itis.group408.marushkai.domain.Contestant[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return ru.kpfu.itis.group408.marushkai.domain.Contestant_Array_Rank_1_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    ru.kpfu.itis.group408.marushkai.domain.Contestant_Array_Rank_1_FieldSerializer.deserialize(reader, (ru.kpfu.itis.group408.marushkai.domain.Contestant[])object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    ru.kpfu.itis.group408.marushkai.domain.Contestant_Array_Rank_1_FieldSerializer.serialize(writer, (ru.kpfu.itis.group408.marushkai.domain.Contestant[])object);
  }
  
}
