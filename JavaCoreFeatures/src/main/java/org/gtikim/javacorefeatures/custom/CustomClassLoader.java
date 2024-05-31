package org.gtikim.javacorefeatures.custom;

import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.util.Objects;

@Log4j2
public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] content = loadClassFromFile(name);
        return defineClass(name, content, 0, content.length);
    }

    private byte[] loadClassFromFile(String name) {
        byte[] buffer = null;

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                name.replace('.', File.separatorChar) + ".class")) {

            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            int nextValue = 0;

            while ( (nextValue = Objects.requireNonNull(inputStream).read()) != -1 ) {
                byteStream.write(nextValue);
            }

            buffer = byteStream.toByteArray();
            return buffer;
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return buffer;
    }
}
