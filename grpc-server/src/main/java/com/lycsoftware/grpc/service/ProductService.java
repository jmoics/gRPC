package com.lycsoftware.grpc.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.lycsoftware.grpc.protobuf.ProductProtoRecord;
import com.lycsoftware.grpc.protobuf.ProductProtoRecordList;
import com.lycsoftware.grpc.protobuf.ProductProtoRequest;
import com.lycsoftware.grpc.protobuf.ProductProtoServiceGrpc.ProductProtoServiceImplBase;
import com.lycsoftware.grpc.util.Data;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductService
    extends ProductProtoServiceImplBase
{
    @Autowired
    private Data data;

    @Override
    public void getProductProtoRecords(final ProductProtoRequest request,
                                       final StreamObserver<ProductProtoRecordList> responseObserver)
    {
        final ProductProtoRecordList.Builder list = ProductProtoRecordList.newBuilder();
        if (StringUtils.isNotBlank(request.getId())) {
            this.data.getProductsById(request.getId()).stream().forEach(data -> {
                final ProductProtoRecord rec = ProductProtoRecord.newBuilder().setId(data.getId())
                                .setContactId(data.getContactId()).setLocationId(data.getLocationId())
                                .setProductId(data.getProductId()).setProductName(data.getProductName())
                                .setPrice(data.getPrice()).build();
                list.addProductList(rec);
            });
        } else if (StringUtils.isNotBlank(request.getContactId())) {
            this.data.getProductsByContact(request.getContactId()).stream().forEach(data -> {
                final ProductProtoRecord rec = ProductProtoRecord.newBuilder().setId(data.getId())
                                .setContactId(data.getContactId()).setLocationId(data.getLocationId())
                                .setProductId(data.getProductId()).setProductName(data.getProductName())
                                .setPrice(data.getPrice()).build();
                list.addProductList(rec);
            });
        } else {
            this.data.getAllProducts().stream().forEach(data -> {
                final ProductProtoRecord rec = ProductProtoRecord.newBuilder().setId(data.getId())
                                .setContactId(data.getContactId()).setLocationId(data.getLocationId())
                                .setProductId(data.getProductId()).setProductName(data.getProductName())
                                .setPrice(data.getPrice()).build();
                list.addProductList(rec);
            });
        }

        list.setTotalRecords(list.getProductListCount());
        responseObserver.onNext(list.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getProductProtoRecordsStream(final ProductProtoRequest request,
                                             final StreamObserver<ProductProtoRecord> responseObserver)
    {
        // TODO Auto-generated method stub
        super.getProductProtoRecordsStream(request, responseObserver);
    }

}
