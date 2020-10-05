package com.lycsoftware.grpc.util;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DataObject
{
    private String id;
    private String contactId;
    private String locationId;
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public String getId()
    {
        return this.id;
    }

    public void setId(final String id)
    {
        this.id = id;
    }

    public String getContactId()
    {
        return this.contactId;
    }

    public void setContactId(final String contactId)
    {
        this.contactId = contactId;
    }

    public String getLocationId()
    {
        return this.locationId;
    }

    public void setLocationId(final String locationId)
    {
        this.locationId = locationId;
    }

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(final String productId)
    {
        this.productId = productId;
    }

    public String getProductName()
    {
        return this.productName;
    }

    public void setProductName(final String productName)
    {
        this.productName = productName;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(final int quantity)
    {
        this.quantity = quantity;
    }

    public double getPrice()
    {
        return this.price;
    }

    public void setPrice(final double price)
    {
        this.price = price;
    }

}
