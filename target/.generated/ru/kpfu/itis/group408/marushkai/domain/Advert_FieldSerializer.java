package ru.kpfu.itis.group408.marushkai.domain;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Advert_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.Integer getId(ru.kpfu.itis.group408.marushkai.domain.Advert instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Advert::id;
  }-*/;
  
  private static native void setId(ru.kpfu.itis.group408.marushkai.domain.Advert instance, java.lang.Integer value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Advert::id = value;
  }-*/;
  
  private static native java.lang.String getImage(ru.kpfu.itis.group408.marushkai.domain.Advert instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Advert::image;
  }-*/;
  
  private static native void setImage(ru.kpfu.itis.group408.marushkai.domain.Advert instance, java.lang.String value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Advert::image = value;
  }-*/;
  
  private static native java.lang.String getLink(ru.kpfu.itis.group408.marushkai.domain.Advert instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Advert::link;
  }-*/;
  
  private static native void setLink(ru.kpfu.itis.group408.marushkai.domain.Advert instance, java.lang.String value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Advert::link = value;
  }-*/;
  
  private static native java.lang.String getText(ru.kpfu.itis.group408.marushkai.domain.Advert instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Advert::text;
  }-*/;
  
  private static native void setText(ru.kpfu.itis.group408.marushkai.domain.Advert instance, java.lang.String value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Advert::text = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, ru.kpfu.itis.group408.marushkai.domain.Advert instance) throws SerializationException {
    com.google.gwt.core.client.impl.WeakMapping.set(instance, "server-enhanced-data-1", streamReader.readString());
    setId(instance, (java.lang.Integer) streamReader.readObject());
    setImage(instance, streamReader.readString());
    setLink(instance, streamReader.readString());
    setText(instance, streamReader.readString());
    
  }
  
  public static ru.kpfu.itis.group408.marushkai.domain.Advert instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ru.kpfu.itis.group408.marushkai.domain.Advert();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ru.kpfu.itis.group408.marushkai.domain.Advert instance) throws SerializationException {
    streamWriter.writeString((String) com.google.gwt.core.client.impl.WeakMapping.get(instance, "server-enhanced-data-1"));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getImage(instance));
    streamWriter.writeString(getLink(instance));
    streamWriter.writeString(getText(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return ru.kpfu.itis.group408.marushkai.domain.Advert_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    ru.kpfu.itis.group408.marushkai.domain.Advert_FieldSerializer.deserialize(reader, (ru.kpfu.itis.group408.marushkai.domain.Advert)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    ru.kpfu.itis.group408.marushkai.domain.Advert_FieldSerializer.serialize(writer, (ru.kpfu.itis.group408.marushkai.domain.Advert)object);
  }
  
}
