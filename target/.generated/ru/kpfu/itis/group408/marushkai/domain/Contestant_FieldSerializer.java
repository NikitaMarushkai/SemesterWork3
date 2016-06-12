package ru.kpfu.itis.group408.marushkai.domain;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Contestant_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getContest(ru.kpfu.itis.group408.marushkai.domain.Contestant instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Contestant::contest;
  }-*/;
  
  private static native void setContest(ru.kpfu.itis.group408.marushkai.domain.Contestant instance, java.lang.String value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Contestant::contest = value;
  }-*/;
  
  private static native java.lang.Integer getId(ru.kpfu.itis.group408.marushkai.domain.Contestant instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Contestant::id;
  }-*/;
  
  private static native void setId(ru.kpfu.itis.group408.marushkai.domain.Contestant instance, java.lang.Integer value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Contestant::id = value;
  }-*/;
  
  private static native java.lang.String getRegion(ru.kpfu.itis.group408.marushkai.domain.Contestant instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Contestant::region;
  }-*/;
  
  private static native void setRegion(ru.kpfu.itis.group408.marushkai.domain.Contestant instance, java.lang.String value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Contestant::region = value;
  }-*/;
  
  private static native java.lang.String getTeam1(ru.kpfu.itis.group408.marushkai.domain.Contestant instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Contestant::team1;
  }-*/;
  
  private static native void setTeam1(ru.kpfu.itis.group408.marushkai.domain.Contestant instance, java.lang.String value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Contestant::team1 = value;
  }-*/;
  
  private static native java.lang.String getTeam2(ru.kpfu.itis.group408.marushkai.domain.Contestant instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Contestant::team2;
  }-*/;
  
  private static native void setTeam2(ru.kpfu.itis.group408.marushkai.domain.Contestant instance, java.lang.String value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Contestant::team2 = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, ru.kpfu.itis.group408.marushkai.domain.Contestant instance) throws SerializationException {
    com.google.gwt.core.client.impl.WeakMapping.set(instance, "server-enhanced-data-1", streamReader.readString());
    setContest(instance, streamReader.readString());
    setId(instance, (java.lang.Integer) streamReader.readObject());
    setRegion(instance, streamReader.readString());
    setTeam1(instance, streamReader.readString());
    setTeam2(instance, streamReader.readString());
    
  }
  
  public static ru.kpfu.itis.group408.marushkai.domain.Contestant instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ru.kpfu.itis.group408.marushkai.domain.Contestant();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ru.kpfu.itis.group408.marushkai.domain.Contestant instance) throws SerializationException {
    streamWriter.writeString((String) com.google.gwt.core.client.impl.WeakMapping.get(instance, "server-enhanced-data-1"));
    streamWriter.writeString(getContest(instance));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getRegion(instance));
    streamWriter.writeString(getTeam1(instance));
    streamWriter.writeString(getTeam2(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return ru.kpfu.itis.group408.marushkai.domain.Contestant_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    ru.kpfu.itis.group408.marushkai.domain.Contestant_FieldSerializer.deserialize(reader, (ru.kpfu.itis.group408.marushkai.domain.Contestant)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    ru.kpfu.itis.group408.marushkai.domain.Contestant_FieldSerializer.serialize(writer, (ru.kpfu.itis.group408.marushkai.domain.Contestant)object);
  }
  
}
