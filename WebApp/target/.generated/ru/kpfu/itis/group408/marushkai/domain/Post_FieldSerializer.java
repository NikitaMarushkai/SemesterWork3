package ru.kpfu.itis.group408.marushkai.domain;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Post_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getContent(ru.kpfu.itis.group408.marushkai.domain.Post instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Post::content;
  }-*/;
  
  private static native void setContent(ru.kpfu.itis.group408.marushkai.domain.Post instance, java.lang.String value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Post::content = value;
  }-*/;
  
  private static native java.lang.String getCreationDate(ru.kpfu.itis.group408.marushkai.domain.Post instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Post::creationDate;
  }-*/;
  
  private static native void setCreationDate(ru.kpfu.itis.group408.marushkai.domain.Post instance, java.lang.String value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Post::creationDate = value;
  }-*/;
  
  private static native java.lang.Integer getId(ru.kpfu.itis.group408.marushkai.domain.Post instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Post::id;
  }-*/;
  
  private static native void setId(ru.kpfu.itis.group408.marushkai.domain.Post instance, java.lang.Integer value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Post::id = value;
  }-*/;
  
  private static native java.lang.String getImage(ru.kpfu.itis.group408.marushkai.domain.Post instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Post::image;
  }-*/;
  
  private static native void setImage(ru.kpfu.itis.group408.marushkai.domain.Post instance, java.lang.String value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Post::image = value;
  }-*/;
  
  private static native java.lang.String getName(ru.kpfu.itis.group408.marushkai.domain.Post instance) /*-{
    return instance.@ru.kpfu.itis.group408.marushkai.domain.Post::name;
  }-*/;
  
  private static native void setName(ru.kpfu.itis.group408.marushkai.domain.Post instance, java.lang.String value) 
  /*-{
    instance.@ru.kpfu.itis.group408.marushkai.domain.Post::name = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, ru.kpfu.itis.group408.marushkai.domain.Post instance) throws SerializationException {
    com.google.gwt.core.client.impl.WeakMapping.set(instance, "server-enhanced-data-1", streamReader.readString());
    setContent(instance, streamReader.readString());
    setCreationDate(instance, streamReader.readString());
    setId(instance, (java.lang.Integer) streamReader.readObject());
    setImage(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    
  }
  
  public static ru.kpfu.itis.group408.marushkai.domain.Post instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new ru.kpfu.itis.group408.marushkai.domain.Post();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, ru.kpfu.itis.group408.marushkai.domain.Post instance) throws SerializationException {
    streamWriter.writeString((String) com.google.gwt.core.client.impl.WeakMapping.get(instance, "server-enhanced-data-1"));
    streamWriter.writeString(getContent(instance));
    streamWriter.writeString(getCreationDate(instance));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getImage(instance));
    streamWriter.writeString(getName(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return ru.kpfu.itis.group408.marushkai.domain.Post_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    ru.kpfu.itis.group408.marushkai.domain.Post_FieldSerializer.deserialize(reader, (ru.kpfu.itis.group408.marushkai.domain.Post)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    ru.kpfu.itis.group408.marushkai.domain.Post_FieldSerializer.serialize(writer, (ru.kpfu.itis.group408.marushkai.domain.Post)object);
  }
  
}
