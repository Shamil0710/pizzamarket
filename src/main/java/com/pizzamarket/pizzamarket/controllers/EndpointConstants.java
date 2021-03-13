package com.pizzamarket.pizzamarket.controllers;

public final class EndpointConstants {
    private EndpointConstants() {};

    public static final String ROOT = "root";

    /** Продукт **/

    public static final String PRODUCT = ROOT + "/product";

    public static final String GET_ALL = "/all";

    public static final String GET_BY_TAGS = "/getTagged";

    public static final String GET_PRODUCT_PAGE = "/{page}/{pageSize}";

    public static final String PUT_CREATE = "/create";

    public static final String UPGRADE_PRODUCT = "/upgrade";

    /** Юсер **/

    public static final String USER = ROOT + "/user";

    public static final String GET_BY_USERID = "{userId}";

    public static final String GET_BY_PHONENUMBER = "{phoneNumber}";

    /** Заказ **/



}
