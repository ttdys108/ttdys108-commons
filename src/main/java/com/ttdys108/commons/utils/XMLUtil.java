package com.ttdys108.commons.utils;

import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;

@Slf4j
public class XMLUtil {

    /**
     * 将xml转化为实体类
     * @param xml xml string
     * @param <T> entity
     * @return entity
     */
    public static <T> T unmarshal(String xml, Class<T> cls) {
        try (ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes())){
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(is);
            DOMSource source = new DOMSource(doc);

            Unmarshaller unmarshaller = JAXBContext.newInstance(cls).createUnmarshaller();
            return (T) unmarshaller.unmarshal(source);
        } catch (Exception e) {
            log.error("error occur when parsing xml:{}", xml, e);
            throw new RuntimeException(e);
        }

    }

    public static <T> String marshal(T entity) {
        try (StringWriter writer = new StringWriter()){
            Marshaller marshaller = JAXBContext.newInstance(entity.getClass()).createMarshaller();
            marshaller.marshal(entity, writer);
            return writer.getBuffer().toString();
        } catch (Exception e) {
            log.error("error occur when parsing entity:{}", entity, e);
            throw new RuntimeException(e);
        }
    }


}
