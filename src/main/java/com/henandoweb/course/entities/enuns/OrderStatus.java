package com.henandoweb.course.entities.enuns;

public enum OrderStatus {
	WAITING_PAYMENT("Aguardando Pagamento"),
	PAID("pago"),
	SHIPPED("Pedido Enviado"),
	DELIVERED("Pedido Entrege"),
	CANCELED("Pedido Cancelado");
	
	private String code;
	
	private  OrderStatus (String code) {
		this.code = code;
	}
	
	public String getCode(){
		return code;
	}
	public static OrderStatus value(String code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code ) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
