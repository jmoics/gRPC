package com.lycsoftware.grpc.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Data
{
    @Value("classpath:products.json")
    private Resource resourceFile;

    public List<DataObject> getAllProducts()
    {
        final ObjectMapper mapper = new ObjectMapper();
        final List<DataObject> lst = new ArrayList<>();
        try {
            final DataObject[] objs = mapper.readValue(this.resourceFile.getFile(), DataObject[].class);
            lst.addAll(Arrays.asList(objs));
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return lst;
    }

    public List<DataObject> getProductsById(final String id)
    {
        final ObjectMapper mapper = new ObjectMapper();
        final List<DataObject> lst = new ArrayList<>();
        try {
            final DataObject[] objs = mapper.readValue(this.resourceFile.getFile(), DataObject[].class);
            lst.addAll(Arrays.asList(objs).stream().filter(data -> id.equals(data.getId()))
                            .collect(Collectors.toList()));
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return lst;
    }

    public List<DataObject> getProductsByContact(final String contractId)
    {
        final ObjectMapper mapper = new ObjectMapper();
        final List<DataObject> lst = new ArrayList<>();
        try {
            final DataObject[] objs = mapper.readValue(this.resourceFile.getFile(), DataObject[].class);
            lst.addAll(Arrays.asList(objs).stream().filter(data -> contractId.equals(data.getContactId()))
                            .collect(Collectors.toList()));
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return lst;
    }

}