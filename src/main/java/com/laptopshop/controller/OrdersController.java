package com.laptopshop.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.websocket.server.PathParam;

import com.laptopshop.entities.ChiTietDonHang;
import com.laptopshop.entities.DonHang;
import com.laptopshop.entities.ResponseObject;
import com.laptopshop.entities.SanPham;
import com.laptopshop.models.Item;
import com.laptopshop.models.OrderRequest;
import com.laptopshop.service.DonHangService;
import com.laptopshop.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private DonHangService donHangService;

    @GetMapping("/order/create/{donHangId}")
    public ResponseObject createOrder(@PathVariable("donHangId") String donHangId) throws JSONException {
        ResponseObject responseObject = new ResponseObject();
        DonHang dh = donHangService.findById(Long.valueOf(donHangId));

        JSONObject jsonObj = new JSONObject(String.valueOf(dh.getDiaChiNhan()));

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setToName(dh.getHoTenNguoiNhan());
        orderRequest.setToPhone(dh.getSdtNhanHang());
        orderRequest.setToAddress(jsonObj.getString("address"));
        orderRequest.setToWardCode(jsonObj.getString("wardId"));
        orderRequest.setToDistrictId(Integer.valueOf(jsonObj.getString("districtId")));
        orderRequest.setWeight(1500);
        orderRequest.setLength(15);
        orderRequest.setWidth(15);
        orderRequest.setHeight(10);
        orderRequest.setServiceTypeId(2);
        orderRequest.setServiceId(53320);
        orderRequest.setPaymentTypeId(1);
        orderRequest.setRequiredNote("CHOXEMHANGKHONGTHU");

        // san pham
        List<Item> items = new ArrayList<>();
        List<ChiTietDonHang> dsCtdh = dh.getDanhSachChiTiet();
        for (ChiTietDonHang chiTietDonHang : dsCtdh) {
            Item item = new Item();
            SanPham sanPham = chiTietDonHang.getSanPham();
            item.setName(sanPham.getTenSanPham());
            item.setCode(String.valueOf(sanPham.getId()));
            item.setQuantity(chiTietDonHang.getSoLuongDat());
            item.setPrice(Integer.parseInt(String.valueOf(chiTietDonHang.getDonGia()*chiTietDonHang.getSoLuongDat())));
            items.add(item);
        }
        orderRequest.setItems(items);
        try {
            responseObject.setStatus(HttpStatus.OK.toString());
            responseObject.setData(orderService.createOrder(orderRequest));
        } catch (RuntimeException ex) {
            JSONObject jsonObjRes = new JSONObject(ex.getMessage());
            System.out.println("ex" + ex.getMessage());
            responseObject.setStatus(jsonObjRes.getString("code"));
            responseObject.setData(ex.getMessage());
        }
        return responseObject;
    }
}
