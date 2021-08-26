package com.newsaleapi.vo;

import java.util.List;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class DeliverySlipVo {

	private List<BarcodeVo> barcode;

	private int qty;

	private String type;

	private Long salesMan;

}
