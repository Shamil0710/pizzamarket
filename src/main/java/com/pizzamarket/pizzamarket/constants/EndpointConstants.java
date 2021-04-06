package com.pizzamarket.pizzamarket.constants;


public final class EndpointConstants {
    private EndpointConstants() {};

    public static final String ROOT = "root";

    /** Продукт **/

    public static final String PRODUCT = ROOT + "/product";

    public static final String PRODUCT_GET_ALL = PRODUCT + "/all";

    public static final String PRODUCT_GET_BY_TAGS = PRODUCT + "/getTagged";

    public static final String PRODUCT_GET_PAGE = PRODUCT + "/{page}/{pageSize}";

    public static final String PRODUCT_PUT_CREATE = PRODUCT + "/create";

    public static final String PRODUCT_UPGRADE = PRODUCT + "/upgrade";

    public static final String PRODUCT_DELETE = PRODUCT + "/delte";

    /** Юсер **/

    public static final String USER = ROOT + "/user";

    public static final String USER_GET_BY_USERID = USER + "/{userId}";

    public static final String USER_GET_BY_PHONENUMBER = USER + "/{phoneNumber}";

    public static final String USER_GET_ALL = USER + "/all";

    public static final String USER_PUT_CREATE = USER + "/create";

    /** Заказ **/

    public static final String ORDER = ROOT + "/order";

    public static final String ORDER_PUT_CREATE = ORDER + "/create";

    public static final String ORDER_DELETE = ORDER + "/delete";

    public static final String ORDER_GET_ALL = ORDER + "/all";

    public static final String ORDER_GET_BY_PHONENUMBER = ORDER + "/phonenumber";

    /** Карзина **/

    public static final String BASKET = ROOT + "/basket";

    public static final String BASKET_PUT_CREATE = BASKET + "/create";

    public static final String BASKET_PUT_ADD_TO_BASKET = BASKET + "/add";

    public static final String BASKET_DELETE_PRODUCT_IN_BASKET = BASKET + "/delete";

    public static final String BASKET_GET_BASKET = BASKET + "/get";


}
