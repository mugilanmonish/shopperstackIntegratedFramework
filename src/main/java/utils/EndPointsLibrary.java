package utils;

public interface EndPointsLibrary {
	String shopperLogin = "/users/login";
	String getProduct = "/products";
	String getAllProduct = "/products/alpha";
	String getAllProductsFromCart = "/shoppers/{shopperId}/carts";
}
