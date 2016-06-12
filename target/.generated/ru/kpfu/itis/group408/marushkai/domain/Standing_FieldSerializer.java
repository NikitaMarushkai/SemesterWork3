package ru.kpfu.itis.group408.marushkai.domain;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Standing_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.Integer getBullitFaults(ru.kpfu.itis.group408.marushkai.domain.Standing instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::bullitFaults;
  }-*/;
  
  private static native void setBullitFaults(ru.kpfu.itis.group408.marushkai.domain.Standing instance, java.lang.Integer value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::bullitFaults = value;
  }-*/;
  
  private static native java.lang.Integer getBullitWins(ru.kpfu.itis.group408.marushkai.domain.Standing instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::bullitWins;
  }-*/;
  
  private static native void setBullitWins(ru.kpfu.itis.group408.marushkai.domain.Standing instance, java.lang.Integer value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::bullitWins = value;
  }-*/;
  
  private static native java.lang.Integer getFaults(ru.kpfu.itis.group408.marushkai.domain.Standing instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::faults;
  }-*/;
  
  private static native void setFaults(ru.kpfu.itis.group408.marushkai.domain.Standing instance, java.lang.Integer value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::faults = value;
  }-*/;
  
  private static native java.lang.Integer getGames(ru.kpfu.itis.group408.marushkai.domain.Standing instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::games;
  }-*/;
  
  private static native void setGames(ru.kpfu.itis.group408.marushkai.domain.Standing instance, java.lang.Integer value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::games = value;
  }-*/;
  
  private static native java.lang.Integer getGoals(ru.kpfu.itis.group408.marushkai.domain.Standing instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::goals;
  }-*/;
  
  private static native void setGoals(ru.kpfu.itis.group408.marushkai.domain.Standing instance, java.lang.Integer value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::goals = value;
  }-*/;
  
  private static native java.lang.Integer getId(ru.kpfu.itis.group408.marushkai.domain.Standing instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::id;
  }-*/;
  
  private static native void setId(ru.kpfu.itis.group408.marushkai.domain.Standing instance, java.lang.Integer value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::id = value;
  }-*/;
  
  private static native java.lang.Integer getOverTimeFaults(ru.kpfu.itis.group408.marushkai.domain.Standing instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::overTimeFaults;
  }-*/;
  
  private static native void setOverTimeFaults(ru.kpfu.itis.group408.marushkai.domain.Standing instance, java.lang.Integer value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::overTimeFaults = value;
  }-*/;
  
  private static native java.lang.Integer getOverTimeWins(ru.kpfu.itis.group408.marushkai.domain.Standing instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::overTimeWins;
  }-*/;
  
  private static native void setOverTimeWins(ru.kpfu.itis.group408.marushkai.domain.Standing instance, java.lang.Integer value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::overTimeWins = value;
  }-*/;
  
  private static native java.lang.Integer getScore(ru.kpfu.itis.group408.marushkai.domain.Standing instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::score;
  }-*/;
  
  private static native void setScore(ru.kpfu.itis.group408.marushkai.domain.Standing instance, java.lang.Integer value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::score = value;
  }-*/;
  
  private static native java.lang.String getSide(ru.kpfu.itis.group408.marushkai.domain.Standing instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::side;
  }-*/;
  
  private static native void setSide(ru.kpfu.itis.group408.marushkai.domain.Standing instance, java.lang.String value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::side = value;
  }-*/;
  
  private static native java.lang.String getTeam(ru.kpfu.itis.group408.marushkai.domain.Standing instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::team;
  }-*/;
  
  private static native void setTeam(ru.kpfu.itis.group408.marushkai.domain.Standing instance, java.lang.String value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::team = value;
  }-*/;
  
  private static native java.lang.Integer getWins(ru.kpfu.itis.group408.marushkai.domain.Standing instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::wins;
  }-*/;
  
  private static native void setWins(ru.kpfu.itis.group408.marushkai.domain.Standing instance, java.lang.Integer value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Standing::wins = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, ru.kpfu.itis.group408.marushkai.domain.Standing instance) throws SerializationException {
    com.google.gwt.core.client.impl.WeakMapping.set(instance, "server-enhanced-data-1", streamReader.readString());
    setBullitFaults(instance, (java.lang.Integer) streamReader.readObject());
    setBullitWins(instance, (java.lang.Integer) streamReader.readObject());
    setFaults(instance, (java.lang.Integer) streamReader.readObject());
    setGames(instance, (java.lang.Integer) streamReader.readObject());
    setGoals(instance, (java.lang.Integer) streamReader.readObject());
    setId(instance, (java.lang.Integer) streamReader.readObject());
    setOverTimeFaults(instance, (java.lang.Integer) streamReader.readObject());
    setOverTimeWins(instance, (java.lang.Integer) streamReader.readObject());
    setScore(instance, (java.lang.Integer) streamReader.readObject());
    setSide(instance, streamReader.readString());
    setTeam(instance, streamReader.readString());
    setWins(instance, (java.lang.Integer) streamReader.readObject());
    
  }
  
  public static ru.kpfu.itis.group408.marushkai.domain.Standing instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ru.kpfu.itis.group408.marushkai.domain.Standing();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ru.kpfu.itis.group408.marushkai.domain.Standing instance) throws SerializationException {
    streamWriter.writeString((String) com.google.gwt.core.client.impl.WeakMapping.get(instance, "server-enhanced-data-1"));
    streamWriter.writeObject(getBullitFaults(instance));
    streamWriter.writeObject(getBullitWins(instance));
    streamWriter.writeObject(getFaults(instance));
    streamWriter.writeObject(getGames(instance));
    streamWriter.writeObject(getGoals(instance));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeObject(getOverTimeFaults(instance));
    streamWriter.writeObject(getOverTimeWins(instance));
    streamWriter.writeObject(getScore(instance));
    streamWriter.writeString(getSide(instance));
    streamWriter.writeString(getTeam(instance));
    streamWriter.writeObject(getWins(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return ru.kpfu.itis.group408.marushkai.domain.Standing_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    ru.kpfu.itis.group408.marushkai.domain.Standing_FieldSerializer.deserialize(reader, (ru.kpfu.itis.group408.marushkai.domain.Standing)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    ru.kpfu.itis.group408.marushkai.domain.Standing_FieldSerializer.serialize(writer, (ru.kpfu.itis.group408.marushkai.domain.Standing)object);
  }
  
}
